package com.ideas;

import com.ideas.api.client.services.ideas.IdeasService;
import com.ideas.entities.ideas.Idea;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/17/11
 * Time: 9:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestIdeasService
{

    @org.junit.Test
    public void testRequestURL () throws Exception
    {
        IdeasService service = new IdeasService();
        Idea idea = service.getIdeaById(1);
        idea.getId();
    }
}
