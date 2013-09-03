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
import uit.tkorg.cspublicationtool.entities.Journal;
import uit.tkorg.cspublicationtool.entities.PaperType;

/**
 *
 * @author Dao
 */
public class JournalBO {
    private static HashMap<Integer,Integer> journalData = new HashMap<>();
    private static int id = 1;
    public static void insertJournal(String journalName) throws SQLException
    {
        Integer hashCode = journalName.hashCode();
        if (!journalData.containsKey(hashCode))
        {
            Journal journal = new Journal();
            journal.setIdJournal(id);
            journal.setJournalName(journalName);
            journalData.put(hashCode, id);
            id++;
            Connection connection = ConnectionManager.getInstance().getConnection();
            if (connection != null)
            {
                String sql = "INSERT into journal (idJournal, journalName) VALUES" + "(?,?)"; 
                try
                {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, journal.getIdJournal());
                    preparedStatement.setString(2, journal.getJournalName());
                    preparedStatement.executeUpdate();
                }
                catch(Exception ex)
                {
                    Logger.getLogger(JournalBO.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally
                {
                    connection.close();
                }
            }
        }
    }
    public static Integer findJournalId(String JournalName)
    {
        Integer hashCode = JournalName.hashCode();
        return journalData.get(hashCode);
    }
}
