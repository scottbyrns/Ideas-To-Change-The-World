package com.ideastobettertheworld;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.StringResourceModel;
import org.apache.wicket.util.value.ValueMap;

/**
 * Homepage
 */
public class HomePage extends WebPage
{

    private static final long serialVersionUID = 1L;

    private ValueMap valueMap = new ValueMap();

    /**
     * Constructor that is invoked when page is invoked without a session.
     *
     * @param parameters Page parameters
     */
    public HomePage (final PageParameters parameters)
    {

        StringResourceModel labelModel = new StringResourceModel(
                "introduction",
                this,
                new Model<ValueMap>(
                        getValueMap()
                )
        );


        add(
                new Label("introduction", labelModel)
        );

    }

    /**
     * Get the value map.
     *
     * @return The value map.
     */
    private ValueMap getValueMap ()
    {
        return valueMap;
    }

    /**
     * Set the value map.
     *
     * @param valueMap The value map.
     */
    private void setValueMap (ValueMap valueMap)
    {
        this.valueMap = valueMap;
    }
}