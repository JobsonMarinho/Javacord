package org.javacord.api.entity.message.component;

import java.util.List;
import java.util.Optional;

/**
 * A single-choice set of options rendered as radio buttons.
 *
 * <p>A radio group can only be used inside a modal and must be placed inside a {@link Label}.
 */
public interface RadioGroup extends LowLevelComponent {

    /**
     * Get the radio group's identifier.
     *
     * @return The radio group's custom identifier.
     */
    String getCustomId();

    /**
     * Get the options of the radio group.
     *
     * @return The options.
     */
    List<SelectableOption> getOptions();

    /**
     * Whether the radio group is required.
     *
     * @return Whether the radio group is required.
     */
    boolean isRequired();

    /**
     * Get the value selected by the user.
     *
     * <p>This is only populated when the radio group is received from a modal submit.
     *
     * @return The selected option value.
     */
    Optional<String> getSelectedValue();

    /**
     * Creates a new radio group with the given values.
     *
     * @param customId The custom ID for the radio group.
     * @param options  The options of the radio group.
     * @return The created radio group.
     */
    static RadioGroup create(String customId, SelectableOption... options) {
        return new RadioGroupBuilder(customId)
                .addOptions(options)
                .build();
    }
}
