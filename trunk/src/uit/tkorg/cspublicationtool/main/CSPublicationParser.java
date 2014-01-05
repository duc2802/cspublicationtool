/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import javax.xml.XMLConstants;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;


/**
 *
 * @author THANG
 */
public class CSPublicationParser {

    public CSPublicationParser(String uri) {
        try {
            long startTime = System.currentTimeMillis();
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
            parserFactory.setFeature("http://xml.org/sax/features/namespaces",false);
            parserFactory.setFeature("http://xml.org/sax/features/namespace-prefixes",true); 
	    SAXParser parser = parserFactory.newSAXParser();
	    CSPublicationSAXEventHandler handler = new CSPublicationSAXEventHandler();  
            parser.getXMLReader().setFeature("http://xml.org/sax/features/validation", true);  
            parser.parse(uri, handler);
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;            
            System.out.println("Time run programe"+endTime);            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } 
    }    
}
