package org.javacord.api.entity.message.component;

import org.javacord.api.entity.message.component.internal.SelectableOptionBuilderDelegate;
import org.javacord.api.util.internal.DelegateFactory;

public class SelectableOptionBuilder {
    private final SelectableOptionBuilderDelegate delegate = DelegateFactory.createSelectableOptionBuilderDelegate();

    /**
     * Copy a selectable option's values into this builder.
     *
     * @param option The selectable option to copy.
     * @return The builder.
     */
    public SelectableOptionBuilder copy(SelectableOption option) {
        delegate.copy(option);
        return this;
    }

    /**
     * Set the label for the option.
     *
     * @param label The label.
     * @return The builder.
     */
    public SelectableOptionBuilder setLabel(String label) {
        delegate.setLabel(label);
        return this;
    }

    /**
     * Set the value for the option.
     *
     * @param value The value.
     * @return The builder.
     */
    public SelectableOptionBuilder setValue(String value) {
        delegate.setValue(value);
        return this;
    }

    /**
     * Set the description for the option.
     *
     * @param description The description.
     * @return The builder.
     */
    public SelectableOptionBuilder setDescription(String description) {
        delegate.setDescription(description);
        return this;
    }

    /**
     * Set whether the option is selected by default.
     *
     * @param isDefault If it is default.
     * @return The builder.
     */
    public SelectableOptionBuilder setDefault(boolean isDefault) {
        delegate.setDefault(isDefault);
        return this;
    }

    /**
     * Creates a {@link SelectableOption} instance with the given values.
     *
     * @return The created selectable option instance.
     */
    public SelectableOption build() {
        return delegate.build();
    }
}
