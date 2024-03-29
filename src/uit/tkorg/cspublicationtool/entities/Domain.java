package uit.tkorg.cspublicationtool.entities;
// Generated Dec 4, 2011 5:00:43 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Domain generated by hbm2java
 */
public class Domain  implements java.io.Serializable {


     private Integer idDomain;
     private String domainName;
     private Set subdomains = new HashSet(0);

    public Domain() {
    }

    public Domain(String domainName, Set subdomains) {
       this.domainName = domainName;
       this.subdomains = subdomains;
    }
   
    public Integer getIdDomain() {
        return this.idDomain;
    }
    
    public void setIdDomain(Integer idDomain) {
        this.idDomain = idDomain;
    }
    public String getDomainName() {
        return this.domainName;
    }
    
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }
    public Set getSubdomains() {
        return this.subdomains;
    }
    
    public void setSubdomains(Set subdomains) {
        this.subdomains = subdomains;
    }




}


