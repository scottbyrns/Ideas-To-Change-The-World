package com.ideastobettertheworld.panels;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Base panel to abstract shared functionality of panels in this project.
 */
public abstract class BasePanel extends Panel
{
    public BasePanel(String id)
    {
        super(id);
        setupPanel();
    }

    public BasePanel(String id, IModel<?> model)
    {
        super(id, model);
        setupPanel();
    }

    /**
     * Method called after the panel is constructed to setup sub views.
     */
    public abstract void setupPanel ();
}
