/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.model;

import java.io.Serializable;

/**
 *
 * @author tiendv
 */
public class AuthorInstance implements Serializable {
    private int autoID;
    private String instanceName;
    

    public int getAutoID() {
        return autoID;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public void setAutoID(int autoID) {
        this.autoID = autoID;
    }

    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }

}
