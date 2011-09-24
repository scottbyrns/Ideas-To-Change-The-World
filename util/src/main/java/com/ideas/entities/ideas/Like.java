package com.ideas.entities.ideas;

/**
 * Idea like.
 */
public class Like
{
    private long likeId;
    private long userId;
    private long ideaId;

    /**
     * Get the ID of the like.
     *
     * @return The ID of the like.
     */
    public long getLikeId()
    {
        return likeId;
    }

    /**
     * Set the ID of the like.
     *
     * @param likeId The ID of the like.
     */
    public void setLikeId(long likeId)
    {
        this.likeId = likeId;
    }

    /**
     * Get the ID of the user who liked the idea.
     *
     * @return The ID of the user who liked the idea.
     */
    public long getUserId()
    {
        return userId;
    }

    /**
     * Set the ID of the user who liked the idea.
     *
     * @param userId The ID of the use who liked the idea.
     */
    public void setUserId(long userId)
    {
        this.userId = userId;
    }

    /**
     * Get the ID of the liked idea.
     *
     * @return The ID of the liked idea.
     */
    public long getIdeaId()
    {
        return ideaId;
    }

    /**
     * Set the ID of the liked idea.
     *
     * @param ideaId The ID of the liked idea.
     */
    public void setIdeaId(long ideaId)
    {
        this.ideaId = ideaId;
    }
}
