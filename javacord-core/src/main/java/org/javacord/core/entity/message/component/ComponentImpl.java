package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.Component;
import org.javacord.api.entity.message.component.ComponentType;

public abstract class ComponentImpl implements Component {

    private final ComponentType type;

    /**
     * Creates a new component.
     *
     * @param type The type of the component.
     */
    public ComponentImpl(ComponentType type) {
        this.type = type;
    }

    @Override
    public ComponentType getType() {
        return type;
    }

    @Override
    public abstract ObjectNode toJsonNode();
}