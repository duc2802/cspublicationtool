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
public class PaperType implements Serializable {
    private int idPaperType;
    private String nameType;
    
    public int getIdPaperType() {
        return idPaperType;
    }
    public String getNameType() {
        return nameType;
    }

    public void setIdPaperType(int idPaperType) {
        this.idPaperType = idPaperType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
  
    
}
