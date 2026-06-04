package org.javacord.api.entity.message.component.internal;

import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.RadioGroup;
import org.javacord.api.entity.message.component.SelectableOption;

import java.util.List;

public interface RadioGroupBuilderDelegate extends ComponentBuilderDelegate {

    /**
     * Get the radio group's type.
     *
     * @return Always {@link ComponentType#RADIO_GROUP}
     */
    ComponentType getType();

    /**
     * Copy a radio group's values into the builder.
     *
     * @param radioGroup The radio group to copy.
     */
    void copy(RadioGroup radioGroup);

    /**
     * Get the radio group's component identifier.
     *
     * @return The radio group's component identifier.
     */
    String getCustomId();

    /**
     * Set the radio group's custom ID.
     *
     * @param customId The radio group's identifier.
     */
    void setCustomId(String customId);

    /**
     * Add an option to the radio group.
     *
     * @param option The option.
     */
    void addOption(SelectableOption option);

    /**
     * Add options to the radio group.
     *
     * @param options The options.
     */
    void addOptions(List<SelectableOption> options);

    /**
     * Remove an option from the radio group.
     *
     * @param option The option.
     */
    void removeOption(SelectableOption option);

    /**
     * Remove all options from the radio group.
     */
    void removeAllOptions();

    /**
     * Set whether the radio group is required.
     *
     * @param required Whether the radio group is required or not.
     */
    void setRequired(boolean required);

    /**
     * Creates a {@link RadioGroup} instance with the given values.
     *
     * @return The created radio group instance.
     */
    RadioGroup build();
}
