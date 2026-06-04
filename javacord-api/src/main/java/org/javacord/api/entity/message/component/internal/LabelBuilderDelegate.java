package org.javacord.api.entity.message.component.internal;

import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.Label;
import org.javacord.api.entity.message.component.LowLevelComponent;

public interface LabelBuilderDelegate extends ComponentBuilderDelegate {

    /**
     * Get the label's type.
     *
     * @return Always {@link ComponentType#LABEL}
     */
    ComponentType getType();

    /**
     * Copy a label's values into the builder.
     *
     * @param label The label to copy.
     */
    void copy(Label label);

    /**
     * Set the label text.
     *
     * @param label The label text.
     */
    void setLabel(String label);

    /**
     * Set the description of the label.
     *
     * @param description The description.
     */
    void setDescription(String description);

    /**
     * Set the component wrapped by this label.
     *
     * @param component The component to wrap.
     */
    void setComponent(LowLevelComponent component);

    /**
     * Creates a {@link Label} instance with the given values.
     *
     * @return The created label instance.
     */
    Label build();
}
