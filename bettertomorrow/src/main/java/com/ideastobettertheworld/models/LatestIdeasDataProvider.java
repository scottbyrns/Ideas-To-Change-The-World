package com.ideastobettertheworld.models;

import com.ideas.api.client.services.ideas.IdeasService;
import com.ideas.entities.ideas.Idea;
import com.ideas.entities.ideas.Ideas;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import java.util.Iterator;

/**
 * Data provider for latest ideas.
 */
public class LatestIdeasDataProvider implements IDataProvider<Idea>
{
    private Ideas ideas;

    public LatestIdeasDataProvider()
    {
        IdeasService ideasService = new IdeasService();
        Ideas ideas = ideasService.getLatest(10);

        setIdeas(ideas);
    }

    public Iterator<Idea> iterator(int first, int count)
    {
        return getIdeas().getIdeaList().iterator();
    }

    public int size()
    {
        return getIdeas().size();
    }

    public IModel<Idea> model(final Idea idea)
    {
        return new LoadableDetachableModel<Idea>()
        {
            @Override
            protected Idea load()
            {
                return idea;
            }
        };
    }

    public void detach()
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     * Get the ideas.
     *
     * @return The ideas.
     */
    public Ideas getIdeas()
    {
        return ideas;
    }

    /**
     * Set the ideas.
     *
     * @param ideas The ideas.
     */
    public void setIdeas(Ideas ideas)
    {
        this.ideas = ideas;
    }
}
