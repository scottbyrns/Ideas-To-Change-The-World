package com.ideas.api.server.services;

import com.ideas.entities.ideas.Idea;
import com.ideas.utils.HibernateUtil;
import org.hibernate.Session;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Service to provide a crud interface to ideas.
 *
 * echo '{"name":"Paint The Buildings!", "idea":"With blue!"}' | curl -X POST -H 'Content-type: application/json; charset=UTF-8' -d @- http://localhost:8081/api/idea/create
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
            Idea idea = getObjectMapper().readValue(data, Idea.class);

            data = getObjectMapper().writeValueAsString(idea);

            Session session = HibernateUtil.getSessionFactory().getCurrentSession();

            session.beginTransaction();

            session.save(idea);
            session.getTransaction().commit();

            HibernateUtil.getSessionFactory().close();

            return data;
        }
        catch (Exception e)
        {
            return e.getLocalizedMessage();
        }

    }

}
