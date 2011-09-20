package com.ideastobettertheworld.panels.splash;

import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.model.IModel;

/**
 * Search box panel.
 */
public class SearchBoxPanel extends BasePanel
{
    public SearchBoxPanel(String id)
    {
        super(id);
    }

    public SearchBoxPanel(String id, IModel<?> model)
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
