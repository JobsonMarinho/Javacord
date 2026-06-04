package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.RadioGroup;
import org.javacord.api.entity.message.component.SelectableOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RadioGroupImpl extends ComponentImpl implements RadioGroup {

    private final String customId;

    private final List<SelectableOption> options = new ArrayList<>();

    private final boolean required;

    private final String selectedValue;

    /**
     * Creates a new radio group.
     *
     * @param data The json data of the radio group.
     */
    public RadioGroupImpl(JsonNode data) {
        super(ComponentType.RADIO_GROUP);
        this.customId = data.get("custom_id").asText();
        if (data.has("options")) {
            for (JsonNode optionJson : data.get("options")) {
                options.add(new SelectableOptionImpl(optionJson));
            }
        }
        // Defaults to true on Discord's side when not specified.
        this.required = !data.has("required") || data.get("required").asBoolean();
        // "value" is only present on modal submit.
        this.selectedValue = data.has("value") && !data.get("value").isNull()
                ? data.get("value").asText() : null;
    }

    /**
     * Creates a new radio group.
     *
     * @param customId The radio group's custom ID.
     * @param options  The options of the radio group.
     * @param required Whether the radio group is required.
     */
    public RadioGroupImpl(String customId, List<SelectableOption> options, boolean required) {
        super(ComponentType.RADIO_GROUP);
        this.customId = customId;
        if (options != null) {
            this.options.addAll(options);
        }
        this.required = required;
        this.selectedValue = null;
    }

    @Override
    public String getCustomId() {
        return customId;
    }

    @Override
    public List<SelectableOption> getOptions() {
        return Collections.unmodifiableList(options);
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public Optional<String> getSelectedValue() {
        return Optional.ofNullable(selectedValue);
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode object = JsonNodeFactory.instance.objectNode();
        return toJsonNode(object);
    }

    /**
     * Gets the radio group as a {@link ObjectNode}. This is what is sent to Discord.
     *
     * @param object The object, the data should be added to.
     * @return The radio group as a ObjectNode.
     */
    public ObjectNode toJsonNode(ObjectNode object) {
        object.put("type", ComponentType.RADIO_GROUP.value());
        object.put("custom_id", customId);

        ArrayNode optionsJson = JsonNodeFactory.instance.arrayNode();
        for (SelectableOption option : options) {
            optionsJson.add(((SelectableOptionImpl) option).toJson());
        }
        object.set("options", optionsJson);

        object.put("required", required);

        return object;
    }
}
