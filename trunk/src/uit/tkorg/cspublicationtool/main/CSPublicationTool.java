/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import uit.tkorg.cspublicationtool.datasource.DataSourceManager;
import uit.tkorg.cspublicationtool.datasource.DataType;

/**
 *
 * @author Administrator
 */
public class CSPublicationTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {      
        
        DataSourceManager.INSTANCE.loadDataFromSource(DataType.AUTHOR, "C:/PubguruExport/author.txt");
        DataSourceManager.INSTANCE.loadDataFromSource(DataType.PAPER, "C:/PubguruExport/paper.txt");
        DataSourceManager.INSTANCE.loadDataFromSource(DataType.CONFERENCE, "C:/PubguruExport/conference.txt");
        DataSourceManager.INSTANCE.loadDataFromSource(DataType.JOURNAL, "C:/PubguruExport/journal.txt");
        
        CSPublicationParser p = new CSPublicationParser("C:/DBLP/dblp.xml"); 
    }
}
