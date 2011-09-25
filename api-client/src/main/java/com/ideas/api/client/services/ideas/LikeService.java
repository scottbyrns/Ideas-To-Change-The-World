package com.ideas.api.client.services.ideas;

import com.ideas.api.client.APIRequest;
import com.ideas.api.client.APIResponse;
import com.ideas.api.client.RequestType;
import com.ideas.api.client.services.BaseService;
import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Like;
import com.ideas.entities.ideas.LikeCount;
import com.ideas.utils.JSONObjectMapper;

import java.io.IOException;

/**
 * Client service for interfacing with the like endpoints of the server api.
 */
public class LikeService extends BaseService
{
    /**
     * Create a new like.
     *
     * @param like The like to create.
     * @return The newly created like.
     */
    public Like createLike (Like like)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.JSON_POST);
        apiRequest.setRequestUrl(LikeMethods.CREATE);
        try
        {
            apiRequest.addRequestParameter(
                    APIRequest.JSON_DATA,
                    JSONObjectMapper.getInstance().createDefaultObjectMapper().writeValueAsString(like)
            );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        APIResponse apiResponse = getAPIClient().<Like>makeRequest(apiRequest);

        return (Like) apiResponse.getResponseEntity(Like.class);
    }

    public LikeCount getLikeCountForIdea (Idea idea)
    {
        APIRequest apiRequest = createAPIRequest();

        apiRequest.setRequestType(RequestType.GET);
        apiRequest.setRequestUrl(LikeMethods.GET_LIKE_COUNT_FOR_IDEA);

        apiRequest.addRequestParameter(
                "id",
                String.valueOf(idea.getId())
        );

        APIResponse apiResponse = getAPIClient().<LikeCount>makeRequest(apiRequest);

        return (LikeCount) apiResponse.getResponseEntity(LikeCount.class);
    }
}
