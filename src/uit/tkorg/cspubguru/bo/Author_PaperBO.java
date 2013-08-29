/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspubguru.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.tkorg.cspubguru.connection.ConnectionManager;

/**
 *
 * @author Dao
 */
public class Author_PaperBO {
    public static void insertAuthorPaper(int idAuthor,int idPaper) throws SQLException
    {
        Connection connection = ConnectionManager.getInstance().getConnection();
        if (connection != null)
        {
            String sql = "INSERT into author_paper (idAuthor, idPaper) VALUES" + "(?,?)"; 
            try
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, idAuthor);
                preparedStatement.setInt(2, idPaper);
                preparedStatement.executeUpdate();
            }
            catch(Exception ex)
            {
                Logger.getLogger(Author_PaperBO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                connection.close();
            }
        }
    }
}
