/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.tkorg.cspublicationtool.data.ManagerBase;
import uit.tkorg.cspublicationtool.entities.*;

/**
 *
 * @author tiendv
 */
public class ConferenceBO extends ManagerBase<Conference> {

   
    
     private static ConferenceBO conferenceBO = null;
     public ConferenceBO() throws Exception {
     }
   
     public static ConferenceBO getConferenceBO() throws Exception{
         if (conferenceBO == null ){
              conferenceBO = new ConferenceBO();
          }
         return conferenceBO;
    }
     
     
      public Conference checkExitConference(String nameConference)
    {
        
       String query = "conferenceName='" + nameConference +"'";
       List<Conference> list;
        try {
            list = getBySQLQuery(query, null, 0);
            if(list.isEmpty())
                return null;
            else
                return list.get(0);         
        } catch (Exception ex) {
            Logger.getLogger(Conference.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
