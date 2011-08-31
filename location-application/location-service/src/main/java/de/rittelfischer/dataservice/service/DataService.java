/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.dataservice.service;

import de.rittelfischer.dataservice.model.Location;
import de.rittelfischer.dataservice.model.User;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Konrad
 */
@LocalBean
@Stateless
public class DataService {

    @PersistenceContext(name="dataservicePU")
    EntityManager em;
    
    
    public void saveUser(User u){
        em.persist(u);
    }
    
    public void saveLocation(Location l){
        em.persist(l);
    }
    
    public List<Location> loadAllLocations(){
        return em.createNamedQuery(Location.LOAD_ALL_LOCATIONS,Location.class).getResultList();
    }
}
