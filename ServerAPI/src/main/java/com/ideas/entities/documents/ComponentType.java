package com.ideas.entities.documents;

/**
 * The type of a component.
 */
public class ComponentType
{
    private String typeName;
    private String componentId;

    /**
     * Get the name of the component type.
     *
     * @return The name of the component type.
     */
    public String getTypeName()
    {
        return typeName;
    }

    /**
     * Set the name of the component type.
     *
     * @param typeName The name of the component type.
     */
    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    /**
     * Get the component type ID.
     *
     * @return The ID of the component type.
     */
    public String getComponentId()
    {
        return componentId;
    }

    /**
     * Set the ID of the component type.
     *
     * @param componentId The ID of the component type.
     */
    public void setComponentId(String componentId)
    {
        this.componentId = componentId;
    }
}
