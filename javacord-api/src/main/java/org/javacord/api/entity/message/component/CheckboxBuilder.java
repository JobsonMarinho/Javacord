package org.javacord.api.entity.message.component;

import org.javacord.api.entity.message.component.internal.CheckboxBuilderDelegate;
import org.javacord.api.util.internal.DelegateFactory;

public class CheckboxBuilder implements LowLevelComponentBuilder {
    private final CheckboxBuilderDelegate delegate = DelegateFactory.createCheckboxBuilderDelegate();

    /**
     * Creates a new checkbox builder.
     *
     * @param customId The custom id of the checkbox.
     */
    public CheckboxBuilder(String customId) {
        setCustomId(customId);
    }

    /**
     * Copy a checkbox's values into this builder.
     *
     * @param checkbox The checkbox to copy.
     * @return The builder instance to chain methods.
     */
    public CheckboxBuilder copy(Checkbox checkbox) {
        delegate.copy(checkbox);
        return this;
    }

    /**
     * Get the component's type (always {@link ComponentType#CHECKBOX}).
     *
     * @return The component's type.
     */
    public ComponentType getType() {
        return delegate.getType();
    }

    /**
     * Set the checkbox's custom ID.
     *
     * @param customId The checkbox's identifier.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxBuilder setCustomId(String customId) {
        delegate.setCustomId(customId);
        return this;
    }

    /**
     * Set whether the checkbox is checked by default.
     *
     * @param isDefault Whether the checkbox is checked by default.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxBuilder setDefault(boolean isDefault) {
        delegate.setDefault(isDefault);
        return this;
    }

    /**
     * Set whether the checkbox is required.
     *
     * @param required Whether the checkbox is required or not.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxBuilder setRequired(boolean required) {
        delegate.setRequired(required);
        return this;
    }

    /**
     * Creates a {@link Checkbox} instance with the given values.
     *
     * @return The created checkbox instance.
     */
    public Checkbox build() {
        return delegate.build();
    }

    /**
     * Gets the delegate used by the component builder internally.
     *
     * @return The delegate used by this component builder internally.
     */
    @Override
    public CheckboxBuilderDelegate getDelegate() {
        return delegate;
    }
}
