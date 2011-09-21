package com.ideastobettertheworld.deprecated;

import com.ideas.api.client.services.ideas.IdeasService;
import com.ideas.entities.ideas.Idea;
import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/17/11
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class IdeaPanel extends BasePanel
{

    public IdeaPanel(String id)
    {
        super(id);
    }

    public IdeaPanel(String id, IModel<?> model)
    {
        super(id, model);
    }

    public void setupPanel ()
    {

        Idea idea = new IdeasService().getIdeaById(7L);

        add(
                new Label("idea-title-label", idea.getTitle())
        );

        add(
                new Label("idea-text", idea.getIdeaText())
        );

    }
}
