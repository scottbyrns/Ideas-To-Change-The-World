package com.ideas.api.client.services;

import com.ideas.api.client.APIClient;
import com.ideas.api.client.APIRequest;

/**
 * Abstraction of behaviors shared between all services.
 */
public class BaseService
{

    protected APIRequest createAPIRequest ()
    {
        return new APIRequest();
    }

    protected APIClient getAPIClient ()
    {
        return APIClient.getInstance();
    }

}
