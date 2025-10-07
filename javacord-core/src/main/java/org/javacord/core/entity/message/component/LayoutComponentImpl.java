package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.Component;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.LayoutComponent;

import java.util.ArrayList;
import java.util.List;

public class LayoutComponentImpl extends ComponentImpl implements LayoutComponent {

    private final List<Component> components = new ArrayList<>();

    /**
     * Creates a new layout component.
     *
     * @param data The JSON data for the component.
     */
    public LayoutComponentImpl(JsonNode data) {
        super(ComponentType.LAYOUT);
        for (JsonNode componentJson : data.get("components")) {
            components.add(ComponentFactory.createComponent(componentJson));
        }
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("type", getType().value());
        // TODO: Add components to node
        return node;
    }
}
