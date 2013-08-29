/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspubguru.bo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.tkorg.cspubguru.connection.ConnectionManager;
import uit.tkorg.cspublicationtool.entities.Paper;

/**
 *
 * @author Dao
 */
public class PaperBO {
    private static int currIdPaper = 0;
    public static int getCurrIdPaper()
    {
        return currIdPaper;
    }
    public static void insertPaper(Paper paper,int idJournal,int idConference,int idMagazine,int idPublisher,int idPaperType) throws SQLException
    {
        currIdPaper++;
        Connection connection = ConnectionManager.getInstance().getConnection();
        if (connection != null)
        {
            String sql = "INSERT into paper (idPaper, doi,isbn,url,title,abstract,volume,"
                    + "pages,year,viewPublication,bibTex,endNote,idJournal,idConference,"
                    + "idMagazine,idPublisher,idPaperType,dblpKey,version,paperFile,adress,"
                    + "number,month,ee,crossref,series,school,chapter,cdrom,cite) VALUES" 
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
            try
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, currIdPaper);
                preparedStatement.setString(2, paper.getDoi());
                preparedStatement.setString(3, paper.getIsbn());
                preparedStatement.setString(4, paper.getUrl());
                preparedStatement.setString(5, paper.getTitle());
                preparedStatement.setString(6, paper.getAbstract_());
                preparedStatement.setString(7, paper.getVolume());
                preparedStatement.setString(8, paper.getPages());
                if (paper.getYear() != null)
                    preparedStatement.setInt(9, paper.getYear());
                else
                    preparedStatement.setNull(9, Types.INTEGER);
                preparedStatement.setString(10, paper.getViewPublication());
                preparedStatement.setString(11, paper.getBibTex());
                preparedStatement.setString(12, paper.getEndNote());
                if (idJournal > 0)
                    preparedStatement.setInt(13, idJournal);
                else
                    preparedStatement.setNull(13, Types.INTEGER);
                if (idConference > 0)
                    preparedStatement.setInt(14, idConference);
                else
                    preparedStatement.setNull(14, Types.INTEGER);
                if (idMagazine > 0)
                    preparedStatement.setInt(15, idMagazine);
                else
                    preparedStatement.setNull(15, Types.INTEGER);
                if (idPublisher > 0)
                    preparedStatement.setInt(16, idPublisher);
                else
                    preparedStatement.setNull(16, Types.INTEGER);
                preparedStatement.setInt(17, idPaperType);
                preparedStatement.setString(18, paper.getDblpKey());
                if (paper.getVersion() != null)
                    preparedStatement.setInt(19, paper.getVersion());
                else
                    preparedStatement.setNull(19, Types.INTEGER);
                preparedStatement.setString(20, paper.getPaperFile());
                preparedStatement.setString(21, paper.getAdress());
                preparedStatement.setString(22, paper.getNumber());
                preparedStatement.setString(23, paper.getMonth());
                preparedStatement.setString(24, paper.getEe());
                preparedStatement.setString(25, paper.getCrossref());
                preparedStatement.setString(26, paper.getSeries());
                preparedStatement.setString(27, paper.getSchool());
                preparedStatement.setString(28, paper.getChapter());
                preparedStatement.setString(29, paper.getCdrom());
                preparedStatement.setString(30, paper.getCite());
                preparedStatement.executeUpdate();
            }
            catch(Exception ex)
            {
                Logger.getLogger(PaperBO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                connection.close();
            }
        }
    }
}

