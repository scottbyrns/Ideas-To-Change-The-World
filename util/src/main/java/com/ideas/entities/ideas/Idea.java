package com.ideas.entities.ideas;

/**
 * An idea.
 *
 */
public class Idea {

    private String title;
    private String ideaText;
    private int id;
    private int authorId;

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
    public int getId()
    {
        return id;
    }

    /**
     * Set the ID of the idea.
     *
     * @param id The ID of the idea.
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * Get the ID of the author of the idea.
     *
     * @return The ID of the author of the idea.
     */
    public int getAuthorId()
    {
        return authorId;
    }

    /**
     * Set the ID of the author of the idea.
     *
     * @param authorId ID of the author of the idea.
     */
    public void setAuthorId(int authorId)
    {
        this.authorId = authorId;
    }


}
