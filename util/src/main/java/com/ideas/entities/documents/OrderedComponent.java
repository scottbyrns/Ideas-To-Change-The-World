package com.ideas.entities.documents;

/**
 * A component with an order index specified.
 */
public class OrderedComponent {

    private Component component;
    private int order;

    /**
     * Get the component.
     *
     * @return The component.
     */
    public Component getComponent() {
        return component;
    }

    /**
     * Set the component.
     *
     * @param component The component.
     */
    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * Get the order.
     *
     * @return The order.
     */
    public int getOrder() {
        return order;
    }

    /**
     * Set the order.
     *
     * @param order The order.
     */
    public void setOrder(int order) {
        this.order = order;
    }
}
