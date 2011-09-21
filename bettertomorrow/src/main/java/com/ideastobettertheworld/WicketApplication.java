package com.ideastobettertheworld;

import com.ideastobettertheworld.my.Ideas;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.PackageName;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 * 
 * @see com.ideastobettertheworld.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{    
    /**
     * Constructor
     */
	public WicketApplication()
	{
	}

    @Override
    protected void init()
    {
        super.init();

        getDebugSettings().setAjaxDebugModeEnabled(true);

        mount("my", PackageName.forClass(Ideas.class));
    }

    /**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<HomePage> getHomePage()
	{
		return HomePage.class;
	}

    public Class<Ideas> getMyIdeas()
    {
        return Ideas.class;
    }
}
