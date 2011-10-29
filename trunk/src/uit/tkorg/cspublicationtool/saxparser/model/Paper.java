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
    private String papges;
    private String year;
    private String address;
    private String journal;
    private String volume;
    private String number;
    private String url;
    private String ee;
    private String cdrom;
    private String cite;
    private String publisher;
    private String note;
    private String crossref;
    private String isbn;

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
