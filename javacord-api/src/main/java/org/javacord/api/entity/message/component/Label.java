package org.javacord.api.entity.message.component;

import java.util.Optional;

/**
 * A label that wraps a single interactive component inside a modal.
 *
 * <p>It provides the displayed label text and an optional description for the wrapped component
 * such as a {@link Checkbox}, {@link CheckboxGroup}, {@link RadioGroup}, text input or select menu.
 */
public interface Label extends HighLevelComponent {

    /**
     * Get the label text.
     *
     * @return The label text.
     */
    String getLabel();

    /**
     * Get the description of the label.
     *
     * @return The description.
     */
    Optional<String> getDescription();

    /**
     * Get the component wrapped by this label.
     *
     * @return The wrapped component.
     */
    LowLevelComponent getComponent();

    /**
     * Creates a new label with the given values.
     *
     * @param label     The label text.
     * @param component The component to wrap.
     * @return The created label.
     */
    static Label create(String label, LowLevelComponent component) {
        return new LabelBuilder(label, component).build();
    }

    /**
     * Creates a new label with the given values.
     *
     * @param label       The label text.
     * @param description The description of the label.
     * @param component   The component to wrap.
     * @return The created label.
     */
    static Label create(String label, String description, LowLevelComponent component) {
        return new LabelBuilder(label, component)
                .setDescription(description)
                .build();
    }
}
