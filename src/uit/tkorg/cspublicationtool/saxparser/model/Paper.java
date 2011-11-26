/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.saxparser.model;

import java.util.ArrayList;
import java.util.List;
import javax.sound.midi.SysexMessage;

/**
 *
 * @author THANG
 *///author|editor|title|booktitle|pages|year|address|journal|volume|number|month|url|ee|cdrom|cite|publisher|note|crossref|isbn|series|school|chapter
public class Paper {
    private String paperType;
    private ArrayList<Author> authors;
    private String title = null;
    private String booktitle = null;
    private String papges = null;
    private String year = null;
    private String address = null;
    private String journal = null;
    private String volume = null;
    private String number = null;
    private String month = null;
    private String url = null;
    private String ee = null;
    private String cdrom = null;
    private String cite = null;
    private String publisher = null;
    private String note = null;
    private String crossref = null;
    private String isbn = null;
    private String series = null;
    private String school = null;
    private String chapter = null;
    private String key = null;
    private String mdate = null;
    
    public String generateListAuthorCallStatement(){
        StringBuffer contents = new StringBuffer();
        for(int i = 0; i < this.authors.size(); i++){
            contents.append(this.authors.get(i).generateAutorImportCallProcedure());
            contents.append("\n");
        }        
        return contents.toString();
    }
    public String generateJournalCallStatement(){
        return "CALL insertJournal('" + this.journal + "');";
    }
    
    //public String generateMagazineCallStatement(){
    //    return "CALL insertAuthor('" + this.address + "');";
    //}
    
    public String generatePaperTypeCallStatement(){
        return "CALL insertPaperType('" + this.paperType + "');";
    }
    
   // public String generateConferenceCallStatement(){
    //    return "CALL insertAuthor('" + this.address + "');";
   //}
    
    public String generatePublisherCallStatement(){
        return "CALL insertPublisher('" + this.publisher + "');";
    }
    public String generatePaperCallStatement(){
        String str = "CALL insertPaper('', '"+this.isbn+"', '"+this.url+"', '"+this.title+"', '', '"+this.volume+"', '"+this.papges+"', "+this.year+", '', '', '', '"+this.journal+"', '', '', '"+this.publisher+"', '"+this.paperType+"','"+this.key+"', 0, '');";
        return str;
    }
    public String generateAuthorPaperCallStatement(){
        StringBuffer contents = new StringBuffer();
        for(int i = 0; i < this.authors.size(); i++){
            contents.append("CALL insertPaperAuthor('" + this.title + "','" + this.authors.get(i).getName() + "');");
            contents.append("\n");
        }        
        return contents.toString();
    }
    
    public void printOut(){
        System.out.println("Title: " + this.getTitle());
        System.out.println("DPLD Key: " + this.getKey());
        System.out.println("DPLB MDate: " + this.getMdate());
        for(int i = 0; i < this.authors.size(); i++){
            System.out.println("Author: " + this.authors.get(i).generateAutorImportCallProcedure());
        }
        //System.out.println("");
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
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
