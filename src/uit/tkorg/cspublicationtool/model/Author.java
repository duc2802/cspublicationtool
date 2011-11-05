/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.model;

import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author tiendv
 */
public class Author implements Serializable{
    private int idAuthor;
    private String authorName;
    private String image;
    private String emailAdress;
    private String website;
    private String duration;
    private int h_index;
    private int g_index;
    private String url; 
    private AuthorInstance authorInstance;
    private Set papers;

    public String getAuthorName() {
        return authorName;
    }

    public String getDuration() {
        return duration;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public int getG_index() {
        return g_index;
    }

    public int getH_index() {
        return h_index;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public String getImage() {
        return image;
    }



    public String getUrl() {
        return url;
    }

    public String getWebsite() {
        return website;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public void setG_index(int g_index) {
        this.g_index = g_index;
    }

    public void setH_index(int h_index) {
        this.h_index = h_index;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public void setUrl(String url) {
        this.url = url;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
 
}
