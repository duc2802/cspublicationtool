/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.model;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tiendv
 */
public class Paper  implements Serializable{
    
    private int idPaper;
    private String doi;
    private String isbn;
    private String url;
    private String title;
    private String abstractPaper;
    private String volume;
    private int year;
    private String viewPublicaiton;
    private String bibTex;
    private String endNote;
    private String dblpKey;
    private String vesion;
    private String paperFile;
    private Journal journal;
    private Conference conference;
    private Magazine magazine;
    private Publisher publisher;
    private PaperType papertype; 
    private Set authors;

    public void setAbstractPaper(String abstractPaper) {
        this.abstractPaper = abstractPaper;
    }

    public void setBibTex(String bibTex) {
        this.bibTex = bibTex;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

    public void setDblpKey(String dblpKey) {
        this.dblpKey = dblpKey;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public void setEndNote(String endNote) {
        this.endNote = endNote;
    }

    public void setIdPaper(int idPaper) {
        this.idPaper = idPaper;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public void setPaperFile(String paperFile) {
        this.paperFile = paperFile;
    }

    public void setPapertype(PaperType papertype) {
        this.papertype = papertype;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVesion(String vesion) {
        this.vesion = vesion;
    }

    public void setViewPublicaiton(String viewPublicaiton) {
        this.viewPublicaiton = viewPublicaiton;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAbstractPaper() {
        return abstractPaper;
    }

    public String getBibTex() {
        return bibTex;
    }

    public Conference getConference() {
        return conference;
    }

    public String getDblpKey() {
        return dblpKey;
    }

    public String getDoi() {
        return doi;
    }

    public String getEndNote() {
        return endNote;
    }

    public int getIdPaper() {
        return idPaper;
    }

    public String getIsbn() {
        return isbn;
    }

    public Journal getJournal() {
        return journal;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public String getPaperFile() {
        return paperFile;
    }

    public PaperType getPapertype() {
        return papertype;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getVesion() {
        return vesion;
    }

    public String getViewPublicaiton() {
        return viewPublicaiton;
    }

    public String getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }
}
