package com.ideastobettertheworld.panels.splash;

import com.ideastobettertheworld.forms.PostIdeaForm;
import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.model.IModel;

/**
 * Panel for sharing your idea.
 */
public class YourIdeaPanel extends BasePanel
{
    public YourIdeaPanel(String id)
    {
        super(id);
    }

    public YourIdeaPanel(String id, IModel<?> model)
    {
        super(id, model);
    }

    /**
     * Method called after the panel is constructed to setup sub views.
     */
    @Override
    public void setupPanel()
    {
        add(
                new PostIdeaForm("idea-form")
        );
    }
}
