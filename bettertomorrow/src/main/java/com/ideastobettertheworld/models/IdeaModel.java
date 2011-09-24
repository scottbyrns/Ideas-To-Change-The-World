package com.ideastobettertheworld.models;

import com.ideas.entities.ideas.Idea;
import org.apache.wicket.model.IModel;

/**
 *
 */
public class IdeaModel implements IModel
{
    private IdeaModelType ideaModelType;
    private IModel ideaContainingModel;

    /**
     * Construct the idea model.
     *
     * @param ideaModelType
     * @param ideaContainingModel
     */
    public IdeaModel(IdeaModelType ideaModelType, IModel ideaContainingModel)
    {
        setIdeaContainingModel(ideaContainingModel);
        setIdeaModelType(ideaModelType);
    }

    public Object getObject()
    {
        Idea idea = (Idea)getIdeaContainingModel().getObject();

        switch (getIdeaModelType())
        {

            case TITLE_MODEL:
                return idea.getTitle();

            case IDEA_TEXT_MODEL:
                return idea.getIdeaText();
        }

        return null;
    }

    public void setObject(Object object)
    {
        Idea idea = (Idea)getIdeaContainingModel().getObject();

        switch (getIdeaModelType())
        {

            case TITLE_MODEL:
                idea.setTitle((String)object);
                break;

            case IDEA_TEXT_MODEL:
                idea.setIdeaText((String)object);
                break;
        }

    }

    public void detach()
    {
        getIdeaContainingModel().detach();
    }

    /**
     * Get the type of the idea model.
     *
     * @return The type of the idea model.
     */
    private IdeaModelType getIdeaModelType()
    {
        return ideaModelType;
    }

    /**
     * Set the type of the idea model.
     *
     * @param ideaModelType The type of the idea model.
     */
    private void setIdeaModelType(IdeaModelType ideaModelType)
    {
        this.ideaModelType = ideaModelType;
    }

    /**
     * Get the idea containing model.
     *
     * @return The idea containing model.
     */
    private IModel getIdeaContainingModel()
    {
        return ideaContainingModel;
    }

    /**
     * Set the idea containing model.
     *
     * @param ideaContainingModel The idea containing model.
     */
    private void setIdeaContainingModel(IModel ideaContainingModel)
    {
        this.ideaContainingModel = ideaContainingModel;
    }
}
