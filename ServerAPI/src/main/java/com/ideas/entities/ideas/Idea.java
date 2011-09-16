package com.ideas.entities.ideas;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * An idea.
 *
 */
public class Idea {

    private String title;
    private String ideaText;
    @JsonProperty("_id")
    private String id;
    private String ideaDocumentId;

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
    public String getId()
    {
        return id;
    }

    /**
     * Set the ID of the idea.
     *
     * @param id The ID of the idea.
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * Get the ID of the document attached to the idea.
     *
     * @return The ID of the document attached to the idea.
     */
    public String getIdeaDocumentId()
    {
        return ideaDocumentId;
    }

    /**
     * Set the ID of the document attached to the idea.
     *
     * @param ideaDocumentId The ID of the document attached to the idea.
     */
    public void setIdeaDocumentId(String ideaDocumentId)
    {
        this.ideaDocumentId = ideaDocumentId;
    }
}
