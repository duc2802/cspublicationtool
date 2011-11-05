/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.saxparser.model;

/**
 *
 * @author THANG
 */
public class Author {
    private String name;
    
    public Author() {
        
    }
    public String generateAutorImportCallProcedure(){
        return "CALL insertAuthor('" + this.name + "');";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
