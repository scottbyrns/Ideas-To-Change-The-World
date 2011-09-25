package com.ideas.entities.ideas;

import java.io.Serializable;

/**
 * Object to encapsulate a count of likes.
 */
public class LikeCount implements Serializable
{
    private long count;

    /**
     * Get the likes count.
     *
     * @return The count of likes.
     */
    public long getCount()
    {
        return count;
    }

    /**
     * Set the likes count.
     *
     * @param count The count of likes.
     */
    public void setCount(long count)
    {
        this.count = count;
    }
}
