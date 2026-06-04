package org.javacord.api.entity.message.component;

/**
 * A single checkbox for a yes/no choice.
 *
 * <p>A checkbox can only be used inside a modal and must be placed inside a {@link Label}.
 */
public interface Checkbox extends LowLevelComponent {

    /**
     * Get the checkbox's identifier.
     *
     * @return The checkbox's custom identifier.
     */
    String getCustomId();

    /**
     * Whether the checkbox is checked by default.
     *
     * <p>This is the value used when the checkbox is sent to Discord.
     *
     * @return Whether the checkbox is checked by default.
     */
    boolean isDefault();

    /**
     * Whether the checkbox is required.
     *
     * @return Whether the checkbox is required.
     */
    boolean isRequired();

    /**
     * Whether the checkbox is checked.
     *
     * <p>When received from a modal submit this reflects the user's choice. For a checkbox that was
     * created locally this equals {@link #isDefault()}.
     *
     * @return Whether the checkbox is checked.
     */
    boolean isChecked();

    /**
     * Creates a new checkbox with the given custom id.
     *
     * @param customId The custom ID for the checkbox.
     * @return The created checkbox.
     */
    static Checkbox create(String customId) {
        return new CheckboxBuilder(customId).build();
    }

    /**
     * Creates a new checkbox with the given values.
     *
     * @param customId  The custom ID for the checkbox.
     * @param isDefault Whether the checkbox is checked by default.
     * @return The created checkbox.
     */
    static Checkbox create(String customId, boolean isDefault) {
        return new CheckboxBuilder(customId)
                .setDefault(isDefault)
                .build();
    }
}
