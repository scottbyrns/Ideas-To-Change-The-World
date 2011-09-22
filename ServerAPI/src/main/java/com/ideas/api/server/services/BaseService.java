package com.ideas.api.server.services;

import com.ideas.utils.JSONObjectMapper;
import org.apache.cxf.jaxrs.ext.MessageContext;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.Context;

/**
 * Abstraction of service functionality shared by all services.
 */
public class BaseService
{
    @Context
    private MessageContext context;

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

    public MessageContext getContext() {
        return context;
    }

    public void setContext(MessageContext context) {
        this.context = context;
    }
}
