package org.javacord.api.entity.message.component;

import com.fasterxml.jackson.databind.node.ObjectNode;

public interface Component {

    /**
     * Gets the type of this component.
     *
     * @return The component's type.
     */
    ComponentType getType();

    /**
     * Gets the component as a {@link ObjectNode}. This is what is sent to Discord.
     *
     * @return The component as a ObjectNode.
     */
    ObjectNode toJsonNode();

}