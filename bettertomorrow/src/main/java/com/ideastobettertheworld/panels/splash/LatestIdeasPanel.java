package com.ideastobettertheworld.panels.splash;

import com.ideastobettertheworld.models.LatestIdeasDataProvider;
import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.model.IModel;

/**
 * Latest ideas.
 */
public class LatestIdeasPanel extends BasePanel
{
    public LatestIdeasPanel(String id)
    {
        super(id);
    }

    public LatestIdeasPanel(String id, IModel<?> model)
    {
        super(id, model);
    }

    /**
     * Method called after the panel is constructed to setup sub views.
     */
    public void setupPanel()
    {
        add(new IdeasDataView(
                "rows",
                new LatestIdeasDataProvider()
        ));
    }
}
