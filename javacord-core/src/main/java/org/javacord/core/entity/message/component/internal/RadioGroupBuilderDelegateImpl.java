package org.javacord.core.entity.message.component.internal;

import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.RadioGroup;
import org.javacord.api.entity.message.component.SelectableOption;
import org.javacord.api.entity.message.component.internal.RadioGroupBuilderDelegate;
import org.javacord.core.entity.message.component.RadioGroupImpl;

import java.util.ArrayList;
import java.util.List;

public class RadioGroupBuilderDelegateImpl implements RadioGroupBuilderDelegate {
    private final ComponentType type = ComponentType.RADIO_GROUP;

    private String customId = null;

    private final List<SelectableOption> options = new ArrayList<>();

    private boolean required = false;

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public void copy(RadioGroup radioGroup) {
        customId = radioGroup.getCustomId();
        options.addAll(radioGroup.getOptions());
        required = radioGroup.isRequired();
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
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public RadioGroup build() {
        return new RadioGroupImpl(customId, options, required);
    }
}
