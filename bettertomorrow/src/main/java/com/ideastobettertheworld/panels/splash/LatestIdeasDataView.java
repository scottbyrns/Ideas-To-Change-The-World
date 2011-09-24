package com.ideastobettertheworld.panels.splash;

import com.ideas.entities.ideas.Idea;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.CompoundPropertyModel;

/**
 * @TODO javadoc
 */
public class LatestIdeasDataView extends DataView<Idea>
{

    public LatestIdeasDataView(String id, IDataProvider<Idea> ideaIDataProvider)
    {
        super(id, ideaIDataProvider);
    }

    public LatestIdeasDataView(String id, IDataProvider<Idea> ideaIDataProvider, int itemsPerPage)
    {
        super(id, ideaIDataProvider, itemsPerPage);
    }

    @Override
    protected void populateItem(Item<Idea> ideaItem)
    {
        ideaItem.setModel(new CompoundPropertyModel<Idea>(ideaItem.getModelObject()));
        ideaItem.add(new Label("title"));
        ideaItem.add(new Label("ideaText"));
    }
}
