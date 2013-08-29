/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspubguru.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.tkorg.cspubguru.connection.ConnectionManager;
import uit.tkorg.cspublicationtool.entities.Publisher;

/**
 *
 * @author Dao
 */
public class PublisherBO {
    private static HashMap<Integer,Integer> publisherData = new HashMap<>();
    private static int id = 1;
    public static void insertPublisher(String publisherName) throws SQLException
    {
        Integer hashCode = publisherName.hashCode();
        if (!publisherData.containsKey(hashCode))
        {
            Publisher publisher = new Publisher();
            publisher.setIdPublisher(id);
            publisher.setNamePublisher(publisherName);
            publisherData.put(hashCode, id);
            id++;
            Connection connection = ConnectionManager.getInstance().getConnection();
            if (connection != null)
            {
                String sql = "INSERT into journal (idPublisher, namePublisher) VALUES" + "(?,?)"; 
                try
                {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, publisher.getIdPublisher());
                    preparedStatement.setString(2, publisher.getNamePublisher());
                    preparedStatement.executeUpdate();
                }
                catch(Exception ex)
                {
                    Logger.getLogger(PublisherBO.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally
                {
                    connection.close();
                }
            }
        }
    }
    public static Integer findPublisherId(String publisherName)
    {
        Integer hashCode = publisherName.hashCode();
        return publisherData.get(hashCode);
    }
}
