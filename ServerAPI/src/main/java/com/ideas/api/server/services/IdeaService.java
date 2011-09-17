package com.ideas.api.server.services;

import com.ideas.entities.ideas.Idea;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Service to provide a crud interface to ideas.
 *
 * echo '{"name":"Paint The Buildings!", "idea":"With blue!"}' | curl -X POST -H 'Content-type: application/json; charset=UTF-8' -d @- http://localhost:8081/api/idea/create
 */
@Path("/idea/")
@Produces(MediaType.APPLICATION_JSON)
public class IdeaService extends BaseService
{

}
