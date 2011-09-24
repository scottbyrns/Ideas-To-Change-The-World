package com.ideastobettertheworld.models;

import com.ideas.entities.ideas.Ideas;
import org.apache.wicket.model.IModel;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/23/11
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class IdeasModel implements IModel
{
    private IdeasModelType ideasModelType;
    private IModel ideasContainingModel;

    public IdeasModel(IdeasModelType ideasModelType, IModel ideasContainingModel)
    {
        this.ideasModelType = ideasModelType;
        this.ideasContainingModel = ideasContainingModel;
    }

    public Object getObject()
    {

        Ideas ideas = (Ideas)getIdeasContainingModel();

//        switch (getIdeasModelType())
//        {
//
//        }

        return null;
    }

    public void setObject(Object o)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void detach()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public IdeasModelType getIdeasModelType()
    {
        return ideasModelType;
    }

    public void setIdeasModelType(IdeasModelType ideasModelType)
    {
        this.ideasModelType = ideasModelType;
    }

    public IModel getIdeasContainingModel()
    {
        return ideasContainingModel;
    }

    public void setIdeasContainingModel(IModel ideasContainingModel)
    {
        this.ideasContainingModel = ideasContainingModel;
    }
}
