package com.ideas.entities.users;

/**
 * User Object
 */
public class User
{
    private long userId;
    private Username username;
    private Sex sex;

    /**
     * Get the users id.
     *
     * @return The users id.
     */
    public long getUserId ()
    {
        return userId;
    }

    /**
     * Set the users id.
     *
     * @param userId The users id.
     */
    public void setUserId (long userId)
    {
        this.userId = userId;
    }

    /**
     * Get the users username.
     *
     * @return The users username.
     */
    public Username getUsername ()
    {
        return username;
    }

    /**
     * Set the users username.
     *
     * @param username The users username.
     */
    public void setUsername (Username username)
    {
        this.username = username;
    }

    /**
     * Get the users sex.
     *
     * @return The users sex.
     */
    public Sex getSex ()
    {
        return sex;
    }

    /**
     * Set the users sex.
     *
     * @param sex The users sex.
     */
    public void setSex (Sex sex)
    {
        this.sex = sex;
    }
}
