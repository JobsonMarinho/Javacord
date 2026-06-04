package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.Checkbox;
import org.javacord.api.entity.message.component.ComponentType;

public class CheckboxImpl extends ComponentImpl implements Checkbox {

    private final String customId;

    private final boolean isDefault;

    private final boolean required;

    private final boolean checked;

    /**
     * Creates a new checkbox.
     *
     * @param data The json data of the checkbox.
     */
    public CheckboxImpl(JsonNode data) {
        super(ComponentType.CHECKBOX);
        this.customId = data.get("custom_id").asText();
        this.isDefault = data.has("default") && data.get("default").asBoolean();
        this.required = data.has("required") && data.get("required").asBoolean();
        // "value" is only present on modal submit, otherwise fall back to the default state.
        this.checked = data.has("value") ? data.get("value").asBoolean() : isDefault;
    }

    /**
     * Creates a new checkbox.
     *
     * @param customId  The checkbox's custom ID.
     * @param isDefault Whether the checkbox is checked by default.
     * @param required  Whether the checkbox is required.
     */
    public CheckboxImpl(String customId, boolean isDefault, boolean required) {
        super(ComponentType.CHECKBOX);
        this.customId = customId;
        this.isDefault = isDefault;
        this.required = required;
        this.checked = isDefault;
    }

    @Override
    public String getCustomId() {
        return customId;
    }

    @Override
    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode object = JsonNodeFactory.instance.objectNode();
        return toJsonNode(object);
    }

    /**
     * Gets the checkbox as a {@link ObjectNode}. This is what is sent to Discord.
     *
     * @param object The object, the data should be added to.
     * @return The checkbox as a ObjectNode.
     */
    public ObjectNode toJsonNode(ObjectNode object) {
        object.put("type", ComponentType.CHECKBOX.value());
        object.put("custom_id", customId);
        object.put("default", isDefault);
        object.put("required", required);
        return object;
    }
}
