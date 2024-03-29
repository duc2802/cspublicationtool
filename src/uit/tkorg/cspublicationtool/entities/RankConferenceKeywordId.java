package uit.tkorg.cspublicationtool.entities;
// Generated Dec 4, 2011 5:00:43 PM by Hibernate Tools 3.2.1.GA



/**
 * RankConferenceKeywordId generated by hbm2java
 */
public class RankConferenceKeywordId  implements java.io.Serializable {


     private int idConference;
     private int idKeyword;

    public RankConferenceKeywordId() {
    }

    public RankConferenceKeywordId(int idConference, int idKeyword) {
       this.idConference = idConference;
       this.idKeyword = idKeyword;
    }
   
    public int getIdConference() {
        return this.idConference;
    }
    
    public void setIdConference(int idConference) {
        this.idConference = idConference;
    }
    public int getIdKeyword() {
        return this.idKeyword;
    }
    
    public void setIdKeyword(int idKeyword) {
        this.idKeyword = idKeyword;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof RankConferenceKeywordId) ) return false;
		 RankConferenceKeywordId castOther = ( RankConferenceKeywordId ) other; 
         
		 return (this.getIdConference()==castOther.getIdConference())
 && (this.getIdKeyword()==castOther.getIdKeyword());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdConference();
         result = 37 * result + this.getIdKeyword();
         return result;
   }   


}


