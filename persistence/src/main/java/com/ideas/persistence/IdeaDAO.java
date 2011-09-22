package com.ideas.persistence;

import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Data access object to wrap the Idea object.
 */
@Repository (value = "ideaDao")
public class IdeaDAO extends HibernateDAO<Idea>
{

    @PersistenceContext(unitName = "idea")
    EntityManager entityManager;

    /**
     * Save an idea.
     *
     * @param idea The idea to save.
     * @return The saved idea.
     */
    public Idea saveIdea (Idea idea)
    {
        save(idea).toString();

        return idea;
    }

    /**
     * Get an idea by it's ID.
     *
     * @param id ID of the idea.
     * @return The idea.
     */
    public Idea getById (long id)
    {
        return load(id);
    }

    /**
     * Get recent ideas.
     *
     * @param numberOfIdeas Number of recent ideas to get.
     * @return Recent ideas.
     */
    public Ideas getRecentIdeas (int numberOfIdeas)
    {
        System.out.println("Get Recent Ideas.");

        System.out.println(entityManager == null);

        Query query = entityManager.createQuery("SELECT m FROM Idea m");


        Ideas ideas = new Ideas();
        ideas.setIdeaList(
                query.getResultList()
        );

        return ideas;
    }
}
