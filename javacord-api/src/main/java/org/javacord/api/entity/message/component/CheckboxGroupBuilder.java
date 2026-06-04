package org.javacord.api.entity.message.component;

import org.javacord.api.entity.message.component.internal.CheckboxGroupBuilderDelegate;
import org.javacord.api.util.internal.DelegateFactory;

import java.util.Arrays;
import java.util.List;

public class CheckboxGroupBuilder implements LowLevelComponentBuilder {
    private final CheckboxGroupBuilderDelegate delegate = DelegateFactory.createCheckboxGroupBuilderDelegate();

    /**
     * Creates a new checkbox group builder.
     *
     * @param customId The custom id of the checkbox group.
     */
    public CheckboxGroupBuilder(String customId) {
        setCustomId(customId);
    }

    /**
     * Copy a checkbox group's values into this builder.
     *
     * @param checkboxGroup The checkbox group to copy.
     * @return The builder instance to chain methods.
     */
    public CheckboxGroupBuilder copy(CheckboxGroup checkboxGroup) {
        delegate.copy(checkboxGroup);
        return this;
    }

    /**
     * Get the component's type (always {@link ComponentType#CHECKBOX_GROUP}).
     *
     * @return The component's type.
     */
    public ComponentType getType() {
        return delegate.getType();
    }

    /**
     * Set the checkbox group's custom ID.
     *
     * @param customId The checkbox group's identifier.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder setCustomId(String customId) {
        delegate.setCustomId(customId);
        return this;
    }

    /**
     * Add an option to the checkbox group.
     *
     * @param option The option.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder addOption(SelectableOption option) {
        delegate.addOption(option);
        return this;
    }

    /**
     * Add options to the checkbox group.
     *
     * @param options The options.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder addOptions(SelectableOption... options) {
        delegate.addOptions(Arrays.asList(options));
        return this;
    }

    /**
     * Add options to the checkbox group.
     *
     * @param options The options.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder addOptions(List<SelectableOption> options) {
        delegate.addOptions(options);
        return this;
    }

    /**
     * Remove an option from the checkbox group.
     *
     * @param option The option.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder removeOption(SelectableOption option) {
        delegate.removeOption(option);
        return this;
    }

    /**
     * Remove all options from the checkbox group.
     *
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder removeAllOptions() {
        delegate.removeAllOptions();
        return this;
    }

    /**
     * Set the minimum amount of options which must be selected.
     *
     * @param minimumValues The minimum amount of selected options.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder setMinimumValues(Integer minimumValues) {
        delegate.setMinimumValues(minimumValues);
        return this;
    }

    /**
     * Set the maximum amount of options which can be selected.
     *
     * @param maximumValues The maximum amount of selected options.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder setMaximumValues(Integer maximumValues) {
        delegate.setMaximumValues(maximumValues);
        return this;
    }

    /**
     * Set whether the checkbox group is required.
     *
     * @param required Whether the checkbox group is required or not.
     * @return The current instance in order to chain call methods.
     */
    public CheckboxGroupBuilder setRequired(boolean required) {
        delegate.setRequired(required);
        return this;
    }

    /**
     * Creates a {@link CheckboxGroup} instance with the given values.
     *
     * @return The created checkbox group instance.
     */
    public CheckboxGroup build() {
        return delegate.build();
    }

    /**
     * Gets the delegate used by the component builder internally.
     *
     * @return The delegate used by this component builder internally.
     */
    @Override
    public CheckboxGroupBuilderDelegate getDelegate() {
        return delegate;
    }
}
