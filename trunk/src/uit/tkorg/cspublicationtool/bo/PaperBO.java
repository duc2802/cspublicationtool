/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.bo;

import uit.tkorg.cspublicationtool.data.ManagerBase;
import uit.tkorg.cspublicationtool.entities.Paper;

/**
 *
 * @author tiendv
 */
public class PaperBO extends ManagerBase <Paper> {
    
    private static PaperBO japerBO = null;
    public PaperBO() throws Exception {
    }
    
     public static PaperBO getPaperBO() throws Exception{
         if (japerBO == null ){
              japerBO = new PaperBO();
          }
         return japerBO;
    }
    }
