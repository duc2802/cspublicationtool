/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uit.tkorg.cspublicationtool.datasource;

import java.util.HashMap;

/**
 *
 * @author Dao
 */
public enum DataSourceManager {
    INSTANCE;
    
    private HashMap<DataType,DataSource> data = new HashMap<DataType, DataSource>();
    
    public void loadDataFromSource(DataType dataType, String path)
    {
        DataSource dataSource = new DataSource();
        dataSource.loadData(path);
        
        if (data.containsKey(dataType))
        {
            data.remove(dataType);
        }
        
        data.put(dataType, dataSource);
    }
    
    public Boolean isExisted(DataType dataType, String value)
    {
        DataSource dataSource = data.get(dataType);
        if (dataSource != null)
        {
            return dataSource.isExisted(value);
        }
        return false;
    }
    
    public Integer getId(DataType dataType, String value)
    {
        DataSource dataSource = data.get(dataType);
        if (dataSource != null)
        {
            return dataSource.getId(value);
        }
        return -1;
    }
    
    public Integer addNewData(DataType dataType, String value)
    {
        DataSource dataSource = data.get(dataType);
        if (dataSource != null)
        {
            return dataSource.addNewData(value);
        }
        return -1;
    }
}
