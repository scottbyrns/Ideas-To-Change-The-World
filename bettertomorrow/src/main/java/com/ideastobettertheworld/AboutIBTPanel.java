package com.ideastobettertheworld;

import com.ideastobettertheworld.panels.BasePanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.util.value.ValueMap;

/**
 * Panel for the about header.
 */
public class AboutIBTPanel extends BasePanel
{

    public AboutIBTPanel(String id) {
        super(id);
    }

    public AboutIBTPanel(String id, IModel<?> model) {
        super(id, model);
    }

    public void setupPanel ()
    {
        StringResourceModel labelModel = new StringResourceModel(
                "about-label",
                this,
                new Model<ValueMap>()
        );

        StringResourceModel textModel = new StringResourceModel(
                "about-text",
                this,
                new Model<ValueMap>()
        );

        add(
                new Label("about-label", labelModel)
        );

        add(
                new Label("about-text", textModel)
        );

    }
}
