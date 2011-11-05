/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.model;

import java.io.Serializable;

/**
 *
 * @author tiendv
 */
public class Publisher implements Serializable{
    
    private int idPublisher;
    private String namePublisher;
    public int getIdPublisher() {
        return idPublisher;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }
     
    
}
