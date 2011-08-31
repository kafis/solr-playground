/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.forms.autosuggest;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Konrad
 */
public class AutoSuggestTextField<T> extends Panel {
   
    public AutoSuggestTextField(String id,IModel<T> model, AutoSuggestConfiguration config){
        super(id);
        this.add(new Label("config",config.toJSConfigString()).setEscapeModelStrings(false));
        this.add(
                new WebMarkupContainer("suggestionWrapper")
                    .add(new TextField("suggestionField",model)
                            .add(new AttributeModifier("id",config.locator)))
                    .add(new AttributeModifier("class", config.locator))  
                    
                );
    }
    

}
