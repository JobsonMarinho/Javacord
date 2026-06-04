package org.javacord.api.entity.message.component;

import org.javacord.api.entity.message.component.internal.LabelBuilderDelegate;
import org.javacord.api.util.internal.DelegateFactory;

public class LabelBuilder implements HighLevelComponentBuilder {
    private final LabelBuilderDelegate delegate = DelegateFactory.createLabelBuilderDelegate();

    /**
     * Creates a new label builder.
     *
     * @param label     The label text.
     * @param component The component to wrap.
     */
    public LabelBuilder(String label, LowLevelComponent component) {
        setLabel(label);
        setComponent(component);
    }

    /**
     * Copy a label's values into this builder.
     *
     * @param label The label to copy.
     * @return The builder instance to chain methods.
     */
    public LabelBuilder copy(Label label) {
        delegate.copy(label);
        return this;
    }

    /**
     * Get the component's type (always {@link ComponentType#LABEL}).
     *
     * @return The component's type.
     */
    public ComponentType getType() {
        return delegate.getType();
    }

    /**
     * Set the label text.
     *
     * @param label The label text.
     * @return The current instance in order to chain call methods.
     */
    public LabelBuilder setLabel(String label) {
        delegate.setLabel(label);
        return this;
    }

    /**
     * Set the description of the label.
     *
     * @param description The description.
     * @return The current instance in order to chain call methods.
     */
    public LabelBuilder setDescription(String description) {
        delegate.setDescription(description);
        return this;
    }

    /**
     * Set the component wrapped by this label.
     *
     * @param component The component to wrap.
     * @return The current instance in order to chain call methods.
     */
    public LabelBuilder setComponent(LowLevelComponent component) {
        delegate.setComponent(component);
        return this;
    }

    /**
     * Creates a {@link Label} instance with the given values.
     *
     * @return The created label instance.
     */
    public Label build() {
        return delegate.build();
    }

    /**
     * Gets the delegate used by the component builder internally.
     *
     * @return The delegate used by this component builder internally.
     */
    @Override
    public LabelBuilderDelegate getDelegate() {
        return delegate;
    }
}
