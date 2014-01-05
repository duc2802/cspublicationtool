package uit.tkorg.cspublicationtool.main;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import uit.tkorg.cspublicationtool.bo.*;
import uit.tkorg.cspublicationtool.datasource.DataSourceManager;
import uit.tkorg.cspublicationtool.datasource.DataType;
import uit.tkorg.cspublicationtool.entities.*;
/**
 *
 * @author Duc Huynh
 */
public final class CSPublicationSAXEventHandler extends DefaultHandler {
      
    private String recordTag;  
    private String value;
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
    private StringBuffer str;
    private DataSourceManager dataSource = DataSourceManager.INSTANCE;

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
                if(this.str != null){
                    this.value = this.str.toString();
                }
                if (qName.equals(AUTHOR) || qName.equals(EDITOR)) {
                     try {                        
                        author = new Author();
                        author.setAuthorName(value);
                        Integer id = dataSource.getId(DataType.AUTHOR, value);
                        if (id == -1)
                        {
                            id = dataSource.addNewData(DataType.AUTHOR, value);
                            author.setIdAuthor(id);
                            authorBO.addNew(author);
                        }
                        else
                            author.setIdAuthor(id);
                         authors.add(author);
                         author=null;
                    return;
                    } catch (Exception ex) {
                        Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(qName.equals(TITLE)){
                    this.paper.setTitle(value);
                    return;
                }

                if (qName.equals(BOOKTITLE)) {
                    if (recordTag.equals(INPROCEEDINGS)) {
                        conference = new Conference();
                        conference.setConferenceName(value);
                        Integer id = dataSource.getId(DataType.CONFERENCE, value);
                        if (id == -1) {
                            id = dataSource.addNewData(DataType.CONFERENCE, value);
                            conference.setIdConference(id);
                            conferenceBO.addNew(conference);
                            this.paper.setConference(conference);
                            conference = null;
                            return;
                        } else {
                            this.paper.setTitle(value);
                            return;
                        }
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
                if(qName.equals(JOURNAL)){
                    try {
                        journal = new Journal();
                        journal.setJournalName(value);
                        Integer id = dataSource.getId(DataType.JOURNAL, value);
                        if (id == -1)
                        {
                            id = dataSource.addNewData(DataType.JOURNAL, value);
                            journal.setIdJournal(id);
                            journalBO.addNew(journal);
                        }
                        else
                            journal.setIdJournal(id);
                        this.paper.setJournal(journal);
                        journal =null;                        
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

                /*
                if(qName.equals(PUBLISHER)){
                     try {
                        String temp = value.replaceAll("'","");
                        publisher =publisherBO.checkExitPublisher(temp);
                        if (publisher ==null)
                        {
                            publisher = new Publisher();
                            publisher.setNamePublisher(value);
                            publisherBO.addNew(publisher);
                        }

                        this.paper.setPublisher(publisher);
                        publisher=null;                        
                        return;
                    } catch (Exception ex) {
                        Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                            
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
                    Integer id = dataSource.getId(DataType.PAPER, paper.getTitle());
                    if (id == -1)
                    {
                        id = dataSource.addNewData(DataType.PAPER, paper.getTitle());
                        paper.setIdPaper(id);
                        this.paperBO.addNew(paper);
                    }
                    
                    if(this.authors != null){
                        this.authors = null;
                    }
                    if(this.paper != null){
                        this.paper = null;
                    }
                    if(this.str != null){
                        this.str = null;
                    }
                    return;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
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
        if ((attributes.getLength()>0) && (attributes.getValue("key")!=null)) {
            recordTag = qName;
            this.paper = new Paper();            
            this.authors = new HashSet <Author>();       
            this.paper.setDblpKey(attributes.getValue("key"));            
            if(!recordTag.equals(WWW)&&!recordTag.equals(PROCEEDINGS))
            {
                /*
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
                */
            }
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
