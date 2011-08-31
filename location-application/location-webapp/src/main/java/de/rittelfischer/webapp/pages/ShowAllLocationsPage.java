/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.pages;

import de.rittelfischer.dataservice.service.DataService;
import de.rittelfischer.webapp.panel.AllLocationsPanel;
import javax.ejb.EJB;

/**
 *
 * @author Konrad
 */
public class ShowAllLocationsPage extends HomePage{
    
    @EJB(name="ejb/DataService") 
    DataService ds;
    
    public ShowAllLocationsPage(){
        super();
        this.add(new AllLocationsPanel(ds));
    }

}
