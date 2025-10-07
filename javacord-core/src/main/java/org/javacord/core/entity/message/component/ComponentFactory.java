package org.javacord.core.entity.message.component;

import com.fasterxml.jackson.databind.JsonNode;
import org.javacord.api.entity.message.component.Component;
import org.javacord.api.entity.message.component.ComponentType;
import org.javacord.api.entity.message.component.HighLevelComponent;

public class ComponentFactory {

    /**
     * Creates a component based on the given JSON data.
     *
     * @param componentJson The JSON data for the component.
     * @return The created component.
     */
    public static Component createComponent(JsonNode componentJson) {
        int typeId = componentJson.get("type").asInt();
        ComponentType type = ComponentType.fromId(typeId);

        switch (type) {
            case ACTION_ROW:
                return new ActionRowImpl(componentJson);
            case LAYOUT:
                return new LayoutComponentImpl(componentJson);
            case TEXT_LABEL:
                return new TextLabelComponentImpl(componentJson);
            case GRID:
                return new GridComponentImpl(componentJson);
            case DIVIDER:
                return new DividerComponentImpl(componentJson);
            // Fallback for components that are not yet implemented but are inside an action row
            case BUTTON:
                return new ButtonImpl(componentJson);
            case SELECT_MENU_STRING:
            case SELECT_MENU_USER:
            case SELECT_MENU_ROLE:
            case SELECT_MENU_MENTIONABLE:
            case SELECT_MENU_CHANNEL:
                return new SelectMenuImpl(componentJson);
            case TEXT_INPUT:
                return new TextInputImpl(componentJson);
            default:
                throw new IllegalStateException(
                        "Couldn't parse the component of type '" + typeId + "'. Please contact the developer!");
        }
    }

    /**
     * Creates a high level component based on the given JSON data.
     *
     * @param componentJson The JSON data for the component.
     * @return The created component.
     */
    public static HighLevelComponent createHighLevelComponent(JsonNode componentJson) {
        return (HighLevelComponent) createComponent(componentJson);
    }
}
