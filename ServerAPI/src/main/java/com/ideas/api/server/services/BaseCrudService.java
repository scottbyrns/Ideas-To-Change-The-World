package com.ideas.api.server.services;

import com.ideas.persistance.DynamicModelDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.lang.reflect.ParameterizedType;
import java.util.UUID;

/**
 * Abstraction of basic CRUD operations for services.
 */
public class BaseCrudService<CreateType> extends BaseService
{

    private DynamicModelDAO dynamicModelDao;

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

    }

    public Class<?> getCreateClass()
    {
        return (Class<?>) ((ParameterizedType)(BaseCrudService.this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
    }
}
