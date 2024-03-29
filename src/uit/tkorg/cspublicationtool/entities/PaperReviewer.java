package uit.tkorg.cspublicationtool.entities;
// Generated Dec 4, 2011 5:00:43 PM by Hibernate Tools 3.2.1.GA



/**
 * PaperReviewer generated by hbm2java
 */
public class PaperReviewer  implements java.io.Serializable {


     private PaperReviewerId id;
     private Reviewer reviewer;
     private Paper paper;
     private Integer rating;
     private String content;

    public PaperReviewer() {
    }

	
    public PaperReviewer(PaperReviewerId id, Reviewer reviewer, Paper paper) {
        this.id = id;
        this.reviewer = reviewer;
        this.paper = paper;
    }
    public PaperReviewer(PaperReviewerId id, Reviewer reviewer, Paper paper, Integer rating, String content) {
       this.id = id;
       this.reviewer = reviewer;
       this.paper = paper;
       this.rating = rating;
       this.content = content;
    }
   
    public PaperReviewerId getId() {
        return this.id;
    }
    
    public void setId(PaperReviewerId id) {
        this.id = id;
    }
    public Reviewer getReviewer() {
        return this.reviewer;
    }
    
    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }
    public Paper getPaper() {
        return this.paper;
    }
    
    public void setPaper(Paper paper) {
        this.paper = paper;
    }
    public Integer getRating() {
        return this.rating;
    }
    
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }




}


