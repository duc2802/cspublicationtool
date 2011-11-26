/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.File;
import java.util.Date;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author THANG
 */
public class CSPublicationParser {

    public CSPublicationParser(String uri) {
        try {
            long startTime = System.currentTimeMillis();
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
	    SAXParser parser = parserFactory.newSAXParser();
	    CSPublicationSAXEventHandler handler = new CSPublicationSAXEventHandler();  
            parser.getXMLReader().setFeature("http://xml.org/sax/features/validation", true);
            parser.parse(new File(uri), handler);     
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            
            System.out.println("Time run programe"+endTime);
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } 
    }    
}
