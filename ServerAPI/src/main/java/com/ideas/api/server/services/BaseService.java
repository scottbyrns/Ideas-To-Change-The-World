package com.ideas.api.server.services;

import com.ideas.persistance.DynamicModelDAO;
import com.ideas.persistance.MongoCollectionDAO;
import com.ideas.utils.GenericsUtil;
import com.ideas.utils.JacksonFactory;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.UUID;

/**
 * Abstraction of service functionality shared by all services.
 */
public class BaseService<CreateType>
{
    private DynamicModelDAO dynamicModelDao;
    private ObjectMapper objectMapper = JacksonFactory.getInstance().createDefaultObjectMapper();

    /**
     * Set the dynamic model DAO
     *
     * @param dynamicModelDao The dynamic model DAO
     */
    public void setDynamicModelDao(DynamicModelDAO dynamicModelDao)
    {
        this.dynamicModelDao = dynamicModelDao;
    }

    /**
     * get the dynamic model DAO
     *
     * @return The dynamic model DAO
     */
    public DynamicModelDAO getDynamicModelDao()
    {
        return dynamicModelDao;
    }

    /**
     * Get the JSON Object Mapper
     *
     * @return The JSON object mapper.
     */
    public ObjectMapper getObjectMapper()
    {
        return objectMapper;
    }

    /**
     * Get an idea by it's ID
     *
     * @return The idea.
     */
    @GET
    @Path("/get/{id}")
    public String get(@PathParam("id") String id)
    {
        return getDynamicModelDao().findById(id);
    }

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

        CreateType document = null;

        String id = UUID.randomUUID().toString();

        try
        {
            document = (CreateType)getObjectMapper().readValue(data, getCreateClass());

            data = getObjectMapper().writeValueAsString(document);

            getDynamicModelDao().create(data, id);

            return get(id);
        }
        catch (Exception e)
        {
            return e.getLocalizedMessage();
            // NOP
        }

//        return "";

    }

    public Class<?> getCreateClass()
    {
        return (Class<?>) ((ParameterizedType)(BaseService.this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
//        return (Class<?>) (((ParameterizedType) (BaseService.class.getGenericSuperclass())).getActualTypeArguments()[0]);
//        GenericsUtil.getTypeVariableClassByName(BaseService.this.getClass(), , "CreateType", false);
    }
}
