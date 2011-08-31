/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 *
 * @author Konrad
 */
public class HomePage extends WebPage{

    public HomePage(){
        super();
        this.add(new Link("addLocation") {

            @Override
            public void onClick() {
                setResponsePage(InsertDataPage.class);
            }
        });
        this.add(new Link("showLocation") {

            @Override
            public void onClick() {
                setResponsePage(ShowAllLocationsPage.class);
            }
        });
        this.add(new Link("autoSuggest") {

            @Override
            public void onClick() {
                setResponsePage(AutoSuggestPage.class);
            }
        });
    }
}
