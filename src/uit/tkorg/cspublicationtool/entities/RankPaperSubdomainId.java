package uit.tkorg.cspublicationtool.entities;
// Generated Nov 28, 2011 11:53:12 PM by Hibernate Tools 3.2.1.GA



/**
 * RankPaperSubdomainId generated by hbm2java
 */
public class RankPaperSubdomainId  implements java.io.Serializable {


     private int idPaper;
     private int idSubdomain;

    public RankPaperSubdomainId() {
    }

    public RankPaperSubdomainId(int idPaper, int idSubdomain) {
       this.idPaper = idPaper;
       this.idSubdomain = idSubdomain;
    }
   
    public int getIdPaper() {
        return this.idPaper;
    }
    
    public void setIdPaper(int idPaper) {
        this.idPaper = idPaper;
    }
    public int getIdSubdomain() {
        return this.idSubdomain;
    }
    
    public void setIdSubdomain(int idSubdomain) {
        this.idSubdomain = idSubdomain;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RankPaperSubdomainId) ) return false;
		 RankPaperSubdomainId castOther = ( RankPaperSubdomainId ) other; 
         
		 return (this.getIdPaper()==castOther.getIdPaper())
 && (this.getIdSubdomain()==castOther.getIdSubdomain());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPaper();
         result = 37 * result + this.getIdSubdomain();
         return result;
   }   


}


