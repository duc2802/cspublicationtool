package uit.tkorg.cspublicationtool.entities;
// Generated Dec 4, 2011 5:00:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * PaperType generated by hbm2java
 */
public class PaperType  implements java.io.Serializable {


     private Integer idPaperType;
     private String nameType;
     private Set papers = new HashSet(0);

    public PaperType() {
    }

    public PaperType(String nameType, Set papers) {
       this.nameType = nameType;
       this.papers = papers;
    }
   
    public Integer getIdPaperType() {
        return this.idPaperType;
    }
    
    public void setIdPaperType(Integer idPaperType) {
        this.idPaperType = idPaperType;
    }
    public String getNameType() {
        return this.nameType;
    }
    
    public void setNameType(String nameType) {
        this.nameType = nameType;
    }
    public Set getPapers() {
        return this.papers;
    }
    
    public void setPapers(Set papers) {
        this.papers = papers;
    }




}


