/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package uit.tkorg.cspublicationtool.data;

/**
 *
 * @author tiendv
 * 
 * Tao mot temple object thuc thi cac sesion va cac phuong thuc update insert query cua hibernate
 */
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class ManagerBase<T> extends HibernateUtil {

    private Class<T> persistentClass;

    public ManagerBase() throws Exception {
        super();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public ManagerBase(String sessionFactotyConfigPath) {
        super(sessionFactotyConfigPath);
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return this.persistentClass;
    }

    /**
     * Add new entity and commit it to database
     * @param entity
     * @throws Exception
     */
    public void addNew(T entity) throws Exception {
        beginTransaction();
        getCurrentSession().save(entity);
        commitAndClose();
    }

    /**
     * Update or Add a entity and commit it to Database
     * @param entity
     * @throws Exception
     */
    public void update(T entity) throws Exception {
        beginTransaction();
        getCurrentSession().saveOrUpdate(entity);
        commitAndClose();
    }

    /**
     * Delete a entity and commit action to Database
     * @param entity
     * @throws Exception
     */
    public void delete(T entity) throws Exception {
        beginTransaction();
        getCurrentSession().delete(entity);
        commitAndClose();
    }

    /**
     * Get all rows in table of entity
     * @return
     * @throws Exception
     */
    public List<T> getAll() throws Exception {
        List<T> list = null;

        beginTransaction();
        list = getCurrentSession().createCriteria(this.persistentClass).list();
        commitAndClose();

        return list;
    }

    /**
     * Get a entity by Id
     * @param id of entity
     * @param locked lock entity
     * @return a entity
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public T getById(int id, boolean locked) throws Exception {
        T entity;

        beginTransaction();

        if (locked) {
            entity = (T) getCurrentSession().load(getPersistentClass(), id, lockMode.UPGRADE);
        } else {
            entity = (T) getCurrentSession().load(getPersistentClass(), id);
        }

        commitAndClose();

        return entity;
    }

    /**
     * Execute a sql non query
     * @param sql non query
     * @return number of row effected
     * @throws Exception
     */
    public int excecuteSQl(String sql) throws Exception {
        int i = 0;

        beginTransaction();
        i = getCurrentSession().createSQLQuery(sql).executeUpdate();
        commitAndClose();

        return i;
    }

    /**
     * Get List of entity follow order and max result
     * @param orders list order follow format: "ColumnName desc" or "ColumnName"
     * @param maxResult max of number rows, set 0 for get all
     * @return list of entity
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public List<T> getBySQLQuery(String[] orders, int maxResult) throws Exception {
        List list = null;
        String[] temp;

        beginTransaction();

        // create criteria from persitent class
        criteria = getCurrentSession().createCriteria(getPersistentClass());

        // add order list into criteria
        if (orders != null) {
            for (int i = 0; i < orders.length; i++) {
                if (orders[i].contains(" ")) {
                    temp = orders[i].split(" ");
                    if (temp[1].equalsIgnoreCase("desc")) {
                        criteria.addOrder(order.desc(temp[0]));
                    }
                } else {
                    criteria.addOrder(order.asc(orders[i]));
                }
            }
        }

        // set max result if it greater -1
        if (maxResult > 0) {
            criteria.setMaxResults(maxResult);
        }

        list = criteria.list();
        //criteria = null;

        commitAndClose();

        return list;
    }

    /**
     * Get List of entity follow order and max result and where clause
     * @param where where clause, example: id = 2 and col like 'a%'
     * @param orders list order follow format: "ColumnName desc" or "ColumnName"
     * @param maxResult max of number rows, set 0 for get all
     * @return list of entity
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public List<T> getBySQLQuery(String where, String[] orders, int maxResult) throws Exception {
        List<T> list = null;
        String[] temp;

        beginTransaction();

        // create criteria from persitent class
        criteria = getCurrentSession().createCriteria(getPersistentClass());

        // add where clause
        if (where != null && !where.equals("")) {
            criteria.add(restrictions.sqlRestriction(where));
        }

        // add order list into criteria
        if (orders != null) {
            for (int i = 0; i < orders.length; i++) {
                if (orders[i].contains(" ")) {
                    temp = orders[i].split(" ");
                    if (temp[1].equalsIgnoreCase("desc")) {
                        criteria.addOrder(order.desc(temp[0]));
                    }
                } else {
                    criteria.addOrder(order.asc(orders[i]));
                }
            }
        }

        // set max result if it greater -1
        if (maxResult > 0) {
            criteria.setMaxResults(maxResult);
        }

        list = criteria.list();
        //criteria = null;

        commitAndClose();

        return list;
    }

    /**
     * Get list entity from start row posion, condition, order and max result
     * @param where this is where clause of Sql query, example: column = '123' and column2 like 'df%'
     * @param orders this is order by clause of sql query
     * @param startRowPosition start row postion, set 0 to disable
     * @param maxResult max result of row, set 0 to disable
     * @return List of entity
     * @throws Exception
     */
    @SuppressWarnings("static-access")
    public List<T> getBySQLQuery(String where, String[] orders, int startRowPosition, int maxResult) throws Exception {
        List<T> list = null;

        // get all no set maxresult
        list = getBySQLQuery(where, orders, 0);


        if (startRowPosition < 1) {
            startRowPosition = 1;
        }

        if (maxResult < 1) {
            maxResult = list.size();
        }

        // get all row from start position
        List<T> listTemp = new ArrayList();
        maxResult += startRowPosition;

        for (int i = startRowPosition; i < list.size() && i < maxResult; i++) {
            listTemp.add(list.get(i));
        }

        return listTemp;
    }
}
