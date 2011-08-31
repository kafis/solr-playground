/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.forms;

import de.rittelfischer.dataservice.model.Location;
import de.rittelfischer.dataservice.model.Need;
import de.rittelfischer.dataservice.service.DataService;
import de.rittelfischer.webapp.forms.list.ListEditor;
import de.rittelfischer.webapp.forms.list.ListItem;
import de.rittelfischer.webapp.pages.ShowAllLocationsPage;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.form.Button;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;

/**
 *
 * @author Konrad
 */
public class InsertLocationForm extends Form<Location> {
    private final DataService ds;
    private Location l = new Location();
    
    public InsertLocationForm(DataService ds){
       super("insertLocationForm");
       this.ds = ds;
        l = new Location();
        l.getNeeds().add(new Need());
       final ListEditor<Need> listEditor= new ListEditor<Need>("needs",new PropertyModel(l,"needs")) {

            @Override
            protected void onPopulateItem(ListItem<Need> item) {
                item.add(new TextField("need",new PropertyModel(item.getModelObject(), "need")));
            }
        };
       
       
       this.add(new TextField("name",new PropertyModel(l, "name")));
       this.add(new TextArea("description", new PropertyModel(l, "description")));
       this.add(new TextArea("address",new PropertyModel(l, "address")));
       this.add(listEditor);
       
       add(new Button("add")
        {
            public void onSubmit()
            {
                listEditor.addItem(new Need());
            }
        }.setDefaultFormProcessing(false));
       
    
    }

    @Override
    protected void onSubmit() {
        ds.saveLocation(
            l
         );
        setResponsePage(ShowAllLocationsPage.class);
    }
    
    

}
