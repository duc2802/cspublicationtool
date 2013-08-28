/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspubguru.scheduler;

import java.sql.Connection;
import java.sql.DriverManager;
import org.gjt.mm.mysql.Driver;
import snaq.db.ConnectionPool;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import uit.tkorg.cspubguru.connection.ConnectionManager;

/**
 *
 * @author Dao
 */
public class SchedulerManager {
    private static SchedulerManager _instance;
    public static SchedulerManager getInstance()
    {
        if (_instance == null)
            _instance = new SchedulerManager();
        return _instance;
    }
    
    public SchedulerManager()
    {
        try{
            SchedulerFactory _schedulerFactory = new StdSchedulerFactory("uit/tkorg/cspubguru/scheduler/SaveData.properties");
            _scheduler = _schedulerFactory.getScheduler();
            _scheduler.start();
        }
        catch(Exception ex)
        {
            Logger.getLogger(SchedulerManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private Scheduler _scheduler;
    
    public Scheduler getScheduler()
    {
        return _scheduler;
    }
}
