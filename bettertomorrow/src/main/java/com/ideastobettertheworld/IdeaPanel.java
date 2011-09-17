package com.ideastobettertheworld;

import com.ideas.api.client.services.ideas.IdeasService;
import com.ideas.entities.ideas.Idea;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.util.value.ValueMap;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/17/11
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class IdeaPanel extends Panel
{
    public IdeaPanel(String id)
    {
        super(id);
        setupPanel();
    }

    public IdeaPanel(String id, IModel<?> model)
    {
        super(id, model);
        setupPanel();
    }

    private void setupPanel ()
    {

        Idea idea = new IdeasService().getIdeaById(7L);

//        StringResourceModel labelModel = new StringResourceModel(
//                "idea-title-label",
//                this,
//                new Model<ValueMap>()
//        );
//
//        StringResourceModel textModel = new StringResourceModel(
//                "idea-text",
//                this,
//                new Model<ValueMap>()
//        );

        add(
                new Label("idea-title-label", idea.getTitle())
        );

        add(
                new Label("idea-text", idea.getIdeaText())
        );

    }
}
