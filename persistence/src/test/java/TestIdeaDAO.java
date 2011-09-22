import com.ideas.persistence.IdeaDAO;
import org.junit.Test;

/**
 * Test the Idea DAO
 */
public class TestIdeaDAO
{
    @Test
    public void testASDF() throws Exception
    {
        new IdeaDAO().getRecentIdeas(1);
    }

    @Test
    public void testGetIdeaById() throws Exception
    {
        new IdeaDAO().getById(1);
    }
}
