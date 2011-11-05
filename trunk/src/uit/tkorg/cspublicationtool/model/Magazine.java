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
public class Magazine implements Serializable {
    
    private int idMagazine;
    private String magazineName;
    private String website;
    private String organzation;
    private int yearStart;
    private int yearEnd;
    private String url; 

    public int getIdMagazine() {
        return idMagazine;
    }

    public String getMagazineName() {
        return magazineName;
    }

    public String getOrganzation() {
        return organzation;
    }

    public String getUrl() {
        return url;
    }

    public String getWebsite() {
        return website;
    }

    public int getYearEnd() {
        return yearEnd;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setIdMagazine(int idMagazine) {
        this.idMagazine = idMagazine;
    }

    public void setMagazineName(String magazineName) {
        this.magazineName = magazineName;
    }

    public void setOrganzation(String organzation) {
        this.organzation = organzation;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }
 
}
