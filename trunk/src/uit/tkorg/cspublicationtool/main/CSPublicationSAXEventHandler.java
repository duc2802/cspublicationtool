/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import uit.tkorg.cspublicationtool.saxparser.model.Author;
import uit.tkorg.cspublicationtool.saxparser.model.Paper;
/**
 *
 * @author THANG
 */
public class CSPublicationSAXEventHandler extends DefaultHandler{
       
    private String recordTag;  
    private String value;
    private int count=0;
    private Paper paper;
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
            return;
        }
        
        if(qName.equals(BOOKTITLE)){
            this.paper.setBooktitle(value);
            return;
        }
        
        if(qName.equals(PAGES)){
            this.paper.setPapges(value);
            return;
        }    
        
        if(qName.equals(YEAR)){
            this.paper.setYear(value);
            return;
        }
        
        if(qName.equals(ADDRESS)){
            this.paper.setAddress(value);
            return;
        }
        
        if(qName.equals(JOURNAL)){
            this.paper.setJournal(value);
            return;
        }
        
        if(qName.equals(VOLUME)){
            this.paper.setVolume(value);
            return;
        }
        
        if(qName.equals(NUMBER)){
            this.paper.setNumber(value);
            return;
        }
        
        if(qName.equals(MONTH)){
            this.paper.setMonth(value);
            return;
        }
        
        if(qName.equals(URL)){
            this.paper.setUrl(value);
            return;
        }
        
        if(qName.equals(EE)){
            this.paper.setEe(value);
            return;
        }
        
        if(qName.equals(CDROM)){
            this.paper.setCdrom(value);
            return;
        }
        
        if(qName.equals(CITE)){
            this.paper.setCite(value);
            return;
        }
        
        if(qName.equals(PUBLISHER)){
            this.paper.setPublisher(value);
            return;
        }
        
        if(qName.equals(NOTE)){
            this.paper.setNote(value);
            return;
        }
        
        if(qName.equals(CROSSREF)){
            this.paper.setCrossref(value);
            return;
        }
        
        if(qName.equals(ISBN)){
            this.paper.setIsbn(value);
            return;
        }
        
        if(qName.equals(SERIES)){
            this.paper.setSeries(value);
            return;
        }
        
        if(qName.equals(SCHOOL)){
            this.paper.setSchool(value);
            return;
        }
        
        if(qName.equals(CHAPTER)){
            this.paper.setChapter(value);
            return;
        }
        
        if (qName.equals(recordTag)) {
            this.paper.setAuthors(this.authors);
            this.authors = null;
            count++;
            //write to file.
            System.out.println(this.paper.getTitle());
            for (int i = 0; i < this.paper.getAuthors().size(); i++) {
               System.out.println(this.paper.getAuthors().get(i).getName());
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++");
            System.out.println(this.paper.generateImportAuthorSQLProcedure());
            //
            this.paper = null;            
        }       
    }
   
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);            
        if ((attributes.getLength()>0) && (attributes.getValue("key")!=null)) {               
            recordTag = qName;
            this.paper = new Paper();            
            this.authors = new ArrayList<Author>();       
            this.paper.setKey(attributes.getValue("key"));
            this.paper.setMdate(attributes.getValue("mdate"));
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
    private static final String WWW = "www";
    private static final String PHDTHESIS = "phdthesis";
    private static final String MASTERSTHESIS = "mastersthesis";
    
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
    private static final String MONTH = "month";
    private static final String URL = "url";
    private static final String EE = "ee";
    private static final String CDROM = "cdrom";
    private static final String CITE = "cite";
    private static final String PUBLISHER = "publisher";
    private static final String NOTE = "note";
    private static final String CROSSREF = "crossref";
    private static final String ISBN = "isbn";
    private static final String SERIES = "series";
    private static final String SCHOOL = "school";
    private static final String CHAPTER = "chapter";
}
