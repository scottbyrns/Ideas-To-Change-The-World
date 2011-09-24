import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import com.ideas.persistence.IdeaDAO;
import com.ideas.utils.HibernateUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;

/**
 * Test the Idea DAO
 */
//@SuppressWarnings(value = "true")
@ContextConfiguration(locations = {"classpath:beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestIdeaDAO  extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    IdeaDAO ideaDao;


    @Override
    public void setDataSource(DataSource dataSource)
    {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    /**
     * Test creating ideas.
     *
     * @TODO Actually test that the idea is saved.
     */
    @Test
    public void testCreateIdeas()
    {

        Idea idea = new Idea();
        idea.setTitle("Title");
        idea.setIdeaText("Idea Text");

        ideaDao.saveIdea(idea);

    }

    /**
     * Test getting recent ideas.
     */
    @Test
    public void testGetRecentIdeas()
    {

//        for (int i = 0; i < 50; i += 1)
//        {
//            Idea idea = new Idea();
//            idea.setIdeaText("Lorum Ipsum");
//            idea.setTitle("Title - ".concat(Integer.toString(i)));
//            ideaDao.saveIdea(idea);
//        }
//
//        HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//        HibernateUtil.getSessionFactory().openSession();

        Ideas ideas = ideaDao.getRecentIdeas(10);


        assertEquals(
                "Asserting that 10 items are returned from the getRecentIdeas call.",
                10,
                ideas.getIdeaList().size()
        );

    }


    /**
     * Test getting an idea by it's ID
     * <p />
     * @TODO This test is coupled to my development environments database. This test
     *       needs to be rewritten to decouple it.
     */
    @Test
    public void testGetIdeaById()
    {

        Idea idea = ideaDao.getById(1);

        assertEquals(
                "Asserting that the ideas title matches an expected value.",
                "Lorem Ipsum",
                idea.getTitle()
        );

        assertEquals(
                "Asserting that the idea text matches an expected value. ",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                idea.getIdeaText()
        );

    }
}
