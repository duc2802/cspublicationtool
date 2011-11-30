/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.bo;

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
    
}
