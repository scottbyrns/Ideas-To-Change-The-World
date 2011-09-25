package com.ideas.persistence;

import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Like;
import com.ideas.entities.ideas.LikeCount;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Dao to manage access to likes.
 */
@Repository(value = "likeDao")
public class LikeDAO extends HibernateDAO<Like>
{

    @PersistenceContext(unitName = "likePersistenceUnit")
    private EntityManager entityManager;

    /**
     * Save a like.
     *
     * @param like Like to save.
     * @return The like that was saved.
     */
    public Like saveLike (Like like)
    {
        save(like);
        return like;
    }

    /**
     * Get a like by it's id.
     *
     * @param id The ID of the like.
     * @return The like.
     */
    public Like getById (Long id)
    {
        return load(id);
    }

    /**
     * Get the like count for an idea.
     *
     * @param idea The idea to get the like count for.
     * @return The count of likes for the provided idea.
     */
    public LikeCount getLikeCountForIdea (Idea idea)
    {
        Query query = getEntityManager().createQuery("SELECT count(*) FROM Idea as idea WHERE idea.id = :ideaId");
        query.setParameter("ideaId", idea.getId());

        LikeCount likeCount = new LikeCount();

        likeCount.setCount(
                query.getResultList().size()
        );

        return likeCount;
    }

    /**
     * Get the entity manager.
     *
     * @return The entity manager.
     */
    private EntityManager getEntityManager()
    {
        return entityManager;
    }

}
