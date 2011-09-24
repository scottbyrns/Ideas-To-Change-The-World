package com.ideas.api.server.services;

import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import com.ideas.persistence.IdeaDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Service to provide a crud interface to ideas.
 *
 *
 * <h2> Endpoinds: </h2>
 * <p />
 * <h3> GET </h3>
 *
 * <h4> URL </h4>
 * http://host/api/idea/get/{id}
 *
 * <h4> Get Parameters </h4>
 * <ul>
 *     <li><strong>ID</strong> - The ID of the idea to retrieve.</li>
 * </ul>
 *
 * <h3> CREATE </h3>
 *
 * <h4> URL </h4>
 * http://host/api/idea/create
 *
 * <h4> Post </h4>
 * <code>
 * {
 *    "title": "Title Test",
 *    "ideaText": "This is test text."
 * }
 * </code>
 *
 */
@Path("/idea/")
@Produces(MediaType.APPLICATION_JSON)
public class IdeaService extends BaseService
{

    @Autowired
    IdeaDAO ideaDao;

    /**
     * Create a document.
     *
     * @return The document.
     *
     * @TODO Handle exceptions
     * @TODO Handle null ideas.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(String data)
    {

        try
        {
            Idea idea = (Idea)getObjectMapper().readValue(data, Idea.class);

            idea = getIdeaDao().saveIdea(idea);

            return getObjectMapper().writeValueAsString(idea);
        }
        catch (Exception e)
        {
            return e.getLocalizedMessage();
        }

    }

    /**
     * Get an idea by it's ID
     *
     * @return The idea.
     */
    @GET
    @Path("/get/{id}")
    public String get(@PathParam("id") String id)
    {

        Idea idea = getIdeaDao().getById(Long.valueOf(id));

        try
        {
            return getObjectMapper().writeValueAsString(idea);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }

    }

    /**
     * Get the latest ideas
     *
     * @param count Number of latest ideas to get.
     * @return The latest ideas.
     */
    @GET
    @Path("/latest/{count}")
    public String getIdeas(@PathParam("count") String count)
    {

        System.out.println("Get Latest");

        Ideas ideas = getIdeaDao().getRecentIdeas(Integer.valueOf(count));

        try
        {
            return getObjectMapper().writeValueAsString(ideas);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return e.getLocalizedMessage();
        }

    }

    /**
     * Get the idea dao.
     *
     * @return The idea dao.
     */
    private IdeaDAO getIdeaDao()
    {
        return ideaDao;
    }
}
