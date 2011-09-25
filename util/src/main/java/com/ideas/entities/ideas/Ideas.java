package com.ideas.entities.ideas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A collection of ideas.
 */
public class Ideas implements Serializable
{
    private List<Idea> ideaList;

    public List<Idea> getIdeaList ()
    {
        return ideaList;
    }

    public void setIdeaList (List<Idea> ideaList)
    {
        this.ideaList = ideaList;
    }

    /**
     * Get the size of the ideas collection.
     *
     * @return The size of the ideas collection.
     */
    public int size ()
    {
        return getIdeaList().size();
    }
}
