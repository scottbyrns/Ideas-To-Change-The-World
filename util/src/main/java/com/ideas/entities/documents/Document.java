package com.ideas.entities.documents;

import java.util.List;

/**
 * A document that encapsulates a one to many relationship with components.
 */
public class Document
{

    private List<OrderedComponent> componentList;

    /**
     * Get the documents component list.
     *
     * @return The lsit of components.
     */
    public List<OrderedComponent> getComponentList()
    {
        return componentList;
    }

    /**
     * Set the document component list.
     *
     * @param componentList
     */
    public void setComponentList(List<OrderedComponent> componentList)
    {
        this.componentList = componentList;
    }
}
