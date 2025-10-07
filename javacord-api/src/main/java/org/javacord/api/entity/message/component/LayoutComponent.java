package org.javacord.api.entity.message.component;

import java.util.List;

public interface LayoutComponent extends HighLevelComponent {
    /**
     * Gets the components within this layout component.
     *
     * @return The components in this layout.
     */
    List<Component> getComponents();
}
