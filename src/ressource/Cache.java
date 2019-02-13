/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton service to get a ressource from the cache OR web from a url
 * @author Adrien
 */
public class Cache
{
    private static Cache instance = null;
    
    private CsvRepository db;
    
    private Cache() throws SQLException, IOException {
    	db = new CsvRepository("resources/db_cache.csv");
    }
    
    public InputStream getStreamFromURL(URL url) throws FileNotFoundException { //TODO
        //first, check the database -> appropriate reccord
    	int rowid = db.getRowIndexForColumnIndex("url", url.toString());
System.out.println("URL found:" + url);
    	
        //if record found, 
        throw new FileNotFoundException();
    }
    public InputStream saveFile(URL url) {
    	InputStream ret = null;
    	HttpURLConnection connection = null;
    	try {
//    		ret = url.openStream();
    		connection = (HttpURLConnection) url.openConnection();
    	    connection.setRequestMethod("GET");
			ret = url.openStream();
			
			//if there is some content, should it be saved in the cache?
			if (ret != null) {
				Map<String, List<String>> headers = connection.getHeaderFields();
				for (String key : headers.keySet())
					for (String value : headers.get(key))
						System.out.println("key - " + key + " | value - " + value);
							
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return ret;
    }
    
    
    public synchronized static Cache instance() throws IOException {
        if (instance == null)
            try {
                instance = new Cache();
        } catch (SQLException ex) {
            Logger.getLogger(Cache.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
}
