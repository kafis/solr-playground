/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.panel;

import de.rittelfischer.dataservice.model.Location;
import de.rittelfischer.dataservice.service.DataService;
import java.util.List;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.list.PropertyListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.LoadableDetachableModel;

/**
 *
 * @author Konrad
 */
public class AllLocationsPanel extends Panel{
    
    DataService ds;
    public AllLocationsPanel(DataService ds){
        super("locations");
        this.ds = ds;
        this.add(new PropertyListView("locationsTable", new LocationsModel(ds)) {

            @Override
            protected void populateItem(ListItem li) {
                li.add(new Label("name"));
                li.add(new TextArea("description"));
                li.add(new TextArea("address"));
                li.add(new PropertyListView("needs",((Location)li.getModel().getObject()).getNeeds())  {

                    @Override
                    protected void populateItem(ListItem li) {
                        li.add(new Label("need"));
                    }
                });
            }
        });
        
    }
    
    
    private static class LocationsModel extends LoadableDetachableModel<List<Location>>{
        private final DataService ds;

        public LocationsModel(DataService ds){
            this.ds=ds;
        }
        @Override
        protected List<Location> load() {
            return ds.loadAllLocations();
        }
        
    } 

}
