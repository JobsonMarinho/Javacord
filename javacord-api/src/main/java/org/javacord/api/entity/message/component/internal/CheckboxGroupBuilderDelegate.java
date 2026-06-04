package org.javacord.api.entity.message.component.internal;

import org.javacord.api.entity.message.component.CheckboxGroup;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.SelectableOption;

import java.util.List;

public interface CheckboxGroupBuilderDelegate extends ComponentBuilderDelegate {

    /**
     * Get the checkbox group's type.
     *
     * @return Always {@link ComponentType#CHECKBOX_GROUP}
     */
    ComponentType getType();

    /**
     * Copy a checkbox group's values into the builder.
     *
     * @param checkboxGroup The checkbox group to copy.
     */
    void copy(CheckboxGroup checkboxGroup);

    /**
     * Get the checkbox group's component identifier.
     *
     * @return The checkbox group's component identifier.
     */
    String getCustomId();

    /**
     * Set the checkbox group's custom ID.
     *
     * @param customId The checkbox group's identifier.
     */
    void setCustomId(String customId);

    /**
     * Add an option to the checkbox group.
     *
     * @param option The option.
     */
    void addOption(SelectableOption option);

    /**
     * Add options to the checkbox group.
     *
     * @param options The options.
     */
    void addOptions(List<SelectableOption> options);

    /**
     * Remove an option from the checkbox group.
     *
     * @param option The option.
     */
    void removeOption(SelectableOption option);

    /**
     * Remove all options from the checkbox group.
     */
    void removeAllOptions();

    /**
     * Set the minimum amount of options which must be selected.
     *
     * @param minimumValues The minimum amount of selected options.
     */
    void setMinimumValues(Integer minimumValues);

    /**
     * Set the maximum amount of options which can be selected.
     *
     * @param maximumValues The maximum amount of selected options.
     */
    void setMaximumValues(Integer maximumValues);

    /**
     * Set whether the checkbox group is required.
     *
     * @param required Whether the checkbox group is required or not.
     */
    void setRequired(boolean required);

    /**
     * Creates a {@link CheckboxGroup} instance with the given values.
     *
     * @return The created checkbox group instance.
     */
    CheckboxGroup build();
}
