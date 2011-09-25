import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Like;
import com.ideas.persistence.LikeDAO;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;

/**
 * Test the like DAO.
 */
@ContextConfiguration(locations = {"classpath:beans.xml"})
@TransactionConfiguration(transactionManager = "likeTransactionManager", defaultRollback = false)
public class TestLikeDAO extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    LikeDAO likeDao;

    @Override
    public void setDataSource(DataSource dataSource)
    {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    /**
     * Test creating a like.
     */
    @Test
    public void testCreateLike ()
    {
        Like like = new Like();
        like.setIdeaId(1);
        like.setUserId(1);
        likeDao.saveLike(like);
    }

    /**
     * Test getting the count of likes for an idea.
     */
    @Test
    public void testCountLikesForIdea()
    {
        Idea idea = new Idea();
        idea.setId(0);
        long likeCount = getLikeDao().getLikeCountForIdea(idea);

        assertEquals(
                "Asserting that the like count for the idea with ID 0 is 1",
                1L,
                likeCount
        );
    }

    /**
     * Test getting a like by ID.
     */
    @Test
    public void testGetLikeById()
    {
        Like like = getLikeDao().getById(1L);

        assertEquals(
                "Asserting that the user ID of the like is 1",
                1L,
                like.getUserId()
        );

        assertEquals(
                "Asserting that the idea ID of the like is 0",
                0L,
                like.getIdeaId()
        );
    }

    /**
     * Get like DAO.
     *
     * @return The like DAO.
     */
    public LikeDAO getLikeDao()
    {
        return likeDao;
    }
}
