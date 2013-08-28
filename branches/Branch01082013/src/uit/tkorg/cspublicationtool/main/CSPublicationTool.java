/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.FileNotFoundException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Administrator
 */
public class CSPublicationTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, SchedulerException {     
        CSPublicationParser p = new CSPublicationParser("C://Data//dblp.xml") ; 
    }
}
