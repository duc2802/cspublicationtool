/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.quartz.Scheduler;
import org.xml.sax.InputSource;


/**
 *
 * @author THANG
 */
public class CSPublicationParser {
    public CSPublicationParser(String uri) throws FileNotFoundException {
         PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        try {
           
            long startTime = System.currentTimeMillis();
            System.out.println("Time Start"+startTime);
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setFeature("http://xml.org/sax/features/namespaces",false);
            parserFactory.setFeature("http://xml.org/sax/features/namespace-prefixes",true); 
	    SAXParser parser = parserFactory.newSAXParser();
	    CSPublicationSAXEventHandler handler = new CSPublicationSAXEventHandler();  
            parser.getXMLReader().setFeature("http://xml.org/sax/features/validation", true);  
            parser.parse(uri, handler);
            System.setOut(out);
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;      
            System.out.println("Time End"+endTime); 
            System.out.println("Time run programe"+totalTime);
        } catch (Exception e) {
            System.setOut(out);
            System.out.print(e.getMessage());
        } 
    }    
}
