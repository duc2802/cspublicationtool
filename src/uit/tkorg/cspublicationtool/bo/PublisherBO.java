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
public class PublisherBO extends ManagerBase<Publisher> {
    
    private static PublisherBO publisherBO = null;
    public PublisherBO() throws Exception {
    }
    public static PublisherBO getPublisherBO() throws Exception{
         if (publisherBO == null ){
              publisherBO = new PublisherBO();
          }
         return publisherBO;
    }
    
    public Publisher checkExitPublisher(String namePublisher)
    {
        
       String query = "namePublisher='" + namePublisher +"'";
       List<Publisher> list;
        try {
            list = getBySQLQuery(query, null, 0);
            if(list.isEmpty())
                return null;
            else
                return list.get(0);
                     
        } catch (Exception ex) {
            Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
