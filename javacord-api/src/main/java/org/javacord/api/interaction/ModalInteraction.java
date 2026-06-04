package org.javacord.api.interaction;

import org.javacord.api.entity.message.component.HighLevelComponent;
import java.util.List;
import java.util.Optional;

public interface ModalInteraction extends InteractionBase {

    /**
     * Get the custom id of the select menu.
     *
     * @return The custom ID.
     */
    String getCustomId();

    /**
     * Get the components of the modal.
     *
     * @return The components.
     */
    List<HighLevelComponent> getComponents();

    /**
     * Gets the values of each text input.
     * This is a shorthand method to avoid iterating the nested components by yourself.
     *
     * @return The values of the text input components.
     */
    List<String> getTextInputValues();

    /**
     * Get the value of a text input by its custom id.
     * This is a shorthand method to avoid iterating the nested components by yourself.
     *
     * @param customId The custom ID of the component.
     * @return The value of the text input component with the id.
     */
    Optional<String> getTextInputValueByCustomId(String customId);

    /**
     * Get whether a checkbox is checked by its custom id.
     * This is a shorthand method to avoid iterating the nested components by yourself.
     *
     * @param customId The custom ID of the component.
     * @return Whether the checkbox with the id is checked, or empty if no such checkbox exists.
     */
    Optional<Boolean> getCheckboxValueByCustomId(String customId);

    /**
     * Get the value selected in a radio group by its custom id.
     * This is a shorthand method to avoid iterating the nested components by yourself.
     *
     * @param customId The custom ID of the component.
     * @return The selected value of the radio group component with the id.
     */
    Optional<String> getRadioGroupValueByCustomId(String customId);

    /**
     * Get the values selected in a checkbox group by its custom id.
     * This is a shorthand method to avoid iterating the nested components by yourself.
     *
     * @param customId The custom ID of the component.
     * @return The selected values of the checkbox group component with the id.
     */
    List<String> getCheckboxGroupValuesByCustomId(String customId);

}
