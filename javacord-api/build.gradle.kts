import java.time.Instant

plugins {
    `java-library`
    id("biz.aQute.bnd.builder") version "7.1.0"
}

repositories {
    mavenCentral()
}

dependencies {
    // For old @Generated annotation in Java 9
    // can be replaced by javax.annotation.processing.Generated if Java 9 is minimum requirement
    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
    compileOnly("com.fasterxml.jackson.core:jackson-databind:2.20.0")
}

java {
    withJavadocJar()
    withSourcesJar()
}

/*
 * Generate a "git.properties" file with additional information about the current
 * version and the build timestamp. Used by the Javacord class to provide static
 * methods like "Javacord.VERSION" and "Javacord.COMMIT_ID".
 *
 * This used to rely on the "com.gorylenko.gradle-git-properties" plugin, but its
 * latest release is incompatible with Gradle 9 / Java 25, so we generate the few
 * properties the Javacord class actually reads ourselves via the git CLI.
 */
val gitPropertiesDir = layout.buildDirectory.dir("generated/sources/git-properties")
val generateGitProperties by tasks.registering {
    val outputDir = gitPropertiesDir
    val projectVersion = version.toString()
    val gitDir = rootProject.projectDir
    outputs.dir(outputDir)
    // The build timestamp changes on every run, so this task is intentionally not cacheable.
    outputs.upToDateWhen { false }
    doLast {
        val commitId = try {
            val process = ProcessBuilder("git", "rev-parse", "--short", "HEAD")
                .directory(gitDir)
                .redirectErrorStream(true)
                .start()
            val output = process.inputStream.bufferedReader().use { it.readText() }.trim()
            if (process.waitFor() == 0 && output.isNotEmpty()) output else "<unknown>"
        } catch (e: Exception) {
            "<unknown>"
        }
        val file = outputDir.get().file("git.properties").asFile
        file.parentFile.mkdirs()
        file.writeText(
            "version=$projectVersion\n"
                + "git.commit.id.abbrev=$commitId\n"
                + "buildTimestamp=${Instant.now()}\n"
        )
    }
}

sourceSets.main {
    resources.srcDir(generateGitProperties)
}

tasks.jar {
    bundle {
        val version by archiveVersion
        bnd(
            mapOf(
                "Export-Package" to listOf(
                    "!org.javacord.*.internal.*",
                    "*",
                    "version=$version",
                    "-noimport:=true"
                ).joinToString(";"),
                // work-around for https://github.com/bndtools/bnd/issues/2227
                "-fixupmessages" to "^Classes found in the wrong directory: \\\\{META-INF/versions/9/module-info\\\\.class=module-info}$"
            )
        )
    }
}

tasks.javadoc {
    options {
        this as StandardJavadocDocletOptions
        group("Public API", "*")
        group(
            "Internal Helpers",
            this@javadoc
                .source
                .files
                .asSequence()
                .map { "${it.toURI()}" }
                .filter { it.contains("/internal/") }
                .map { uri ->
                    sourceSets
                        .main
                        .get()
                        .java
                        .srcDirs
                        .joinToString(
                            separator = "|",
                            prefix = "^(?:",
                            postfix = """)(?:(?<!/)/)?|/[^/]*\.java$"""
                        ) { """\Q${it.toURI()}\E""" }
                        .toRegex()
                        .replace(uri, "")
                }
                .map { it.replace("/", ".") }
                .distinct()
                .toList()
        )
    }
}
