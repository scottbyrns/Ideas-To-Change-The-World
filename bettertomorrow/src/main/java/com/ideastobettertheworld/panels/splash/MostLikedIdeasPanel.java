package com.ideastobettertheworld.panels.splash;

import com.ideastobettertheworld.models.LatestIdeasDataProvider;
import com.ideastobettertheworld.models.MostLikedIdeasDataProvider;
import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.model.IModel;

/**
 * Most liked ideas panel.
 */
public class MostLikedIdeasPanel extends BasePanel
{
    public MostLikedIdeasPanel(String id)
    {
        super(id);
    }

    public MostLikedIdeasPanel(String id, IModel<?> model)
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
                new MostLikedIdeasDataProvider()
        ));
    }
}
