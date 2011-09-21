package com.ideastobettertheworld.my;

import com.ideastobettertheworld.panels.shared.HeaderPanel;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;

/**
 * Page to display ideas owned by the current user.
 */
public class Ideas extends WebPage
{
    private static final long serialVersionUID = 1L;

    public Ideas()
    {
        add(
                new HeaderPanel("header")
        );
    }

    /**
     * Constructor that is invoked when page is invoked without a session.
     *
     * @param parameters Page parameters
     */
    public Ideas(final PageParameters parameters)
    {
        add(
                new HeaderPanel("header")
        );
    }

}

