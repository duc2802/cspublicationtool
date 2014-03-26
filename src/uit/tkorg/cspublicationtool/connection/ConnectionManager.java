/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.connection;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import snaq.db.ConnectionPool;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dao
 */
public class ConnectionManager {
    private static ConnectionManager _instance;
    public static ConnectionManager getInstance()
    {
        if (_instance == null)
            _instance = new ConnectionManager();
        return _instance;
    }
    
    public ConnectionManager()
    {
        registerDriver();
        String poolName  = "ConnectionPool";
        int minPool = 2;
        int maxPool = 20;
        int maxSize = 20;
        int idleTimeout = 18000; //18 sec
        String url = "jdbc:mysql://localhost:3306/dblp_cspubguru";
        String userName = "root";
        String password = "admin";
        connectionPool = new ConnectionPool(poolName, minPool, maxPool, maxSize, idleTimeout, url, userName, password);
    }
    
    private ConnectionPool connectionPool;
    
    private void registerDriver()
    {
        try{
            Class c = Class.forName("com.mysql.jdbc.Driver");
            Driver dri = (Driver)c.newInstance();
            DriverManager.registerDriver(dri);
        }
        catch(Exception ex)
        {
             Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized Connection getConnection()
    {
        try
        {
            Connection connection = connectionPool.getConnection();
            return connection;
        }
        catch(Exception ex)
        {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
}
