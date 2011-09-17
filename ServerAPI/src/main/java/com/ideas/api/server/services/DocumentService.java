package com.ideas.api.server.services;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Service to manage and consume documents.
 */
@Path("/document/")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentService extends BaseCrudService<com.ideas.entities.documents.Document>
{

}
