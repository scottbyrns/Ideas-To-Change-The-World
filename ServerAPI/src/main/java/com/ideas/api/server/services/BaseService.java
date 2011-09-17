package com.ideas.api.server.services;

import com.ideas.utils.JSONObjectMapper;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Abstraction of service functionality shared by all services.
 */
public class BaseService
{
    private ObjectMapper objectMapper = JSONObjectMapper.getInstance().createDefaultObjectMapper();

    /**
     * Get the JSON Object Mapper
     *
     * @return The JSON object mapper.
     */
    public ObjectMapper getObjectMapper()
    {
        return objectMapper;
    }

}
