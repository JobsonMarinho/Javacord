package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.GridComponent;

public class GridComponentImpl extends ComponentImpl implements GridComponent {

    /**
     * Creates a new grid component.
     *
     * @param data The JSON data for the component.
     */
    public GridComponentImpl(JsonNode data) {
        super(ComponentType.GRID);
        // TODO: Parse items
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("type", getType().value());
        // TODO: Add items to node
        return node;
    }
}
