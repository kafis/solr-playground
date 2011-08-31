/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp;

import de.rittelfischer.webapp.pages.InsertDataPage;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.wicketstuff.javaee.injection.JavaEEComponentInjector;

/**
 *
 * @author Konrad
 */
public class Application extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return InsertDataPage.class;
    }
    
    @Override
	public void init()
	{
		super.init();
		
		getComponentInstantiationListeners().add((new JavaEEComponentInjector(this)));
		//this.getFrameworkSettings().setSerializer(new EJBSerializer(getApplicationKey()));
		

		
	}

}
