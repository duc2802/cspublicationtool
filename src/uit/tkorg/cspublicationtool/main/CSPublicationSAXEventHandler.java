/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.*; 
import uit.tkorg.cspublicationtool.saxparser.model.Author;
import uit.tkorg.cspublicationtool.saxparser.model.Paper;
/**
 *
 * @author THANG
 */
public final class CSPublicationSAXEventHandler extends DefaultHandler{
       
    private String recordTag;  
    private String value;
    private int count=0;
    private Paper paper;
    private ArrayList<Author> authors = null;
    private FileWriter fstream;
    private BufferedWriter out;
    
    public CSPublicationSAXEventHandler() throws IOException{          
        InputStream in = getClass().getResourceAsStream("/uit/tkorg/cspublicationtool/database/DB_SQLScript_Creation_1112011.sql");
        Reader fr = new InputStreamReader(in, "utf-8");
        StringBuilder buffer = new StringBuilder();
        int ch;
        while ((ch = in.read()) > -1) {
                buffer.append((char)ch);
        }
        in.close();
        
        fstream = new FileWriter("out.sql",true);
        out = new BufferedWriter(fstream);
        out.write(buffer.toString());        
        out.write("\n");
        out.write(this.generateImportAuthorSQLProcedure());
        out.write("\n");
        out.write(this.generateImportConferenceSQLProcedure());
        out.write("\n");
        out.write(this.generateImportJournalSQLProcedure());
        out.write("\n");
        out.write(this.generateImportMagazineSQLProcedure());
        out.write("\n");
        out.write(this.generateImportPaperTypeSQLProcedure());
        out.write("\n");
        out.write(this.generateImportPublisherSQLProcedure());
        out.write("\n");
        out.write(this.generateImportPaperSQLProcedure());
        out.write("\n");
        out.write(this.generateImportAuthorPaperSQLProcedure());
        out.write("\n");
        fr = null;
        buffer = null;
        in = null;
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
            try {
                if(this.authors != null){
                    out.write(this.paper.generateListAuthorCallStatement());
                }
                if(this.paper.getJournal() != null){
                    out.write(this.paper.generateJournalCallStatement());
                    out.write("\n");
                }
                if(this.paper.getPublisher() != null){
                    out.write(this.paper.generatePublisherCallStatement());
                    out.write("\n");
                }                
                out.write(this.paper.generatePaperTypeCallStatement());
                out.write("\n");
                out.write(this.paper.generatePaperCallStatement());
                out.write("\n");
                if(this.paper.getAuthors() != null){
                    out.write(this.paper.generateAuthorPaperCallStatement()); 
                }                               
            } catch (IOException ex) {
                Logger.getLogger(CSPublicationSAXEventHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.authors = null;            
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
            this.paper.setPaperType(qName);
            return;
        }
    } 
    /**
    DELIMITER $$
    CREATE PROCEDURE insertAuthor(nameAuthor NVARCHAR(50))
    BEGIN	
        DECLARE fetchable INT DEFAULT 0;	
        DECLARE a1 NVARCHAR(50);
        DECLARE a CURSOR FOR SELECT authorName FROM author WHERE authorName = nameAuthor;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;	
        IF fetchable THEN INSERT INTO author(authorName) VALUES (nameAuthor);	
        END IF;
        CLOSE a;	
    END$$
     */
    public String generateImportAuthorSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertAuthor(nameAuthor NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN");
	sqlString.append("\n");
        sqlString.append("DECLARE fetchable INT DEFAULT 0;");
	sqlString.append("\n");
        sqlString.append("DECLARE a1 NVARCHAR(50);");
	sqlString.append("\n");
        sqlString.append("DECLARE a CURSOR FOR SELECT authorName FROM author WHERE authorName = nameAuthor;");
	sqlString.append("\n");
        sqlString.append("DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;");
	sqlString.append("\n");
        sqlString.append("OPEN a;");
	sqlString.append("\n");
        sqlString.append("FETCH NEXT FROM a INTO a1;");
	sqlString.append("\n");
        sqlString.append("IF fetchable THEN INSERT INTO author(authorName) VALUES (nameAuthor);");
	sqlString.append("\n");
        sqlString.append("END IF;");
	sqlString.append("\n");
        sqlString.append("CLOSE a;");	
        sqlString.append("\n");
        sqlString.append("END$$");        
        return sqlString.toString();
    }
    
    /**
    DELIMITER $$
    CREATE PROCEDURE insertJournal(nameJournal NVARCHAR(50))
    BEGIN	
        DECLARE fetchable INT DEFAULT 0;	
        DECLARE a1 NVARCHAR(50);
        DECLARE a CURSOR FOR SELECT journalName FROM journal WHERE journalName = nameJournal;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;	
        IF fetchable THEN INSERT INTO journal(journalName) VALUES (nameJournal);	
        END IF;
        CLOSE a;	
    END$$
     */
    public String generateImportJournalSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertJournal(nameJournal NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN");
	sqlString.append("\n");
        sqlString.append("DECLARE fetchable INT DEFAULT 0;");
	sqlString.append("\n");
        sqlString.append("DECLARE a1 NVARCHAR(50);");
	sqlString.append("\n");
        sqlString.append("DECLARE a CURSOR FOR SELECT journalName FROM journal WHERE journalName = nameJournal;");
	sqlString.append("\n");
        sqlString.append("DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;");
	sqlString.append("\n");
        sqlString.append("OPEN a;");
	sqlString.append("\n");
        sqlString.append("FETCH NEXT FROM a INTO a1;");
	sqlString.append("\n");
        sqlString.append("IF fetchable THEN INSERT INTO journal(journalName) VALUES (nameJournal);");
	sqlString.append("\n");
        sqlString.append("END IF;");
	sqlString.append("\n");
        sqlString.append("CLOSE a;");	
        sqlString.append("\n");
        sqlString.append("END$$");        
        return sqlString.toString();
    }
    /**
    DELIMITER $$
    CREATE PROCEDURE insertPublisher(publisherName NVARCHAR(50))
    BEGIN	
        DECLARE fetchable INT DEFAULT 0;	
        DECLARE a1 NVARCHAR(50);
        DECLARE a CURSOR FOR SELECT namePublisher FROM publisher WHERE namePublisher = publisherName;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;	
        IF fetchable THEN INSERT INTO publisher(namePublisher) VALUES (publisherName);	
        END IF;
        CLOSE a;	
    END$$
     */
    public String generateImportPublisherSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertPublisher(publisherName NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN");
	sqlString.append("\n");
        sqlString.append("DECLARE fetchable INT DEFAULT 0;");
	sqlString.append("\n");
        sqlString.append("DECLARE a1 NVARCHAR(50);");
	sqlString.append("\n");
        sqlString.append("DECLARE a CURSOR FOR SELECT namePublisher FROM publisher WHERE namePublisher = publisherName;");
	sqlString.append("\n");
        sqlString.append("DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;");
	sqlString.append("\n");
        sqlString.append("OPEN a;");
	sqlString.append("\n");
        sqlString.append("FETCH NEXT FROM a INTO a1;");
	sqlString.append("\n");
        sqlString.append("IF fetchable THEN INSERT INTO publisher(namePublisher) VALUES (publisherName);");
	sqlString.append("\n");
        sqlString.append("END IF;");
	sqlString.append("\n");
        sqlString.append("CLOSE a;");	
        sqlString.append("\n");
        sqlString.append("END$$");        
        return sqlString.toString();
    }
    /**
    DELIMITER $$
    CREATE PROCEDURE insertConference(conferName NVARCHAR(50))
    BEGIN	
        DECLARE fetchable INT DEFAULT 0;	
        DECLARE a1 NVARCHAR(50);
        DECLARE a CURSOR FOR SELECT conferenceName FROM conference WHERE conferenceName = conferName;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;	
        IF fetchable THEN INSERT INTO conference(conferenceName) VALUES (conferName);	
        END IF;
        CLOSE a;	
    END$$
     */
    public String generateImportConferenceSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertConference(conferName NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN");
	sqlString.append("\n");
        sqlString.append("DECLARE fetchable INT DEFAULT 0;");
	sqlString.append("\n");
        sqlString.append("DECLARE a1 NVARCHAR(50);");
	sqlString.append("\n");
        sqlString.append("DECLARE a CURSOR FOR SELECT conferenceName FROM conference WHERE conferenceName = conferName;");
	sqlString.append("\n");
        sqlString.append("DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;");
	sqlString.append("\n");
        sqlString.append("OPEN a;");
	sqlString.append("\n");
        sqlString.append("FETCH NEXT FROM a INTO a1;");
	sqlString.append("\n");
        sqlString.append("IF fetchable THEN INSERT INTO conference(conferenceName) VALUES (conferName);");
	sqlString.append("\n");
        sqlString.append("END IF;");
	sqlString.append("\n");
        sqlString.append("CLOSE a;");	
        sqlString.append("\n");
        sqlString.append("END$$");        
        return sqlString.toString();
    }
    /**
    DELIMITER $$
    CREATE PROCEDURE insertMagazine(magaName NVARCHAR(50))
    BEGIN	
        DECLARE fetchable INT DEFAULT 0;	
        DECLARE a1 NVARCHAR(50);
        DECLARE a CURSOR FOR SELECT magazineName FROM magazine WHERE magazineName = magaName;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;	
        IF fetchable THEN INSERT INTO magazine(magazineName) VALUES (magaName);	
        END IF;
        CLOSE a;	
    END$$
     */
    public String generateImportMagazineSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertMagazine(magaName NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN");
	sqlString.append("\n");
        sqlString.append("DECLARE fetchable INT DEFAULT 0;");
	sqlString.append("\n");
        sqlString.append("DECLARE a1 NVARCHAR(50);");
	sqlString.append("\n");
        sqlString.append("DECLARE a CURSOR FOR SELECT conferenceName FROM conference WHERE conferenceName = conferName;");
	sqlString.append("\n");
        sqlString.append("DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;");
	sqlString.append("\n");
        sqlString.append("OPEN a;");
	sqlString.append("\n");
        sqlString.append("FETCH NEXT FROM a INTO a1;");
	sqlString.append("\n");
        sqlString.append("IF fetchable THEN INSERT INTO conference(conferenceName) VALUES (conferName);");
	sqlString.append("\n");
        sqlString.append("END IF;");
	sqlString.append("\n");
        sqlString.append("CLOSE a;");	
        sqlString.append("\n");
        sqlString.append("END$$");        
        return sqlString.toString();
    }    
    /**
    DELIMITER $$
    CREATE PROCEDURE insertPaperType(typePaper NVARCHAR(50))
        BEGIN	
        DECLARE fetchable INT DEFAULT 0;	
        DECLARE a1 NVARCHAR(50);
        DECLARE a CURSOR FOR SELECT nameType FROM paper_type WHERE nameType = typePaper;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;	
        IF fetchable THEN INSERT INTO paper_type(nameType) VALUES (typePaper);	
        END IF;
    CLOSE a;	
    END$$
     */
     public String generateImportPaperTypeSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertPaperType(typePaper NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN");
	sqlString.append("\n");
        sqlString.append("DECLARE fetchable INT DEFAULT 0;");
	sqlString.append("\n");
        sqlString.append("DECLARE a1 NVARCHAR(50);");
	sqlString.append("\n");
        sqlString.append("DECLARE a CURSOR FOR SELECT nameType FROM paper_type WHERE nameType = typePaper;");
	sqlString.append("\n");
        sqlString.append("DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;");
	sqlString.append("\n");
        sqlString.append("OPEN a;");
	sqlString.append("\n");
        sqlString.append("FETCH NEXT FROM a INTO a1;");
	sqlString.append("\n");
        sqlString.append("IF fetchable THEN INSERT INTO paper_type(nameType) VALUES (typePaper);");
	sqlString.append("\n");
        sqlString.append("END IF;");
	sqlString.append("\n");
        sqlString.append("CLOSE a;");	
        sqlString.append("\n");
        sqlString.append("END$$");        
        return sqlString.toString();
    }
    /**
    DELIMITER $$
    CREATE PROCEDURE insertPaper(doiInput VARCHAR(10), isbnInput VARCHAR(10), urlInput VARCHAR(50), titleInput VARCHAR(100), abstractInput VARCHAR(1000), volumeInput VARCHAR(10), pagesInput VARCHAR(10), 
    yearInput INT, viewPublicationInput VARCHAR(10), bibTexInput VARCHAR(100), endNoteInput VARCHAR(100), nameJournalInput VARCHAR(50),  namePublisherInput VARCHAR(50), namePapertype VARCHAR(50), 
    nameMagazine VARCHAR(50), nameConference VARCHAR(50), dblpKeyInput VARCHAR(50), versionInput VARCHAR(50), paperFileInput VARCHAR(50))
    BEGIN	
            DECLARE fetchable INT DEFAULT 0;	
            DECLARE jo NVARCHAR(50);
            DECLARE pu NVARCHAR(50);
            DECLARE co NVARCHAR(50);
            DECLARE ma NVARCHAR(50);
            DECLARE pa NVARCHAR(50);
            DECLARE idJournalCursor CURSOR FOR SELECT idJournal FROM journal WHERE journalName = nameJournalInput;
            DECLARE idPublisherCursor CURSOR FOR SELECT idPublisher FROM publisher WHERE namePublisher = namePublisherInput;
            DECLARE idConferenceCursor CURSOR FOR SELECT idConference FROM conference WHERE conferenceName = nameConference;
            DECLARE idMagazineCursor CURSOR FOR SELECT idMagazine FROM magazine WHERE magazineName = nameMagazine;
            DECLARE idPaperTypeCursor CURSOR FOR SELECT idPaperType FROM paper_type WHERE nameType = namePapertype;
            DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
            OPEN idJournalCursor;
            FETCH NEXT FROM idJournalCursor INTO jo;
            CLOSE idJournalCursor;	
            OPEN idPublisherCursor;
            FETCH NEXT FROM idPublisherCursor INTO pu;
            CLOSE idPublisherCursor;	
            OPEN idConferenceCursor;
            FETCH NEXT FROM idConferenceCursor INTO co;
            CLOSE idConferenceCursor;	
            OPEN idMagazineCursor;
            FETCH NEXT FROM idMagazineCursor INTO ma;
            CLOSE idMagazineCursor;	
            OPEN idPaperTypeCursor;
            FETCH NEXT FROM idPaperTypeCursor INTO pa;
            CLOSE idPaperTypeCursor;	
            INSERT INTO paper(doi, isbn, url, title, abstract, volume, pages, paper.year, viewPublication, bibTex, endNote, idJournal,  idPublisher, idPaperType, idMagazine, idConference, dblpKey, paper.version, paperFile) 
            VALUES (doiInput, isbnInput , urlInput, titleInput, abstractInput, volumeInput, pagesInput, yearInput, viewPublicationInput, bibTexInput, endNoteInput, jo,  pu, pa, ma, co, dblpKeyInput, versionInput, paperFileInput);

    END$$
      */
     public String generateImportPaperSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertPaper(doiInput VARCHAR(10), isbnInput VARCHAR(10), urlInput VARCHAR(50), titleInput VARCHAR(100), abstractInput VARCHAR(1000), volumeInput VARCHAR(10), pagesInput VARCHAR(10)," + 
                        "yearInput INT, viewPublicationInput VARCHAR(10), bibTexInput VARCHAR(100), endNoteInput VARCHAR(100), nameJournalInput VARCHAR(50),  namePublisherInput VARCHAR(50), namePapertype VARCHAR(50)," + 
                        "nameMagazine VARCHAR(50), nameConference VARCHAR(50), dblpKeyInput VARCHAR(50), versionInput VARCHAR(50), paperFileInput VARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN\n" +
                            "DECLARE fetchable INT DEFAULT 0; \n" +
                            "DECLARE jo NVARCHAR(50);\n"+
                            "DECLARE pu NVARCHAR(50);\n"+
                            "DECLARE co NVARCHAR(50);\n"+
                            "DECLARE ma NVARCHAR(50);\n"+
                            "DECLARE pa NVARCHAR(50);\n"+
                            "DECLARE idJournalCursor CURSOR FOR SELECT idJournal FROM journal WHERE journalName = nameJournalInput;\n"+
                            "DECLARE idPublisherCursor CURSOR FOR SELECT idPublisher FROM publisher WHERE namePublisher = namePublisherInput;\n"+
                            "DECLARE idConferenceCursor CURSOR FOR SELECT idConference FROM conference WHERE conferenceName = nameConference;\n"+
                            "DECLARE idMagazineCursor CURSOR FOR SELECT idMagazine FROM magazine WHERE magazineName = nameMagazine;\n"+
                            "DECLARE idPaperTypeCursor CURSOR FOR SELECT idPaperType FROM paper_type WHERE nameType = namePapertype;\n"+
                            "DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;\n"+
                            "OPEN idJournalCursor;\n"+
                            "FETCH NEXT FROM idJournalCursor INTO jo;\n"+
                            "CLOSE idJournalCursor;\n"+
                            "OPEN idPublisherCursor;\n"+
                            "FETCH NEXT FROM idPublisherCursor INTO pu;\n"+
                            "CLOSE idPublisherCursor;\n"+
                            "OPEN idConferenceCursor;\n"+
                            "FETCH NEXT FROM idConferenceCursor INTO co;\n"+
                            "CLOSE idConferenceCursor;\n"+
                            "OPEN idMagazineCursor;\n"+
                            "FETCH NEXT FROM idMagazineCursor INTO ma;\n"+
                            "CLOSE idMagazineCursor;\n"+
                            "OPEN idPaperTypeCursor;\n"+
                            "FETCH NEXT FROM idPaperTypeCursor INTO pa;\n"+
                            "CLOSE idPaperTypeCursor;\n"+
                            "INSERT INTO paper(doi, isbn, url, title, abstract, volume, pages, paper.year, viewPublication, bibTex, endNote, idJournal, idConference, idMagazine, idPublisher, idPaperType, dblpKey, paper.version, paperFile)\n"+
                            "VALUES (doiInput, isbnInput , urlInput, titleInput, abstractInput, volumeInput, pagesInput, yearInput, viewPublicationInput, bibTexInput, endNoteInput, jo,  co, ma, pu, pa, dblpKeyInput, versionInput, paperFileInput);\n"+      
                    "END$$");	
        return sqlString.toString();
    }
     /**
    DELIMITER $$
    CREATE PROCEDURE insertPaperAuthor(namePaper NVARCHAR(100), nameAuthor NVARCHAR(50))
    BEGIN	
        DECLARE fetchable INT DEFAULT 0;
        DECLARE a1 INT;
        DECLARE a2 INT;
        DECLARE a CURSOR FOR SELECT idAuthor FROM author WHERE authorName = nameAuthor;
        DECLARE b CURSOR FOR SELECT idPaper FROM paper WHERE title = namePaper;
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;
        OPEN a;
        FETCH NEXT FROM a INTO a1;
        OPEN b;
        FETCH NEXT FROM b INTO a2;
        INSERT INTO author_paper(idAuthor, idPaper) VALUES (a1, a2);		
        CLOSE a;
        CLOSE b;	
    END$$
      */
     public String generateImportAuthorPaperSQLProcedure(){
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("DELIMITER $$");        
        sqlString.append("\n");
        sqlString.append("CREATE PROCEDURE insertPaperAuthor(namePaper NVARCHAR(100), nameAuthor NVARCHAR(50))");
        sqlString.append("\n");
        sqlString.append("BEGIN\n"+
                            "DECLARE fetchable INT DEFAULT 0;\n"+
                            "DECLARE a1 INT;\n"+
                            "DECLARE a2 INT;\n"+
                            "DECLARE a CURSOR FOR SELECT idAuthor FROM author WHERE authorName = nameAuthor;\n"+
                            "DECLARE b CURSOR FOR SELECT idPaper FROM paper WHERE title = namePaper;\n"+
                            "DECLARE CONTINUE HANDLER FOR NOT FOUND SET fetchable = 1;\n"+
                            "OPEN a;\n"+
                            "FETCH NEXT FROM a INTO a1;\n"+
                            "OPEN b;\n"+
                            "FETCH NEXT FROM b INTO a2;\n"+
                            "INSERT INTO author_paper(idAuthor, idPaper) VALUES (a1, a2);\n"+
                            "CLOSE a;\n"+
                            "CLOSE b;\n"+
                        "END$$\n");	
        return sqlString.toString();
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
