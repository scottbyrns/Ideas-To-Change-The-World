package com.ideastobettertheworld;

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/17/11
 * Time: 6:45 PM
 * To change this template use File | Settings | File Templates.
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
