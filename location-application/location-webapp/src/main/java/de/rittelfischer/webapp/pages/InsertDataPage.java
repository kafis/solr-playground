/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.pages;

import de.rittelfischer.dataservice.service.DataService;
import de.rittelfischer.webapp.panel.InserLocationFormPanel;
import de.rittelfischer.webapp.forms.InsertLocationForm;
import de.rittelfischer.webapp.forms.autosuggest.AutoSuggestConfiguration;
import de.rittelfischer.webapp.forms.autosuggest.AutoSuggestTextField;
import javax.ejb.EJB;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Konrad
 */
public class InsertDataPage extends HomePage {
    
    @EJB(name="ejb/DataService")
    DataService ds;
    public InsertDataPage(){
        super();
        this.add(new InserLocationFormPanel(ds));
    }

}
