package org.javacord.core.entity.message.component.internal;

import org.javacord.api.entity.message.component.SelectableOption;
import org.javacord.api.entity.message.component.internal.SelectableOptionBuilderDelegate;
import org.javacord.core.entity.message.component.SelectableOptionImpl;

public class SelectableOptionBuilderDelegateImpl implements SelectableOptionBuilderDelegate {
    private String label = null;
    private String value = null;
    private String description = null;
    private boolean isDefault = false;

    @Override
    public void copy(SelectableOption option) {
        label = option.getLabel();
        value = option.getValue();
        option.getDescription().ifPresent(this::setDescription);
        isDefault = option.isDefault();
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public SelectableOption build() {
        return new SelectableOptionImpl(label, value, isDefault, description);
    }
}
