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
public class PaperTypeBO extends ManagerBase<PaperType> {
    private static PaperTypeBO paperTypeBO = null;
    
    public PaperTypeBO() throws Exception {
    }
    
    public static PaperTypeBO getPaperTypeBO() throws Exception{
         if (paperTypeBO == null ){
              paperTypeBO = new PaperTypeBO();
          }
         return paperTypeBO;
    }
    
      public PaperType checkExitPaperType(String namePaperType)
    {
        
       String query = "nameType='" + namePaperType +"'";
       List<PaperType> list;
        try {
            list = getBySQLQuery(query, null, 0);
            if(list.isEmpty())
                return null;
            else
                return list.get(0);         
        } catch (Exception ex) {
            Logger.getLogger(PaperTypeBO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
