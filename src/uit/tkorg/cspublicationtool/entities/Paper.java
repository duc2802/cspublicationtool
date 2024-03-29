package uit.tkorg.cspublicationtool.entities;
// Generated Dec 4, 2011 5:00:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Paper generated by hbm2java
 */
public class Paper  implements java.io.Serializable {


     private Integer idPaper;
     private Integer version;
     private Journal journal;
     private Conference conference;
     private PaperType paperType;
     private Magazine magazine;
     private Publisher publisher;
     private String doi;
     private String isbn;
     private String url;
     private String title;
     private String abstract_;
     private String volume;
     private String pages;
     private Integer year;
     private String viewPublication;
     private String bibTex;
     private String endNote;
     private String dblpKey;
     private String paperFile;
     private String adress;
     private String number;
     private String month;
     private String ee;
     private String crossref;
     private String series;
     private String school;
     private String chapter;
     private String cdrom;
     private String cite;
     private Set keywords = new HashSet(0);
     private Set comments = new HashSet(0);
     private Set paperPapersForIdPaper = new HashSet(0);
     private Set paperPapersForIdPaperRef = new HashSet(0);
     private Set authors = new HashSet(0);
     private Set paperReviewers = new HashSet(0);

    public Paper() {
    }

    public Paper(Journal journal, Conference conference, PaperType paperType, Magazine magazine, Publisher publisher, String doi, String isbn, String url, String title, String abstract_, String volume, String pages, Integer year, String viewPublication, String bibTex, String endNote, String dblpKey, String paperFile, String adress, String number, String month, String ee, String crossref, String series, String school, String chapter, String cdrom, String cite, Set keywords, Set comments, Set paperPapersForIdPaper, Set paperPapersForIdPaperRef, Set authors, Set paperReviewers) {
       this.journal = journal;
       this.conference = conference;
       this.paperType = paperType;
       this.magazine = magazine;
       this.publisher = publisher;
       this.doi = doi;
       this.isbn = isbn;
       this.url = url;
       this.title = title;
       this.abstract_ = abstract_;
       this.volume = volume;
       this.pages = pages;
       this.year = year;
       this.viewPublication = viewPublication;
       this.bibTex = bibTex;
       this.endNote = endNote;
       this.dblpKey = dblpKey;
       this.paperFile = paperFile;
       this.adress = adress;
       this.number = number;
       this.month = month;
       this.ee = ee;
       this.crossref = crossref;
       this.series = series;
       this.school = school;
       this.chapter = chapter;
       this.cdrom = cdrom;
       this.cite = cite;
       this.keywords = keywords;
       this.comments = comments;
       this.paperPapersForIdPaper = paperPapersForIdPaper;
       this.paperPapersForIdPaperRef = paperPapersForIdPaperRef;
       this.authors = authors;
       this.paperReviewers = paperReviewers;
    }
   
    public Integer getIdPaper() {
        return this.idPaper;
    }
    
    public void setIdPaper(Integer idPaper) {
        this.idPaper = idPaper;
    }
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }
    public Journal getJournal() {
        return this.journal;
    }
    
    public void setJournal(Journal journal) {
        this.journal = journal;
    }
    public Conference getConference() {
        return this.conference;
    }
    
    public void setConference(Conference conference) {
        this.conference = conference;
    }
    public PaperType getPaperType() {
        return this.paperType;
    }
    
    public void setPaperType(PaperType paperType) {
        this.paperType = paperType;
    }
    public Magazine getMagazine() {
        return this.magazine;
    }
    
    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }
    public Publisher getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
    public String getDoi() {
        return this.doi;
    }
    
    public void setDoi(String doi) {
        this.doi = doi;
    }
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAbstract_() {
        return this.abstract_;
    }
    
    public void setAbstract_(String abstract_) {
        this.abstract_ = abstract_;
    }
    public String getVolume() {
        return this.volume;
    }
    
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getPages() {
        return this.pages;
    }
    
    public void setPages(String pages) {
        this.pages = pages;
    }
    public Integer getYear() {
        return this.year;
    }
    
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getViewPublication() {
        return this.viewPublication;
    }
    
    public void setViewPublication(String viewPublication) {
        this.viewPublication = viewPublication;
    }
    public String getBibTex() {
        return this.bibTex;
    }
    
    public void setBibTex(String bibTex) {
        this.bibTex = bibTex;
    }
    public String getEndNote() {
        return this.endNote;
    }
    
    public void setEndNote(String endNote) {
        this.endNote = endNote;
    }
    public String getDblpKey() {
        return this.dblpKey;
    }
    
    public void setDblpKey(String dblpKey) {
        this.dblpKey = dblpKey;
    }
    public String getPaperFile() {
        return this.paperFile;
    }
    
    public void setPaperFile(String paperFile) {
        this.paperFile = paperFile;
    }
    public String getAdress() {
        return this.adress;
    }
    
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getNumber() {
        return this.number;
    }
    
    public void setNumber(String number) {
        this.number = number;
    }
    public String getMonth() {
        return this.month;
    }
    
    public void setMonth(String month) {
        this.month = month;
    }
    public String getEe() {
        return this.ee;
    }
    
    public void setEe(String ee) {
        this.ee = ee;
    }
    public String getCrossref() {
        return this.crossref;
    }
    
    public void setCrossref(String crossref) {
        this.crossref = crossref;
    }
    public String getSeries() {
        return this.series;
    }
    
    public void setSeries(String series) {
        this.series = series;
    }
    public String getSchool() {
        return this.school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    public String getChapter() {
        return this.chapter;
    }
    
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
    public String getCdrom() {
        return this.cdrom;
    }
    
    public void setCdrom(String cdrom) {
        this.cdrom = cdrom;
    }
    public String getCite() {
        return this.cite;
    }
    
    public void setCite(String cite) {
        this.cite = cite;
    }
    public Set getKeywords() {
        return this.keywords;
    }
    
    public void setKeywords(Set keywords) {
        this.keywords = keywords;
    }
    public Set getComments() {
        return this.comments;
    }
    
    public void setComments(Set comments) {
        this.comments = comments;
    }
    public Set getPaperPapersForIdPaper() {
        return this.paperPapersForIdPaper;
    }
    
    public void setPaperPapersForIdPaper(Set paperPapersForIdPaper) {
        this.paperPapersForIdPaper = paperPapersForIdPaper;
    }
    public Set getPaperPapersForIdPaperRef() {
        return this.paperPapersForIdPaperRef;
    }
    
    public void setPaperPapersForIdPaperRef(Set paperPapersForIdPaperRef) {
        this.paperPapersForIdPaperRef = paperPapersForIdPaperRef;
    }
    public Set getAuthors() {
        return this.authors;
    }
    
    public void setAuthors(Set authors) {
        this.authors = authors;
    }
    public Set getPaperReviewers() {
        return this.paperReviewers;
    }
    
    public void setPaperReviewers(Set paperReviewers) {
        this.paperReviewers = paperReviewers;
    }




}


