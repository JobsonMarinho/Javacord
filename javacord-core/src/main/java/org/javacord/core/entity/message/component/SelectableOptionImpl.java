package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.SelectableOption;

import java.util.Optional;

public class SelectableOptionImpl implements SelectableOption {

    private final String label;
    private final String value;
    private final String description;
    private final boolean isDefault;

    /**
     * Creates a new selectable option.
     *
     * @param data The json data of the selectable option.
     */
    public SelectableOptionImpl(JsonNode data) {
        label = data.get("label").asText();
        value = data.get("value").asText();
        description = data.has("description") ? data.get("description").asText() : null;
        isDefault = data.has("default") && data.get("default").asBoolean();
    }

    /**
     * Creates a new selectable option.
     *
     * @param label       The label for the option.
     * @param value       The value for the option.
     * @param isDefault   If the option is selected by default.
     * @param description The description for the option.
     */
    public SelectableOptionImpl(String label, String value, boolean isDefault, String description) {
        this.label = label;
        this.value = value;
        this.isDefault = isDefault;
        this.description = description;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    /**
     * Gets the selectable option as a {@link ObjectNode}. This is what is sent to Discord.
     *
     * @return The selectable option as a ObjectNode.
     */
    public ObjectNode toJson() {
        ObjectNode object = JsonNodeFactory.instance.objectNode();
        object.put("label", label);
        object.put("value", value);
        object.put("default", isDefault);

        if (description != null) {
            object.put("description", description);
        }

        return object;
    }
}
