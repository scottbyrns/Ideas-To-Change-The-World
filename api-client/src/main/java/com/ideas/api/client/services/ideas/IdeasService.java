package com.ideas.api.client.services.ideas;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import com.ideas.utils.JSONObjectMapper;

import java.io.IOException;
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
     * @param numberOfLatestToGet
     * @return
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

        return (Ideas) apiResponse.getResponseEntity(Ideas.class);
    }
}
