package org.javacord.core.entity.message.component.internal;

import org.javacord.api.entity.message.component.Checkbox;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.internal.CheckboxBuilderDelegate;
import org.javacord.core.entity.message.component.CheckboxImpl;

public class CheckboxBuilderDelegateImpl implements CheckboxBuilderDelegate {
    private final ComponentType type = ComponentType.CHECKBOX;

    private String customId = null;

    private boolean isDefault = false;

    private boolean required = false;

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public void copy(Checkbox checkbox) {
        customId = checkbox.getCustomId();
        isDefault = checkbox.isDefault();
        required = checkbox.isRequired();
    }

    @Override
    public String getCustomId() {
        return customId;
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public void setCustomId(String customId) {
        this.customId = customId;
    }

    @Override
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public void setRequired(boolean required) {
        this.required = required;
    }

    @Override
    public Checkbox build() {
        return new CheckboxImpl(customId, isDefault, required);
    }
}
