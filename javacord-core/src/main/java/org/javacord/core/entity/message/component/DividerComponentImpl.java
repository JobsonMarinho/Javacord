package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.DividerComponent;

public class DividerComponentImpl extends ComponentImpl implements DividerComponent {

    /**
     * Creates a new divider component.
     *
     * @param data The JSON data for the component.
     */
    public DividerComponentImpl(JsonNode data) {
        super(ComponentType.DIVIDER);
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("type", getType().value());
        return node;
    }
}
