/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.rittelfischer.dataservice.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Konrad
 */
@Entity
@Table(name="need")
public class Need implements Serializable{

    @TableGenerator(name="NeedGen")
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE,generator="NeedGen")
    private Long id;
    
    private String need;

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }
    
    
}
