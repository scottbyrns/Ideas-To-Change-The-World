package com.ideas.api.server.services;

import com.ideas.entities.ideas.Idea;
import com.ideas.persistance.IdeaDAO;
import com.ideas.utils.HibernateUtil;
import org.hibernate.Session;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

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


    /**
     * Create a document.
     *
     * @return The document.
     *
     * @todo Use unique ID from mongo.
     * @todo Handle exceptions
     * @todo Handle null ideas.
     */
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(String data)
    {


        try
        {
            Idea idea = (Idea)getObjectMapper().readValue(data, Idea.class);

            IdeaDAO ideaDAO = new IdeaDAO();
            idea = ideaDAO.saveIdea(idea);

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
        IdeaDAO ideaDAO = new IdeaDAO();
        Idea idea = ideaDAO.getById(Long.valueOf(id));

//        Idea mappableIdea = new Idea();
//        mappableIdea.setId(idea.getId());
//        mappableIdea.setIdeaText(idea.getIdeaText());
//        mappableIdea.setTitle(idea.getTitle());
//
//        idea = null;

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

}
