/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.bo;

import java.util.List;
import uit.tkorg.cspublicationtool.data.ManagerBase;
import uit.tkorg.cspublicationtool.entities.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tiendv
 */
public class AuthorBO extends ManagerBase<Author> {

    public AuthorBO() throws Exception {
    }
    
      public Author checkExitAuthor(String nameAuthor)
    {
        
       String query = "authorName='" + nameAuthor +"'";
       List<Author> list;
        try {
            list = getBySQLQuery(query, null, 0);
            if(list.isEmpty())
                return null;
            else
                return list.get(0);         
        } catch (Exception ex) {
            Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
