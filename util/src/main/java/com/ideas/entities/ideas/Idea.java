package com.ideas.entities.ideas;

import java.io.Serializable;

/**
 * An idea.
 */
public class Idea implements Serializable
{

    private String title;
    private String ideaText;
    private long id;

    /**
     * Get the title of the idea.
     *
     * @return The title of the idea.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Set the title of the idea.
     *
     * @param title The title of the idea.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Get the text of the idea.
     *
     * @return The text of the idea.
     */
    public String getIdeaText()
    {
        return ideaText;
    }

    /**
     * Set the text of the idea.
     *
     * @param ideaText The text of the idea.
     */
    public void setIdeaText(String ideaText)
    {
        this.ideaText = ideaText;
    }

    /**
     * Get the ID of the idea.
     *
     * @return The ID of the idea.
     */
    public long getId()
    {
        return id;
    }

    /**
     * Set the ID of the idea.
     *
     * @param id The ID of the idea.
     */
    public void setId(long id)
    {
        this.id = id;
    }

}
