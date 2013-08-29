/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.FileNotFoundException;

/**
 *
 * @author Administrator
 */
public class CSPublicationTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {     
//        String[] listPath = new String[]
//        {
//          "C://Data//dblp01.xml",
//          "C://Data//dblp02.xml",
//          "C://Data//dblp03.xml",
//          "C://Data//dblp04.xml",
//          "C://Data//dblp05.xml",
//          "C://Data//dblp06.xml",
//          "C://Data//dblp07.xml",
//          "C://Data//dblp08.xml",
//          "C://Data//dblp09.xml",
//          "C://Data//dblp10.xml",
//        };
        String[] listPath = new String[]
        {
            "C://Data//temp.xml",
            "C://Data//temp2.xml",
        };
        CSPublicationParser p = new CSPublicationParser(listPath) ; 
    }
}
