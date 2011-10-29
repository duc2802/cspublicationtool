/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.awt.print.Paper;
import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import uit.tkorg.cspublicationtool.saxparser.model.Author;
/**
 *
 * @author THANG
 */
public class CSPublicationSAXEventHandler extends DefaultHandler{
       
    private String recordTag;  
    private String value;
    private uit.tkorg.cspublicationtool.saxparser.model.Paper paper;
    private ArrayList<Author> authors;
    
    public CSPublicationSAXEventHandler(){      
        
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = (new String(ch, start, length)).trim();
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals(AUTHOR) || qName.equals(EDITOR)) {
            Author author = new Author();
            author.setName(value);
            authors.add(author);
            return;
        }        
        if(qName.equals(TITLE)){
            this.paper.setTitle(value);
        }
        
        if (qName.equals(recordTag)) {
            this.paper.setAuthors(this.authors);
            this.authors = null;
            //write to file.
            System.out.println(this.paper.getTitle());
            for (int i = 0; i < this.paper.getAuthors().size(); i++) {
               System.out.println(this.paper.getAuthors().get(i).getName());
            }
            System.out.println("=============================================");
            //
            this.paper = null;            
        }        
    }
   
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);            
        if ((attributes.getLength()>0) && (attributes.getValue("key")!=null)) {               
            recordTag = qName;
            this.paper = new uit.tkorg.cspublicationtool.saxparser.model.Paper();
            this.authors = new ArrayList<Author>();            
            return;
        }
    } 
    
    //article|inproceedings|proceedings|book|incollection|phdthesis|mastersthesis|www
    private static final String ARTICLE = "article";
    private static final String INPROCEEDINGS = "inproceedings";
    private static final String PROCEEDINGS = "proceedings";   
    private static final String BOOK = "book";
    private static final String INCOLECTION = "incollection";
    private static final String MASTERTHESIS = "mastersthesis";
    
    //"author|editor|title|booktitle|pages|year|address|journal|volume|number|month|url|ee|cdrom|cite|publisher|note|crossref|isbn|series|school|chapter"
    private static final String AUTHOR = "author";
    private static final String EDITOR = "editor";
    private static final String TITLE = "title";
    private static final String BOOKTITLE = "booktitle";
    private static final String PAGES = "pages";
    private static final String YEAR = "year";
    private static final String ADDRESS = "address";
    private static final String JOURNAL = "journal";
    private static final String VOLUME = "volume";
    private static final String NUMBER = "number";
    
    
}
