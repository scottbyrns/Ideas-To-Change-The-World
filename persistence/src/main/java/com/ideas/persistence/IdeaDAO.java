package com.ideas.persistence;

import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Data access object to wrap the Idea object.
 */
@Repository(value = "ideaDao")
public class IdeaDAO extends HibernateDAO<Idea>
{

    @PersistenceContext(unitName = "ideaPersistenceUnit")
    private EntityManager entityManager;

    /**
     * Save an idea.
     *
     * @param idea The idea to save.
     * @return The saved idea.
     */
    public Idea saveIdea(Idea idea)
    {
        save(idea);

        return idea;
    }

    /**
     * Get an idea by it's ID.
     *
     * @param id ID of the idea.
     * @return The idea.
     */
    public Idea getById(long id)
    {
        return load(id);
    }

    /**
     * Get recent ideas entered into the database.
     *
     * @param numberOfIdeas Number of recent ideas to get.
     * @return Recent ideas.
     */
    public Ideas getRecentIdeas(int numberOfIdeas)
    {

        Query query = getEntityManager().createQuery(
                "SELECT idea FROM Idea idea ORDER BY idea.id desc"
        );

        query.setMaxResults(numberOfIdeas);

        Ideas ideas = new Ideas();
        ideas.setIdeaList(
                query.getResultList()
        );



        Iterator<Idea> ideaIterator = ideas.getIdeaList().iterator();
        while (ideaIterator.hasNext())
        {
            ideaIterator.next().getLikeList().size();
        }


        return ideas;
    }

    /**
     * Get the most liked ideas.
     *
     * @param numberOfIdeas Number of most liked ideas to get.
     * @return Most liked ideas.
     */
    public Ideas getMostLikedIdeas(int numberOfIdeas)
    {
        Query query;
        query = getEntityManager().createQuery(
                "SELECT idea FROM Idea idea ORDER BY size(idea.likeList) desc"
        );

        query.setMaxResults(numberOfIdeas);

        Ideas ideas = new Ideas();
        ideas.setIdeaList(
                query.getResultList()
        );
        return ideas;
    }

    /**
     * Get the entity manager.
     *
     * @return The entity manager.
     */
    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    /**
     * Set the entity manager.
     *
     * @param entityManager The entity manager.
     */
    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
}
