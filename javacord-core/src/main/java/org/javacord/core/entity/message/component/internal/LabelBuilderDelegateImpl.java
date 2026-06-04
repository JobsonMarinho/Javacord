package org.javacord.core.entity.message.component.internal;

import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.Label;
import org.javacord.api.entity.message.component.LowLevelComponent;
import org.javacord.api.entity.message.component.internal.LabelBuilderDelegate;
import org.javacord.core.entity.message.component.LabelImpl;

public class LabelBuilderDelegateImpl implements LabelBuilderDelegate {
    private final ComponentType type = ComponentType.LABEL;

    private String label = null;

    private String description = null;

    private LowLevelComponent component = null;

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public void copy(Label label) {
        this.label = label.getLabel();
        this.description = label.getDescription().orElse(null);
        this.component = label.getComponent();
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setComponent(LowLevelComponent component) {
        this.component = component;
    }

    @Override
    public Label build() {
        return new LabelImpl(label, description, component);
    }
}
