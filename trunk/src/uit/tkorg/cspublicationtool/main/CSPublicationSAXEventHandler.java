/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import uit.tkorg.cspublicationtool.bo.*;
import uit.tkorg.cspublicationtool.entities.*;
/**
 *
 * @author THANG
 */
public final class CSPublicationSAXEventHandler extends DefaultHandler {
       
    private static final String ENCODING = "ISO-8859-1";
    private String recordTag;  
    private String value;
    private int count=0;
    private Paper paper;
    private PaperBO paperBO ;
    private Journal journal;
    private JournalBO journalBO;
    private AuthorBO authorBO;
    private Author author;
    private Publisher publisher;
    private PaperTypeBO paperTypeBO;
    private PaperType papertype;
    private PublisherBO publisherBO;
    private Conference conference;
    private ConferenceBO conferenceBO;
    private Set<Author> authors = null;
    private FileWriter fstream;
    private BufferedWriter out;
    private StringBuffer str;
    public CSPublicationSAXEventHandler() throws IOException, Exception{          
        super();
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String temptString = (new String(ch, start, length));  
        this.str.append(temptString);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        try {
            if(!recordTag.equals(WWW)&&!recordTag.equals(PROCEEDINGS)){
                super.endElement(uri, localName, qName);
                this.value = this.str.toString();
                if (qName.equals(AUTHOR) || qName.equals(EDITOR)) {
                     try {
                        //authorBO = new AuthorBO();
                        String temp = value.replaceAll("'","");
                        author = this.authorBO.checkExitAuthor(temp);
                        if (author ==null)
                        {
                            author = new Author();
                            author.setAuthorName(value);
                            authorBO.addNew(author);
                        }
                         authors.add(author);
                         author=null;
                         //authorBO=null;
                    return;
                    } catch (Exception ex) {
                        Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(qName.equals(TITLE)){
                    this.paper.setTitle(value);
                    return;
                }

                if(qName.equals(BOOKTITLE)){
                    if(recordTag.equals(INPROCEEDINGS)){
                        String temp = value.replaceAll("'","");
                        conference = conferenceBO.checkExitConference(temp);
                        if(conference ==null)
                        {
                            conference = new Conference();
                            conference.setConferenceName(value);
                            conferenceBO.addNew(conference);
                            this.paper.setConference(conference);
                            conference=null;
                            return;
                        }
                        
                    }else {
                        this.paper.setTitle(value);
                        return;
                    }
                }

                if(qName.equals(PAGES)){
                    this.paper.setPages(value);
                    return;
                }

                if(qName.equals(YEAR)){
                    this.paper.setYear(Integer.parseInt(value));
                    return;
                }

                if(qName.equals(ADDRESS)){
                    this.paper.setAdress(value);
                    return;
                }

                // Import Journal

                if(qName.equals(JOURNAL)){
                    try {
                        journal = this.journalBO.checkExitJournal(value);
                        if (journal ==null)
                        {
                            journal = new Journal();
                            journal.setJournalName(value);
                            journalBO.addNew(journal);
                        }

                        this.paper.setJournal(journal);
                        journal =null;
                        //journalBO=null;
                        return;
                    } catch (Exception ex) {
                        Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                     try {
                        publisher =publisherBO.checkExitPublisher(value);
                        if (publisher ==null)
                        {
                            publisher = new Publisher();
                            publisher.setNamePublisher(value);
                            publisherBO.addNew(publisher);
                        }

                        this.paper.setPublisher(publisher);
                        publisher=null;
                        //paperBO =null;
                        return;
                    } catch (Exception ex) {
                        Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

    //            if(qName.equals(NOTE)){
    //                this.paper.set(value);
    //                return;
    //            }

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

                    this.paper.setAuthors(authors);
                    this.paperBO.addNew(paper);
                    this.authors = null;
                    this.paper = null;
                    this.str = null;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        try {
            str = new StringBuffer();
            this.authorBO = AuthorBO.getAuthorBO();
            this.conferenceBO = ConferenceBO.getConferenceBO();
            this.journalBO = JournalBO.getJournalBO();
            this.publisherBO = PublisherBO.getPublisherBO();
            this.paperTypeBO = PaperTypeBO.getPaperTypeBO();
            this.paperBO = PaperBO.getPaperBO();
        } catch (Exception ex) {
            Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);    
        this.str = new StringBuffer();
        if (!qName.equals(WWW)&&!qName.equals(PROCEEDINGS)&&(attributes.getLength()>0) && (attributes.getValue("key")!=null)) {
            recordTag = qName;
            this.paper = new Paper();            
            this.authors = new HashSet <Author>();       
            this.paper.setDblpKey(attributes.getValue("key"));
            //this.paper.setMdate(attributes.getValue("mdate"));
            papertype = this.paperTypeBO.checkExitPaperType(qName);
            if (papertype ==null)
            {
                try {
                    papertype = new PaperType();
                    papertype.setNameType(qName);
                    paperTypeBO.addNew(papertype);
                } catch (Exception ex) {
                    Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            this.paper.setPaperType(papertype);
            papertype=null;
         
            return;
        }
    } 
    //article|inproceedings|proceedings|book|incollection|phdthesis|mastersthesis|www
    private static final String ARTICLE = "article";
    private static final String INPROCEEDINGS = "inproceedings";
    private static final String PROCEEDINGS = "proceedings";   
    private static final String BOOK = "book";
    private static final String INCOLECTION = "incollection";    
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
