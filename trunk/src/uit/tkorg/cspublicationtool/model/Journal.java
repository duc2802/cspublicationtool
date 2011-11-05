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
public class Journal implements Serializable{
    
    private int idJournal;
    private String journalName;
    private String website;
    private String organzation;
    private int yearStart;
    private int yearEnd;
    private String url;

    public void setIdJournal(int idJournal) {
        this.idJournal = idJournal;
    }

    public void setJournalName(String journalName) {
        this.journalName = journalName;
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

    public int getIdJournal() {
        return idJournal;
    }

    public String getJournalName() {
        return journalName;
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
}
