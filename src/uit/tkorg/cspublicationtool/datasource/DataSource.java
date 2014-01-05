/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uit.tkorg.cspublicationtool.datasource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import uit.tkorg.cspublicationtool.main.CSPublicationSAXEventHandler;

/**
 *
 * @author Dao
 */
public class DataSource {
    private HashMap<Integer,Integer> hashCodeData = new HashMap<Integer, Integer>();
    private Integer currId = 0;
    
    public void loadData(String path)        
    {
        try{
            FileReader file = new FileReader(path);
            BufferedReader textReader = new BufferedReader(file);
            String line = textReader.readLine(); //ignore 1st line
            String[] tokens;
            Integer id;
            Integer hashCode;
            while ((line = textReader.readLine()) != null)
            {
                tokens = line.split("\t");
                if (tokens.length == 2)
                {
                    id = Integer.valueOf(tokens[0]);
                    hashCode = tokens[1].hashCode();
                    currId = id;
                    hashCodeData.put(hashCode, id);
                }
            }
        }catch(Exception ex)
        {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Boolean isExisted(String value)
    {
        if (hashCodeData.get(value.hashCode()) != null)
            return true;
        return false;
    }
    
    public Integer getId(String value)
    {
        Integer id = hashCodeData.get(value.hashCode());
        if (id != null)
            return id;
        return -1;
    }
    
    public Integer addNewData(String value)
    {
        Integer hashCode = value.hashCode();
        currId++;
        hashCodeData.put(hashCode, currId);
        return currId;
    }
}
