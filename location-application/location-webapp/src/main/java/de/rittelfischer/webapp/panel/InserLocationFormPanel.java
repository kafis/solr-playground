/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.panel;

import de.rittelfischer.dataservice.service.DataService;
import de.rittelfischer.webapp.forms.InsertLocationForm;
import org.apache.wicket.markup.html.panel.Panel;

/**
 *
 * @author Konrad
 */
public class InserLocationFormPanel extends Panel{

    public InserLocationFormPanel(DataService ds){
        super("insertFormLocationPanel");
        this.add(new InsertLocationForm(ds));
    }
}
