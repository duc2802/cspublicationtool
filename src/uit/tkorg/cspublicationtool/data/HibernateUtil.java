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
    private Session session;
    private String sessionFactoryConfigPath;

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
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
    }

    /**
     * Commit transaction and close session
     */
    protected void commitAndClose() {
        if (session != null) {
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Get Current Session
     * @return session
     * @throws Exception
     */
    protected Session getCurrentSession() throws Exception {
        if (session == null) { // check session null
            if (sessionFactory == null) { // buil Factory Session if it's null
                if (sessionFactoryConfigPath == null || sessionFactoryConfigPath.equals("")) {
                    sessionFactory = new Configuration().configure().buildSessionFactory();
                } else {
                    sessionFactory = new Configuration().configure(this.sessionFactoryConfigPath).buildSessionFactory();
                }
            }
            session = sessionFactory.getCurrentSession();
        }

        return session;
    }
}
