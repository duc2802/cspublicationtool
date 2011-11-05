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
public class Org implements Serializable{
    private int idOrg;
    private String orgrName;
    private String continent;
    private String website;
    private int h_index;
    private String url;
    private Author author;

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public void setH_index(int h_index) {
        this.h_index = h_index;
    }

    public void setIdOrg(int idOrg) {
        this.idOrg = idOrg;
    }

    public void setOrgrName(String orgrName) {
        this.orgrName = orgrName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    
  

    public String getContinent() {
        return continent;
    }

    public int getH_index() {
        return h_index;
    }

    public int getIdOrg() {
        return idOrg;
    }

    public String getOrgrName() {
        return orgrName;
    }

    public String getUrl() {
        return url;
    }

    public String getWebsite() {
        return website;
    }
    
}
