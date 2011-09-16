package com.ideas.api.server.services;

import com.ideas.entities.documents.Document;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

/**
 * Service to manage and consume documents.
 */
@Path("/document/")
@Produces(MediaType.APPLICATION_JSON)
public class DocumentService extends BaseService<Document>
{

}
