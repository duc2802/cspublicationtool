package uit.tkorg.cspublicationtool.main;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import uit.tkorg.cspubguru.bo.*;
import uit.tkorg.cspublicationtool.entities.*;
/**
 *
 * @author Duc Huynh
 */
public final class CSPublicationSAXEventHandler extends DefaultHandler {
      
    private String recordTag;  
    private String value;    
    private StringBuffer str;
    
    private Paper paper;
    private List<Integer> listIdAuthor;
    private int idConference;
    private int idJournal;
    private int idPulisher;
    private int idMagazine;
    private int idPaperType;

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
                        String temp = value.replaceAll("'","");
                        AuthorBO.insertAuthor(temp);
                        listIdAuthor.add(AuthorBO.findAuthorId(temp));
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
                        ConferenceBO.insertConference(temp);
                        idConference = ConferenceBO.findConferenceId(temp);
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
                if(qName.equals(JOURNAL)){
                    try {
                        JournalBO.insertJournal(value);
                        idJournal = JournalBO.findJournalId(value);
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
                        PublisherBO.insertPublisher(value);
                        idPulisher = PublisherBO.findPublisherId(value);
                    } catch (Exception ex) {
                        Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
                    PaperBO.insertPaper(paper, idJournal, idConference, idMagazine, idPulisher, idPaperType);
                    for (Integer idAuthor : listIdAuthor)
                    {
                        Author_PaperBO.insertAuthorPaper(idAuthor, PaperBO.getCurrIdPaper());
                    }
                    paper = new Paper();
                    idJournal = 0;
                    idConference = 0;
                    idMagazine = 0;
                    idPulisher = 0;
                    idPaperType = 0;
                    listIdAuthor.clear();
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
        str = new StringBuffer();
        listIdAuthor = new ArrayList<>();
        paper = new Paper();
    }
   
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);  
        this.str = new StringBuffer();
        if ((attributes.getLength()>0) && (attributes.getValue("key")!=null)) {
            counter++;
            System.out.println("Counting " + counter);
            recordTag = qName;
            if(!recordTag.equals(WWW)&&!recordTag.equals(PROCEEDINGS))
            {
                try {
                    PaperTypeBO.insertPaperType(qName);
                    idPaperType = PaperTypeBO.findPaperTypeId(qName);
                } catch (Exception ex) {
                    Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
    
    public int counter = 0;
}
