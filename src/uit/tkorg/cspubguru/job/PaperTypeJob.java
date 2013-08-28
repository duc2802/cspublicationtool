/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspubguru.job;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import uit.tkorg.cspubguru.bo.PaperTypeBO;


/**
 *
 * @author Dao
 */
public class PaperTypeJob implements Job{
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap data = context.getJobDetail().getJobDataMap();
        String PaperTypeName = (String)data.get("PaperTypeName");
        try {
            PaperTypeBO.insertPaperType(PaperTypeName);
        } catch (SQLException ex) {
            Logger.getLogger(PaperTypeJob.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
