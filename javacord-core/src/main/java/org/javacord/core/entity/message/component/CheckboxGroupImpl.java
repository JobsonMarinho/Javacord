package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.javacord.api.entity.message.component.CheckboxGroup;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.SelectableOption;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CheckboxGroupImpl extends ComponentImpl implements CheckboxGroup {

    private final String customId;

    private final List<SelectableOption> options = new ArrayList<>();

    private final Integer minimumValues;

    private final Integer maximumValues;

    private final boolean required;

    private final List<String> selectedValues = new ArrayList<>();

    /**
     * Creates a new checkbox group.
     *
     * @param data The json data of the checkbox group.
     */
    public CheckboxGroupImpl(JsonNode data) {
        super(ComponentType.CHECKBOX_GROUP);
        this.customId = data.get("custom_id").asText();
        if (data.has("options")) {
            for (JsonNode optionJson : data.get("options")) {
                options.add(new SelectableOptionImpl(optionJson));
            }
        }
        this.minimumValues = data.has("min_values") ? data.get("min_values").asInt() : null;
        this.maximumValues = data.has("max_values") ? data.get("max_values").asInt() : null;
        // Defaults to true on Discord's side when not specified.
        this.required = !data.has("required") || data.get("required").asBoolean();
        // "values" is only present on modal submit.
        if (data.has("values")) {
            for (JsonNode valueJson : data.get("values")) {
                selectedValues.add(valueJson.asText());
            }
        }
    }

    /**
     * Creates a new checkbox group.
     *
     * @param customId      The checkbox group's custom ID.
     * @param options       The options of the checkbox group.
     * @param minimumValues The minimum amount of selected options.
     * @param maximumValues The maximum amount of selected options.
     * @param required      Whether the checkbox group is required.
     */
    public CheckboxGroupImpl(String customId, List<SelectableOption> options, Integer minimumValues,
                             Integer maximumValues, boolean required) {
        super(ComponentType.CHECKBOX_GROUP);
        this.customId = customId;
        if (options != null) {
            this.options.addAll(options);
        }
        this.minimumValues = minimumValues;
        this.maximumValues = maximumValues;
        this.required = required;
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
    public Optional<Integer> getMinimumValues() {
        return Optional.ofNullable(minimumValues);
    }

    @Override
    public Optional<Integer> getMaximumValues() {
        return Optional.ofNullable(maximumValues);
    }

    @Override
    public boolean isRequired() {
        return required;
    }

    @Override
    public List<String> getSelectedValues() {
        return Collections.unmodifiableList(selectedValues);
    }

    @Override
    public ObjectNode toJsonNode() {
        ObjectNode object = JsonNodeFactory.instance.objectNode();
        return toJsonNode(object);
    }

    /**
     * Gets the checkbox group as a {@link ObjectNode}. This is what is sent to Discord.
     *
     * @param object The object, the data should be added to.
     * @return The checkbox group as a ObjectNode.
     */
    public ObjectNode toJsonNode(ObjectNode object) {
        object.put("type", ComponentType.CHECKBOX_GROUP.value());
        object.put("custom_id", customId);

        ArrayNode optionsJson = JsonNodeFactory.instance.arrayNode();
        for (SelectableOption option : options) {
            optionsJson.add(((SelectableOptionImpl) option).toJson());
        }
        object.set("options", optionsJson);

        if (minimumValues != null) {
            object.put("min_values", minimumValues);
        }
        if (maximumValues != null) {
            object.put("max_values", maximumValues);
        }
        object.put("required", required);

        return object;
    }
}
