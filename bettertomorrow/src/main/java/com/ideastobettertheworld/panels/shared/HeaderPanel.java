package com.ideastobettertheworld.panels.shared;

import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.model.IModel;

/**
 * Header of the website.
 */
public class HeaderPanel extends BasePanel
{
    public HeaderPanel(String id)
    {
        super(id);
    }

    public HeaderPanel(String id, IModel<?> model)
    {
        super(id, model);
    }

    /**
     * Method called after the panel is constructed to setup sub views.
     */
    public void setupPanel()
    {

    }
}
