package com.ideastobettertheworld;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

/**
 * Created by IntelliJ IDEA.
 * User: scott
 * Date: 9/17/11
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseForm<Type> extends Form<Type>
{
    public BaseForm(String id)
    {
        super(id);
        setupForm();
    }

    public BaseForm(String id, IModel<Type> typeIModel)
    {
        super(id, typeIModel);
        setupForm();
    }

    /**
     * Setup the form.
     */
    public abstract void setupForm ();
}
