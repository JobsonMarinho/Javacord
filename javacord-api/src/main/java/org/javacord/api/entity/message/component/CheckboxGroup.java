package org.javacord.api.entity.message.component;

import java.util.List;
import java.util.Optional;

/**
 * A multi-selectable group of checkboxes.
 *
 * <p>A checkbox group can only be used inside a modal and must be placed inside a {@link Label}.
 */
public interface CheckboxGroup extends LowLevelComponent {

    /**
     * Get the checkbox group's identifier.
     *
     * @return The checkbox group's custom identifier.
     */
    String getCustomId();

    /**
     * Get the options of the checkbox group.
     *
     * @return The options.
     */
    List<SelectableOption> getOptions();

    /**
     * Get the minimum amount of options which must be selected.
     *
     * @return The minimum amount of selected options.
     */
    Optional<Integer> getMinimumValues();

    /**
     * Get the maximum amount of options which can be selected.
     *
     * @return The maximum amount of selected options.
     */
    Optional<Integer> getMaximumValues();

    /**
     * Whether the checkbox group is required.
     *
     * @return Whether the checkbox group is required.
     */
    boolean isRequired();

    /**
     * Get the values selected by the user.
     *
     * <p>This is only populated when the checkbox group is received from a modal submit.
     *
     * @return The selected option values.
     */
    List<String> getSelectedValues();

    /**
     * Creates a new checkbox group with the given values.
     *
     * @param customId The custom ID for the checkbox group.
     * @param options  The options of the checkbox group.
     * @return The created checkbox group.
     */
    static CheckboxGroup create(String customId, SelectableOption... options) {
        return new CheckboxGroupBuilder(customId)
                .addOptions(options)
                .build();
    }
}
