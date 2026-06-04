package org.javacord.api.entity.message.component;

import java.util.Optional;

/**
 * A selectable option used by the {@link RadioGroup} and {@link CheckboxGroup} components.
 */
public interface SelectableOption {

    /**
     * Get the label of the option.
     *
     * @return The label of the option.
     */
    String getLabel();

    /**
     * Get the value of the option.
     *
     * @return The value of the option.
     */
    String getValue();

    /**
     * Get the description of the option.
     *
     * @return The description of the option.
     */
    Optional<String> getDescription();

    /**
     * If the option is selected by default.
     *
     * @return Is default.
     */
    boolean isDefault();

    /**
     * Creates a new selectable option with the given values.
     *
     * @param label The label for the option.
     * @param value The value for the option.
     * @return The created selectable option.
     */
    static SelectableOption create(String label, String value) {
        return new SelectableOptionBuilder()
                .setLabel(label)
                .setValue(value)
                .build();
    }

    /**
     * Creates a new selectable option with the given values.
     *
     * @param label     The label for the option.
     * @param value     The value for the option.
     * @param isDefault If the option is selected by default.
     * @return The created selectable option.
     */
    static SelectableOption create(String label, String value, boolean isDefault) {
        return new SelectableOptionBuilder()
                .setLabel(label)
                .setValue(value)
                .setDefault(isDefault)
                .build();
    }

    /**
     * Creates a new selectable option with the given values.
     *
     * @param label       The label for the option.
     * @param value       The value for the option.
     * @param description The description for the option.
     * @return The created selectable option.
     */
    static SelectableOption create(String label, String value, String description) {
        return new SelectableOptionBuilder()
                .setLabel(label)
                .setValue(value)
                .setDescription(description)
                .build();
    }

    /**
     * Creates a new selectable option with the given values.
     *
     * @param label       The label for the option.
     * @param value       The value for the option.
     * @param description The description for the option.
     * @param isDefault   If the option is selected by default.
     * @return The created selectable option.
     */
    static SelectableOption create(String label, String value, String description, boolean isDefault) {
        return new SelectableOptionBuilder()
                .setLabel(label)
                .setValue(value)
                .setDescription(description)
                .setDefault(isDefault)
                .build();
    }
}
