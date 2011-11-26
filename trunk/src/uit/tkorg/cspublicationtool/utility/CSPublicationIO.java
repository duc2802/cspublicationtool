/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.utility;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author THANG
 */
public class CSPublicationIO {
    public void writeOut(String string){
        try{        
            FileWriter fstream = new FileWriter("out.txt",true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(string);            
            out.close();
        }catch (Exception e){
            System.err.println("Write To File Error: " + e.getMessage());
        }
    }    
}
