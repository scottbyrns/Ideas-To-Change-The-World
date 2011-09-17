package com.ideas.api.client.services.ideas;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import com.ideas.entities.ideas.Idea;

/**
 * Client service for interfacing with the Ideas endpoints of the server api.
 */
public class IdeasService extends BaseService
{

    public Idea getIdeaById(long id)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(IdeaMethods.GET);
        apiRequest.addRequestParameter(
                "id",
                Long.toString(id)
        );

        System.out.println(apiRequest.getRequestUrl());

        APIResponse apiResponse = getAPIClient().<Idea>makeRequest(apiRequest);

        return (Idea) apiResponse.getResponseEntity(Idea.class);
    }

}
