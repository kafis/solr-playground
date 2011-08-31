/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.pages;

import de.rittelfischer.webapp.forms.autosuggest.AutoSuggestConfiguration;
import de.rittelfischer.webapp.forms.autosuggest.AutoSuggestTextField;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Konrad
 */
public class AutoSuggestPage extends HomePage{

    public AutoSuggestPage(){
        this.add(new AutoSuggestTextField("autosuggest",new IModel() {

            public Object getObject() {
                return "Test";
            }

            public void setObject(Object object) {
                
            }

            public void detach() {
                
            }
        },new AutoSuggestConfiguration()
                .withLocator("suggest")
                .withQueryUrl("/solr/searchneeds/")
                .onField("need")
                .withFadeTime(300)));

    }
}
