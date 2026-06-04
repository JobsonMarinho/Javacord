package org.javacord.api.entity.message.component.internal;

import org.javacord.api.entity.message.component.Checkbox;
import org.javacord.api.entity.message.component.ComponentType;

public interface CheckboxBuilderDelegate extends ComponentBuilderDelegate {

    /**
     * Get the checkbox's type.
     *
     * @return Always {@link ComponentType#CHECKBOX}
     */
    ComponentType getType();

    /**
     * Copy a checkbox's values into the builder.
     *
     * @param checkbox The checkbox to copy.
     */
    void copy(Checkbox checkbox);

    /**
     * Get the checkbox's component identifier.
     *
     * @return The checkbox's component identifier.
     */
    String getCustomId();

    /**
     * Get whether the checkbox is checked by default.
     *
     * @return Whether the checkbox is checked by default.
     */
    boolean isDefault();

    /**
     * Get whether the checkbox is required.
     *
     * @return Whether the checkbox is required.
     */
    boolean isRequired();

    /**
     * Set the checkbox's custom ID.
     *
     * @param customId The checkbox's identifier.
     */
    void setCustomId(String customId);

    /**
     * Set whether the checkbox is checked by default.
     *
     * @param isDefault Whether the checkbox is checked by default.
     */
    void setDefault(boolean isDefault);

    /**
     * Set whether the checkbox is required.
     *
     * @param required Whether the checkbox is required or not.
     */
    void setRequired(boolean required);

    /**
     * Creates a {@link Checkbox} instance with the given values.
     *
     * @return The created checkbox instance.
     */
    Checkbox build();
}
