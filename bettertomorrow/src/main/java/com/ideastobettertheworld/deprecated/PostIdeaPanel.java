package com.ideastobettertheworld.deprecated;

import com.ideastobettertheworld.forms.PostIdeaForm;
import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.model.IModel;

/**
 *
 */
public class PostIdeaPanel extends BasePanel
{
    public PostIdeaPanel(String id)
    {
        super(id);
    }

    public PostIdeaPanel(String id, IModel<?> model)
    {
        super(id, model);
    }

    /**
     * Method called after the panel is constructed to setup sub views.
     */
    public void setupPanel()
    {
        add(
                new PostIdeaForm("ideaForm")
        );
    }
}
