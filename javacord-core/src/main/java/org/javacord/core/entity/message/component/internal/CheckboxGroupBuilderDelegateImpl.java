package org.javacord.core.entity.message.component.internal;

import org.javacord.api.entity.message.component.CheckboxGroup;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.SelectableOption;
import org.javacord.api.entity.message.component.internal.CheckboxGroupBuilderDelegate;
import org.javacord.core.entity.message.component.CheckboxGroupImpl;

import java.util.ArrayList;
import java.util.List;

public class CheckboxGroupBuilderDelegateImpl implements CheckboxGroupBuilderDelegate {
    private final ComponentType type = ComponentType.CHECKBOX_GROUP;

    private String customId = null;

    private final List<SelectableOption> options = new ArrayList<>();

    private Integer minimumValues = null;

    private Integer maximumValues = null;

    private boolean required = false;

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public void copy(CheckboxGroup checkboxGroup) {
        customId = checkboxGroup.getCustomId();
        options.addAll(checkboxGroup.getOptions());
        minimumValues = checkboxGroup.getMinimumValues().orElse(null);
        maximumValues = checkboxGroup.getMaximumValues().orElse(null);
        required = checkboxGroup.isRequired();
    }

    @Override
    public String getCustomId() {
        return customId;
    }

    @Override
    public void setCustomId(String customId) {
        this.customId = customId;
    }

    @Override
    public void addOption(SelectableOption option) {
        options.add(option);
    }

    @Override
    public void addOptions(List<SelectableOption> options) {
        this.options.addAll(options);
    }

    @Override
    public void removeOption(SelectableOption option) {
        options.remove(option);
    }

    @Override
    public void removeAllOptions() {
        options.clear();
    }

    @Override
    public void setMinimumValues(Integer minimumValues) {
        this.minimumValues = minimumValues;
    }

    @Override
    public void setMaximumValues(Integer maximumValues) {
        this.maximumValues = maximumValues;
    }

    @Override
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public CheckboxGroup build() {
        return new CheckboxGroupImpl(customId, options, minimumValues, maximumValues, required);
    }
}
