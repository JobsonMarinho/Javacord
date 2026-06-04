subprojects {
    apply(plugin = "checkstyle")

    configure<CheckstyleExtension> {
        toolVersion = "10.26.1"
        maxWarnings = 0
    }
}