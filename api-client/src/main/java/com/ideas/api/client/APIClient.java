package com.ideas.api.client;

import com.ideas.utils.JSONObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * API Client to that will make requests to APIs.
 */
public class APIClient
{

    private static final APIClient instance = new APIClient();

    public static APIClient getInstance()
    {
        return instance;
    }

    private APIClient()
    {
    }

    private JSONObjectMapper objectMapper = JSONObjectMapper.getInstance();

    /**
     * Get the JSON Object mapper.
     *
     * @return JSON Object Mapper.
     */
    private JSONObjectMapper getObjectMapper()
    {
        return objectMapper;
    }


    /**
     * Make an API request.
     *
     * @param request The request to make.
     * @return The response from the API.
     */
    public <ResponseEntity> APIResponse makeRequest(APIRequest request)
    {
        APIResponse<ResponseEntity> apiResponse = new APIResponse<ResponseEntity>();

        // get a client connection
        HttpClient httpclient = new DefaultHttpClient();
        HttpParams clientParams = httpclient.getParams();
        HttpConnectionParams.setConnectionTimeout(clientParams, 20000);
        HttpConnectionParams.setSoTimeout(clientParams, 20000);

        HttpGet get = new HttpGet(request.getRequestUrl().toString());

        HttpResponse response = null;
        try
        {
            response = httpclient.execute(get);
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        if (null != response)
        {
            HttpEntity resEntity = response.getEntity();
            try
            {
                apiResponse.setRawResponseString(EntityUtils.toString(resEntity));
            }
            catch (IOException e)
            {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return apiResponse;
    }
}
