package com.ideas.entities.ideas;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/20/11
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Ideas
{
    private List<Idea> ideaList;

    public List<Idea> getIdeaList()
    {
        return ideaList;
    }

    public void setIdeaList(List<Idea> ideaList)
    {
        this.ideaList = ideaList;
    }
}
