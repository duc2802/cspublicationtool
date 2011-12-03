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
import java.util.Date;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/**
 *
 * @author THANG
 */
public class CSPublicationParser {

    public CSPublicationParser(String uri) {
        try {
            File file = new File(uri);
            InputStream inputStream= new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream);
            InputSource is = new InputSource(reader);
            is.setEncoding("ISO-8859-1");
            long startTime = System.currentTimeMillis();
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            parserFactory.setFeature("http://xml.org/sax/features/namespaces",false);
            parserFactory.setFeature("http://xml.org/sax/features/namespace-prefixes",true); 
	    SAXParser parser = parserFactory.newSAXParser();
	    CSPublicationSAXEventHandler handler = new CSPublicationSAXEventHandler();  
            XMLReader xmlReader = parser.getXMLReader();
            xmlReader.setContentHandler(handler);
            xmlReader.parse(is);
            //parser.getXMLReader().setFeature("http://xml.org/sax/features/validation", true);            
            //parser.parse(is, handler);     
            long endTime   = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            
            System.out.println("Time run programe"+endTime);
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        } 
    }    
}
