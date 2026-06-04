package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.Label;
import org.javacord.api.entity.message.component.LowLevelComponent;

import java.util.Optional;

public class LabelImpl extends ComponentImpl implements Label {

    private final String label;

    private final String description;

    private final LowLevelComponent component;

    /**
     * Creates a new label.
     *
     * @param data The json data of the label.
     */
    public LabelImpl(JsonNode data) {
        super(ComponentType.LABEL);
        // On modal submit, Discord sends the label component without its "label" (and
        // "description") field, since those are display-only and not submitted data.
        this.label = data.has("label") && !data.get("label").isNull()
                ? data.get("label").asText() : null;
        this.description = data.has("description") && !data.get("description").isNull()
                ? data.get("description").asText() : null;
        this.component = (LowLevelComponent) ComponentFactory.createComponent(data.get("component"));
    }

    /**
     * Creates a new label.
     *
     * @param label       The label text.
     * @param description The description of the label.
     * @param component   The component wrapped by this label.
     */
    public LabelImpl(String label, String description, LowLevelComponent component) {
        super(ComponentType.LABEL);
        this.label = label;
        this.description = description;
        this.component = component;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public LowLevelComponent getComponent() {
        return component;
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("type", getType().value());
        node.put("label", label);
        if (description != null) {
            node.put("description", description);
        }
        node.set("component", component.toJsonNode());
        return node;
    }
}
