package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.TextLabelComponent;

public class TextLabelComponentImpl extends ComponentImpl implements TextLabelComponent {

    private final String content;

    /**
     * Creates a new text label component.
     *
     * @param data The JSON data for the component.
     */
    public TextLabelComponentImpl(JsonNode data) {
        super(ComponentType.TEXT_LABEL);
        this.content = data.get("content").asText();
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("type", getType().value());
        node.put("content", content);
        return node;
    }
}
