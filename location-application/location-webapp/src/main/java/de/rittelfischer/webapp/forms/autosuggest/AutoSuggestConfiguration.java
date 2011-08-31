/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.forms.autosuggest;

/**
 *
 * The AutoSuggestConfiguration is used to configure the
 * AutoSuggestTextField.
 * 
 * @author Konrad
 */
public class AutoSuggestConfiguration {
    
    protected String locator;
    private String queryUrl;
    private int fadeTime = 10000;
    private int minChars = 2;
    private String requestMethod = "GET";
    private String field = "*";
    
   /**
     * Sets the locator for the TextField, so that the AJAX-Response knows, which
     * TextField to update.
     * @param locator
     * @return 
     */ 
    public AutoSuggestConfiguration withLocator(String locator){
        this.locator = locator;
        return this;
    }
    /**
     * The URL, the AJAX-Requests calls to obtain suggestions.
     * @param queryUrl
     * @return 
     */
    public AutoSuggestConfiguration withQueryUrl(String queryUrl){
        this.queryUrl = queryUrl;
        return this;
    }
    public AutoSuggestConfiguration withFadeTime(int fadeTime){
        this.fadeTime = fadeTime;
        return this;
    }
    public AutoSuggestConfiguration withMinChars(int minChars){
        this.minChars = minChars;
        return this;
    }
    /**
     * The RequestMethod the AJAX-Call shall have. "GET" or "POST"
     * @param requestMethod
     * @return 
     */
    public AutoSuggestConfiguration withRequestMethod(String requestMethod){
        this.requestMethod = requestMethod;
        return this;
    }
    /**
     * Which Solr-Field shall be queried.
     * @param field
     * @return 
     */
    public AutoSuggestConfiguration onField(String field){
        this.field = field;
        return this;
    }
    
    /**
     * Returns the Configuration as a JS String which configures the JS-Client.
     * @return 
     */
    public String toJSConfigString(){
       return 
        "$(document).ready(function() {\n"
            +"$.fn.autosugguest({\n"
                +"className: '"+locator+"',\n"
                +"methodType: '"+requestMethod+"',\n"
                +"dataFile: '"+queryUrl+"',\n"
                +"minChars: "+minChars+",\n"
                +"fadeTime: "+fadeTime+",\n"
                +"field:'"+field+"'\n"
            +"});\n"
        +"});\n";
    }

}
