package uit.tkorg.cspublicationtool.entities;
// Generated Dec 4, 2011 5:00:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Reviewer generated by hbm2java
 */
public class Reviewer  implements java.io.Serializable {


     private Integer idReviewer;
     private String reviewerName;
     private String image;
     private String emailAddress;
     private String website;
     private String organization;
     private Set paperReviewers = new HashSet(0);

    public Reviewer() {
    }

    public Reviewer(String reviewerName, String image, String emailAddress, String website, String organization, Set paperReviewers) {
       this.reviewerName = reviewerName;
       this.image = image;
       this.emailAddress = emailAddress;
       this.website = website;
       this.organization = organization;
       this.paperReviewers = paperReviewers;
    }
   
    public Integer getIdReviewer() {
        return this.idReviewer;
    }
    
    public void setIdReviewer(Integer idReviewer) {
        this.idReviewer = idReviewer;
    }
    public String getReviewerName() {
        return this.reviewerName;
    }
    
    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getWebsite() {
        return this.website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    public String getOrganization() {
        return this.organization;
    }
    
    public void setOrganization(String organization) {
        this.organization = organization;
    }
    public Set getPaperReviewers() {
        return this.paperReviewers;
    }
    
    public void setPaperReviewers(Set paperReviewers) {
        this.paperReviewers = paperReviewers;
    }




}


