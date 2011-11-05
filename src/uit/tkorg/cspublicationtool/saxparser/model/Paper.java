/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.saxparser.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author THANG
 *///author|editor|title|booktitle|pages|year|address|journal|volume|number|month|url|ee|cdrom|cite|publisher|note|crossref|isbn|series|school|chapter
public class Paper {
    private ArrayList<Author> authors;
    private String title;
    private String booktitle;
    private String papges;
    private String year;
    private String address;
    private String journal;
    private String volume;
    private String number;
    private String month;
    private String url;
    private String ee;
    private String cdrom;
    private String cite;
    private String publisher;
    private String note;
    private String crossref;
    private String isbn;
    private String series;
    private String school;
    private String chapter;
    private String key;
    private String mdate;
    
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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
        
    public void setKey(String key) {
        this.key = key;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }
    
    public String getKey() {
        return key;
    }

    public String getMdate() {
        return mdate;
    }
    
    public String getChapter() {
        return chapter;
    }

    public String getMonth() {
        return month;
    }

    public String getSchool() {
        return school;
    }

    public String getSeries() {
        return series;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSeries(String series) {
        this.series = series;
    }
    
    
    public String getAddress() {
        return address;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String getCdrom() {
        return cdrom;
    }

    public String getCite() {
        return cite;
    }

    public String getCrossref() {
        return crossref;
    }

    public String getEe() {
        return ee;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getJournal() {
        return journal;
    }

    public String getNote() {
        return note;
    }

    public String getNumber() {
        return number;
    }

    public String getPapges() {
        return papges;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getVolume() {
        return volume;
    }

    public String getYear() {
        return year;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPapges(String papges) {
        this.papges = papges;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
