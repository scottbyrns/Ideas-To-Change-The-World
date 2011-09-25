package com.ideas.api.client.services.ideas;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import com.ideas.entities.ideas.LikeCount;
import com.ideas.utils.JSONObjectMapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Client service for interfacing with the Ideas endpoints of the server api.
 */
public class IdeasService extends BaseService
{

    /**
     * Get an idea by it's ID.
     *
     * @param id The ID of the idea.
     * @return The requested idea.
     */
    public Idea getIdeaById(long id)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(IdeaMethods.GET);
        apiRequest.addRequestParameter(
                "id",
                Long.toString(id)
        );

        APIResponse apiResponse = getAPIClient().<Idea>makeRequest(apiRequest);

        return (Idea) apiResponse.getResponseEntity(Idea.class);
    }

    /**
     * Create a new idea.
     *
     * @param idea The idea to create.
     * @return The newly created idea.
     */
    public Idea createIdea (Idea idea)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.JSON_POST);
        apiRequest.setRequestUrl(IdeaMethods.CREATE);
        try
        {
            apiRequest.addRequestParameter(
                    APIRequest.JSON_DATA,
                    JSONObjectMapper.getInstance().createDefaultObjectMapper().writeValueAsString(idea)
            );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        APIResponse apiResponse = getAPIClient().<Idea>makeRequest(apiRequest);

        return (Idea) apiResponse.getResponseEntity(Idea.class);
    }

    /**
     * Get the latest ideas.
     *
     * @param numberOfLatestToGet The number of latest ideas to get.
     * @return The latest ideas.
     */
    public Ideas getLatest (int numberOfLatestToGet)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(IdeaMethods.GET_LATEST);
        apiRequest.addRequestParameter(
                "count",
                Long.toString(numberOfLatestToGet)
        );

        APIResponse apiResponse = getAPIClient().<Ideas>makeRequest(apiRequest);

        Ideas ideas = (Ideas) apiResponse.getResponseEntity(Ideas.class);

        Iterator<Idea> ideaIterator = ideas.getIdeaList().iterator();

        while(ideaIterator.hasNext())
        {
            Idea idea = ideaIterator.next();

            LikeCount likeCount = new LikeCount();
            likeCount.setCount(idea.getLikeList().size());

            idea.setLikeCount(likeCount);
        }

        return ideas;
    }

    /**
     * Get the most liked ideas.
     *
     * @param numberOfLikedIdeasToGet Number of most liked ideas to get.
     * @return The most liked ideas.
     */
    public Ideas getMostLikedIdeas (int numberOfLikedIdeasToGet)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(IdeaMethods.GET_MOST_LIKED);
        apiRequest.addRequestParameter(
                "count",
                Long.toString(numberOfLikedIdeasToGet)
        );

        APIResponse apiResponse = getAPIClient().makeRequest(apiRequest);

        Ideas ideas = (Ideas) apiResponse.getResponseEntity(Ideas.class);



        Iterator<Idea> ideaIterator = ideas.getIdeaList().iterator();

        while(ideaIterator.hasNext())
        {
            Idea idea = ideaIterator.next();

            LikeCount likeCount = new LikeCount();
            likeCount.setCount(idea.getLikeList().size());

            idea.setLikeCount(likeCount);
        }

        return ideas;
    }
}
