package com.ideas.api.server.services;

import com.ideas.entities.documents.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Service to manage and consume components.
 */
@Path("/component/")
@Produces(MediaType.APPLICATION_JSON)
public class ComponentService extends BaseService<Component>
{

}
