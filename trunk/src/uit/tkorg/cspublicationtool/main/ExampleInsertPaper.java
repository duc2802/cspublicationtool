/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uit.tkorg.cspublicationtool.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author tiendv
 */
public class ExampleInsertPaper {
    
    // Read A note from XML file have some data:
//    
//    public static void main(String[] args) {
//        
//            
//       // Read A note from XML file have some data:
//        /*
//         * 
//         * 
//         * 
//         * Duc ................
//         
//         */
//
//    	Session session = null;
//    	Transaction tx=null;
//    	try {
//        	// This step will read hibernate.cfg.xml and prepare hibernate for use
//        	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        	session = sessionFactory.openSession();
//        	tx=session.beginTransaction();
//                
//        	// Create new instance of paper and set values in it by reading xml file
//        	System.out.println("Inserting Record");
//                Paper newpaper = new Paper();
//                /*
//                 *
//                 * Input data to object Paper
//                 * 
//                 */
//        	session.save(newpaper);
//        	tx.commit();
//        	System.out.println("Done");
//
//    	} catch (Exception e) {
//
//        	System.out.println(e.getMessage());
//
//    	} finally {
//
//        	// Actual contact insertion will happen at this step
//        	session.flush();
//        	session.close();
//                
//                // Delete Object 
//    	}
//	}

    
}
