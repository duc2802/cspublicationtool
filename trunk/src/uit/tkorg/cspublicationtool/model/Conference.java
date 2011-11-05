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
public class Conference implements Serializable {
    
    private int idConference;
    private String conferenceName;
    private String website;
    private String organzation;
    private String organzationLocation;
    private String duration;
    private int yearStart;
    private int yearEnd;
    private String url; 

    public String getConferenceName() {
        return conferenceName;
    }

    public String getDuration() {
        return duration;
    }

    public int getIdConference() {
        return idConference;
    }

    public String getOrganzation() {
        return organzation;
    }

    public String getOrganzationLocation() {
        return organzationLocation;
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

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }

    public void setOrganzation(String organzation) {
        this.organzation = organzation;
    }

    public void setOrganzationLocation(String organzationLocation) {
        this.organzationLocation = organzationLocation;
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
