package com.ideas.api.server.services;

import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Like;
import com.ideas.entities.ideas.LikeCount;
import com.ideas.persistence.LikeDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Service for liking ideas.
 */
@Path("/like/")
@Produces(MediaType.APPLICATION_JSON)
public class LikeService extends BaseService
{

    @Autowired
    LikeDAO likeDAO;


    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public String create(String data)
    {

        try
        {
            Like like = (Like)getObjectMapper().readValue(data, Like.class);

            like = getLikeDAO().saveLike(like);

            return getObjectMapper().writeValueAsString(like);
        }
        catch (Exception e)
        {
            return e.getLocalizedMessage();
        }

    }

    @GET
    @Path("/getLikeCountForIdeaWithId/{id}")
    public String getLikeCountForIdea (@PathParam("id") String id)
    {
        Idea idea = new Idea();
        idea.setId(Long.valueOf(id));

        LikeCount likeCount = getLikeDAO().getLikeCountForIdea(idea);


        try
        {
            return getObjectMapper().writeValueAsString(likeCount);
        }
        catch (IOException e)
        {
            return e.getLocalizedMessage();
        }
    }

    /**
     * Get the Like DAO.
     *
     * @return The like DAO.
     */
    public LikeDAO getLikeDAO()
    {
        return likeDAO;
    }
}
