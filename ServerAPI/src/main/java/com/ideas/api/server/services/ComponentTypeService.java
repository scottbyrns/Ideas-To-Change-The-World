package com.ideas.api.server.services;

import com.ideas.entities.documents.ComponentType;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Service to manage and consume component types.
 */
@Path("/componentType/")
@Produces(MediaType.APPLICATION_JSON)
public class ComponentTypeService extends BaseCrudService<ComponentType>
{

}
