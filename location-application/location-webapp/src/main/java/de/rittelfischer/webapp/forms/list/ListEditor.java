/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.forms.list;

import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.markup.html.form.IFormModelUpdateListener;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 *
 * @author Konrad
 */
public abstract class ListEditor<T> extends RepeatingView 
                             implements IFormModelUpdateListener
{
    List<T> items;
 
    public ListEditor(String id, IModel<List<T>> model)
    {
        super(id, model);
    }
 
    protected abstract void onPopulateItem(ListItem<T> item);
 
    public void addItem(T value)
    {
        items.add(value);
        ListItem<T> item = new ListItem<T>(newChildId(), 
                                              items.size() - 1);
        add(item);
        onPopulateItem(item);
    }
 
    protected void onBeforeRender()
    {
        if (!hasBeenRendered())
        {
            
            items = new ArrayList<T>((List<T>)this.getDefaultModelObject());
            for (int i = 0; i < items.size(); i++)
            {
                ListItem<T> li = new ListItem<T>(newChildId(), i);
                add(li);
                onPopulateItem(li);
            }
        }
        super.onBeforeRender();
    }
 
    public void updateModel()
    {
        setDefaultModelObject(items);
    }
}
