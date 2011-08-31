/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.webapp.forms.list;

import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.AbstractReadOnlyModel;

/**
 *
 * @author Konrad
 */
public class ListItem<T> extends Item<T>
{
   public ListItem(String id, int index)
   {
      super(id, index);
      setModel(new ListItemModel());
   }
 
   private class ListItemModel extends AbstractReadOnlyModel<T>
   {
      public T getObject()
      {
         return ((ListEditor<T>)ListItem.this.getParent())
                  .items.get(getIndex());
      }
   }
}
