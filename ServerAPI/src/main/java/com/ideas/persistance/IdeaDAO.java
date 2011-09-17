package com.ideas.persistance;

import com.ideas.entities.ideas.Idea;

/**
 * Data access object to wrap the Idea object.
 */
public class IdeaDAO extends HibernateDAO<Idea>
{

    public Idea saveIdea (Idea idea)
    {
        save(idea).toString();

        return idea;
    }

    public Idea getById (long id)
    {
        return load(id);
    }
}
