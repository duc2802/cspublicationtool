/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspubguru.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.tkorg.cspubguru.connection.ConnectionManager;
import uit.tkorg.cspublicationtool.entities.Author;

/**
 *
 * @author Dao
 */
public class AuthorBO {
    private static HashMap<Integer,Integer> authorData = new HashMap<>();
    private static int id = 1;
    public static void insertAuthor(String authorName) throws SQLException
    {
        Integer hashCode = authorName.hashCode();
        if (!authorData.containsKey(hashCode))
        {
            Author author = new Author();
            author.setAuthorName(authorName);
            author.setIdAuthor(id);
            authorData.put(hashCode, id);
            id++;
            Connection connection = ConnectionManager.getInstance().getConnection();
            if (connection != null)
            {
                String sql = "INSERT into author (idAuthor, authorName) VALUES" + "(?,?)"; 
                try
                {
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setInt(1, author.getIdAuthor());
                    preparedStatement.setString(2, author.getAuthorName());
                    
                    preparedStatement.executeUpdate();
                }
                catch(Exception ex)
                {
                    Logger.getLogger(AuthorBO.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally
                {
                    connection.close();
                }
            }
        }
    }
    public static Integer findAuthorId(String authorName)
    {
        Integer hashCode = authorName.hashCode();
        return authorData.get(hashCode);
    }
}
