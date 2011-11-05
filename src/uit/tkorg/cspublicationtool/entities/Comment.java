package uit.tkorg.cspublicationtool.entities;
// Generated Nov 5, 2011 11:29:49 PM by Hibernate Tools 3.2.1.GA



/**
 * Comment generated by hbm2java
 */
public class Comment  implements java.io.Serializable {


     private Integer idComment;
     private Paper paper;
     private Integer rating;
     private String content;

    public Comment() {
    }

	
    public Comment(Paper paper) {
        this.paper = paper;
    }
    public Comment(Paper paper, Integer rating, String content) {
       this.paper = paper;
       this.rating = rating;
       this.content = content;
    }
   
    public Integer getIdComment() {
        return this.idComment;
    }
    
    public void setIdComment(Integer idComment) {
        this.idComment = idComment;
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


