package org.javacord.api.entity.message.component.internal;

import org.javacord.api.entity.message.component.SelectableOption;

public interface SelectableOptionBuilderDelegate {

    /**
     * Copy the given selectable option.
     *
     * @param option The selectable option.
     */
    void copy(SelectableOption option);

    /**
     * Set the label of the option.
     *
     * @param label The label.
     */
    void setLabel(String label);

    /**
     * Set the value of the option.
     *
     * @param value The value.
     */
    void setValue(String value);

    /**
     * Set the description of the option.
     *
     * @param description The description.
     */
    void setDescription(String description);

    /**
     * Set if the option is selected by default.
     *
     * @param isDefault Is default.
     */
    void setDefault(boolean isDefault);

    /**
     * Build the selectable option.
     *
     * @return The option.
     */
    SelectableOption build();
}
