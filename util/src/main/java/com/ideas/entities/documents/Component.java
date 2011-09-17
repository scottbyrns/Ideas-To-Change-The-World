package com.ideas.entities.documents;

/**
 * Encapsulation of a single asset.
 */
public class Component
{
    private ComponentType componentType;
    private String componentId;

    /**
     * Get the type of the component.
     *
     * @return The type of the component.
     */
    public ComponentType getComponentType()
    {
        return componentType;
    }

    /**
     * Set the type of the component.
     *
     * @param componentType The type of the component.
     */
    public void setComponentType(ComponentType componentType)
    {
        this.componentType = componentType;
    }

    /**
     * Get the ID of the component.
     *
     * @return The ID of the component.
     */
    public String getComponentId()
    {
        return componentId;
    }

    /**
     * Set the ID of the component.
     *
     * @param componentId The ID of the component.
     */
    public void setComponentId(String componentId)
    {
        this.componentId = componentId;
    }
}
