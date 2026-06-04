package org.javacord.core.interaction;

import com.fasterxml.jackson.databind.JsonNode;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.component.Checkbox;
import org.javacord.api.entity.message.component.CheckboxGroup;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.HighLevelComponent;
import org.javacord.api.entity.message.component.LowLevelComponent;
import org.javacord.api.entity.message.component.RadioGroup;
import org.javacord.api.entity.message.component.TextInput;
import org.javacord.api.interaction.InteractionType;
import org.javacord.api.interaction.ModalInteraction;
import org.javacord.core.DiscordApiImpl;
import org.javacord.core.entity.message.component.ActionRowImpl;
import org.javacord.core.entity.message.component.LabelImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModalInteractionImpl extends InteractionImpl implements ModalInteraction {

    private final String customId;
    private final List<HighLevelComponent> components = new ArrayList<>();

    /**
     * Class constructor.
     *
     * @param api      The api instance.
     * @param channel  The channel in which the interaction happened. Can be {@code null}.
     * @param jsonData The json data of the interaction.
     */
    public ModalInteractionImpl(DiscordApiImpl api, TextChannel channel, JsonNode jsonData) {
        super(api, channel, jsonData);
        JsonNode data = jsonData.get("data");
        customId = data.get("custom_id").asText();

        for (JsonNode jsonNode : data.get("components")) {
            switch (ComponentType.fromId(jsonNode.get("type").asInt())) {
                case ACTION_ROW:
                    components.add(new ActionRowImpl(jsonNode));
                    break;
                case LABEL:
                    components.add(new LabelImpl(jsonNode));
                    break;
                default:
                    throw new IllegalStateException("Received a HighLevelComponent not handled in modals");
            }
        }
    }

    @Override
    public InteractionType getType() {
        return InteractionType.MODAL_SUBMIT;
    }

    /**
     * This method cannot be used by modal interactions.
     *
     * @return Throws an {@link UnsupportedOperationException}.
     */
    @Override
    public CompletableFuture<Void> respondWithModal(String customId, String title,
                                                    List<HighLevelComponent> components) {
        throw new UnsupportedOperationException("This method is not supported by this interaction");
    }

    @Override
    public String getCustomId() {
        return customId;
    }

    @Override
    public List<HighLevelComponent> getComponents() {
        return components;
    }

    /**
     * Flattens the top-level components into the low level components they contain.
     * This handles both legacy action rows and the modal {@code Label} containers.
     *
     * @return A stream of all low level components in the modal.
     */
    private Stream<LowLevelComponent> lowLevelComponents() {
        return components.stream().flatMap(component -> {
            if (component.isActionRow()) {
                return component.asActionRow().get().getComponents().stream();
            }
            if (component.isLabel()) {
                return Stream.of(component.asLabel().get().getComponent());
            }
            return Stream.empty();
        });
    }

    @Override
    public List<String> getTextInputValues() {
        return lowLevelComponents()
                .map(LowLevelComponent::asTextInput)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(TextInput::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<String> getTextInputValueByCustomId(String customId) {
        return lowLevelComponents()
                .map(LowLevelComponent::asTextInput)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(textInput -> textInput.getCustomId().equals(customId))
                .map(TextInput::getValue)
                .findFirst();
    }

    @Override
    public Optional<Boolean> getCheckboxValueByCustomId(String customId) {
        return lowLevelComponents()
                .map(LowLevelComponent::asCheckbox)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(checkbox -> checkbox.getCustomId().equals(customId))
                .map(Checkbox::isChecked)
                .findFirst();
    }

    @Override
    public Optional<String> getRadioGroupValueByCustomId(String customId) {
        return lowLevelComponents()
                .map(LowLevelComponent::asRadioGroup)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(radioGroup -> radioGroup.getCustomId().equals(customId))
                .map(RadioGroup::getSelectedValue)
                .findFirst()
                .flatMap(value -> value);
    }

    @Override
    public List<String> getCheckboxGroupValuesByCustomId(String customId) {
        return lowLevelComponents()
                .map(LowLevelComponent::asCheckboxGroup)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(checkboxGroup -> checkboxGroup.getCustomId().equals(customId))
                .map(CheckboxGroup::getSelectedValues)
                .findFirst()
                .orElse(Collections.emptyList());
    }

}
