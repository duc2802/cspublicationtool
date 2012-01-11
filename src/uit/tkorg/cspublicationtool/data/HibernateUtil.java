/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uit.tkorg.cspublicationtool.data;


import org.hibernate.cfg.*;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.criterion.*;

/**
 *
 * @author tiendv
 * 
 * Quan ly cac session va transaction cua Hibernate
 * 
 */
public class HibernateUtil {

    private SessionFactory sessionFactory;
    //private Session session;
    private StatelessSession session; 
    private String sessionFactoryConfigPath;
    private Transaction tx;

    protected LockMode lockMode;
    protected Order order;
    protected Criteria criteria;
    protected Restrictions restrictions;

    public HibernateUtil() throws Exception {
        sessionFactoryConfigPath = "";
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public HibernateUtil(String sessionFactoryConfigPath) {
        this.sessionFactoryConfigPath = sessionFactoryConfigPath;
        sessionFactory = new Configuration().configure(sessionFactoryConfigPath).buildSessionFactory();
    }

    /**
     * Begin a transaction
     */
    protected void beginTransaction() {
        //session = sessionFactory.getCurrentSession();
         session = sessionFactory.openStatelessSession();
      //  Transaction tx = session.beginTransaction();
        session.beginTransaction();
    }

    /**
     * Commit transaction and close session
     */
    protected void commitAndClose() {
//        if (session != null) {
//            for(int i=0;i<1000;i++) {
//                if ( i % 50 == 0 ) { //50, same as the JDBC batch size
//                                     //flush a batch of inserts and release memory:
//                        session.flush();
//                        session.clear();
//                }               
//            }
            session.getTransaction().commit();
//            if (session.isOpen()) {
                session.close();
//            }
       // }
    }

    /**
     * Get Current Session
     * @return session
     * @throws Exception
     */
    protected StatelessSession getCurrentSession() throws Exception {
        if (session == null) { // check session null
            if (sessionFactory == null) { // buil Factory Session if it's null
                if (sessionFactoryConfigPath == null || sessionFactoryConfigPath.equals("")) {
                    sessionFactory = new Configuration().configure().buildSessionFactory();
                } else {
                    sessionFactory = new Configuration().configure(this.sessionFactoryConfigPath).buildSessionFactory();
                }
            }
           // session = sessionFactory.getCurrentSession();
            session = sessionFactory.openStatelessSession();
          //  session.setFlushMode(FlushMode.COMMIT);
        }

        return session;
    }
}
