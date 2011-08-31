/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.dataservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name="Table_Location")
@NamedQueries({
    @NamedQuery(name=Location.LOAD_ALL_LOCATIONS, query=Location.LOAD_ALL_LOCATIONS_QUERY)
})
public class Location implements Serializable{
    
    public static final String LOAD_ALL_LOCATIONS ="LOAD_ALL_LOCATIONS";
    protected static final String LOAD_ALL_LOCATIONS_QUERY = "select l from Location l";
   
    @TableGenerator(name="LocGen")
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE,generator="LocGen")
    private Long id;
    
    private String name;
    /*
    @ManyToOne()
    @JoinColumn(name="id")
    private User owner;
   */
    private String description;
    private String address;
    
    @OneToMany(cascade=CascadeType.ALL)
    private List<Need> needs = new ArrayList<Need>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(List<Need> needs) {
        this.needs = needs;
    }

     
}
