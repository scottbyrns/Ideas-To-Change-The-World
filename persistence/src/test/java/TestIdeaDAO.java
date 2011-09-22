import com.ideas.entities.ideas.Idea;
import com.ideas.persistence.IdeaDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.sql.DataSource;

/**
 * Test the Idea DAO
 */
@SuppressWarnings(value = "true")
@ContextConfiguration(locations = {"classpath:beans.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
public class TestIdeaDAO  extends AbstractTransactionalJUnit4SpringContextTests
{
    @Autowired
    IdeaDAO ideaDao;


    @Override
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Test
    public void testCreateIdeas() throws Exception
    {
        Idea idea = new Idea();
        idea.setIdeaText("asdfasdf");
        idea.setTitle("123");
        ideaDao.saveIdea(idea);
        ideaDao.saveIdea(idea);
        ideaDao.saveIdea(idea);
        ideaDao.saveIdea(idea);
    }

    @Test
    public void testGetRecentIdeas() throws Exception
    {

        Idea idea = new Idea();
        idea.setIdeaText("asdfasdf");
        idea.setTitle("123");
        ideaDao.saveIdea(idea);
        ideaDao.saveIdea(idea);
        ideaDao.saveIdea(idea);
        ideaDao.saveIdea(idea);

        ideaDao.getRecentIdeas(1);
    }

    @Test
    public void testGetIdeaById() throws Exception
    {
        ideaDao.getById(1);
    }
}
