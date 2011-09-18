package com.ideas.entities.users;

import java.io.Serializable;

/**
 * Username object.
 */
public class Username implements Serializable
{
    private String alias;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;

    /**
     * Get the users alias.
     *
     * @return The users alias.
     */
    public String getAlias ()
    {
        return alias;
    }

    /**
     * Set the users alias.
     *
     * @param alias The users alias.
     */
    public void setAlias (String alias)
    {
        this.alias = alias;
    }

    /**
     * Get the users first name.
     *
     * @return The users first name.
     */
    public String getFirstName ()
    {
        return firstName;
    }

    /**
     * Set the users first name.
     *
     * @param firstName The users first name.
     */
    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Get the users middle name.
     *
     * @return The users middle name.
     */
    public String getMiddleName ()
    {
        return middleName;
    }

    /**
     * Set the users middle name.
     *
     * @param middleName The users middle name.
     */
    public void setMiddleName (String middleName)
    {
        this.middleName = middleName;
    }

    /**
     * Get the users last name.
     *
     * @return The users last name.
     */
    public String getLastName ()
    {
        return lastName;
    }

    /**
     * Set the users last name.
     *
     * @param lastName The users last name.
     */
    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Get the users suffix.
     *
     * @return The users suffix.
     */
    public String getSuffix ()
    {
        return suffix;
    }

    /**
     * Set the users suffix.
     *
     * @param suffix The users suffix.
     */
    public void setSuffix (String suffix)
    {
        this.suffix = suffix;
    }
}
