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
public class JournalBO extends ManagerBase<Journal> {

    public JournalBO() throws Exception {
    }
    
     public Journal checkExitJournal(String namejournal)
    {
        
       String query = "journalName='" + namejournal +"'";
       List<Journal> list;
        try {
            list = getBySQLQuery(query, null, 0);
            if(list.isEmpty())
                return null;
            else
                return list.get(0);
                     
        } catch (Exception ex) {
            Logger.getLogger(JournalBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
