package org.javacord.api.entity.message.component;

import org.javacord.api.entity.message.component.internal.RadioGroupBuilderDelegate;
import org.javacord.api.util.internal.DelegateFactory;

import java.util.Arrays;
import java.util.List;

public class RadioGroupBuilder implements LowLevelComponentBuilder {
    private final RadioGroupBuilderDelegate delegate = DelegateFactory.createRadioGroupBuilderDelegate();

    /**
     * Creates a new radio group builder.
     *
     * @param customId The custom id of the radio group.
     */
    public RadioGroupBuilder(String customId) {
        setCustomId(customId);
    }

    /**
     * Copy a radio group's values into this builder.
     *
     * @param radioGroup The radio group to copy.
     * @return The builder instance to chain methods.
     */
    public RadioGroupBuilder copy(RadioGroup radioGroup) {
        delegate.copy(radioGroup);
        return this;
    }

    /**
     * Get the component's type (always {@link ComponentType#RADIO_GROUP}).
     *
     * @return The component's type.
     */
    public ComponentType getType() {
        return delegate.getType();
    }

    /**
     * Set the radio group's custom ID.
     *
     * @param customId The radio group's identifier.
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder setCustomId(String customId) {
        delegate.setCustomId(customId);
        return this;
    }

    /**
     * Add an option to the radio group.
     *
     * @param option The option.
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder addOption(SelectableOption option) {
        delegate.addOption(option);
        return this;
    }

    /**
     * Add options to the radio group.
     *
     * @param options The options.
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder addOptions(SelectableOption... options) {
        delegate.addOptions(Arrays.asList(options));
        return this;
    }

    /**
     * Add options to the radio group.
     *
     * @param options The options.
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder addOptions(List<SelectableOption> options) {
        delegate.addOptions(options);
        return this;
    }

    /**
     * Remove an option from the radio group.
     *
     * @param option The option.
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder removeOption(SelectableOption option) {
        delegate.removeOption(option);
        return this;
    }

    /**
     * Remove all options from the radio group.
     *
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder removeAllOptions() {
        delegate.removeAllOptions();
        return this;
    }

    /**
     * Set whether the radio group is required.
     *
     * @param required Whether the radio group is required or not.
     * @return The current instance in order to chain call methods.
     */
    public RadioGroupBuilder setRequired(boolean required) {
        delegate.setRequired(required);
        return this;
    }

    /**
     * Creates a {@link RadioGroup} instance with the given values.
     *
     * @return The created radio group instance.
     */
    public RadioGroup build() {
        return delegate.build();
    }

    /**
     * Gets the delegate used by the component builder internally.
     *
     * @return The delegate used by this component builder internally.
     */
    @Override
    public RadioGroupBuilderDelegate getDelegate() {
        return delegate;
    }
}
