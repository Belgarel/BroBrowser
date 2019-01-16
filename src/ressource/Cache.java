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
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton service to get a ressource from the cache OR web from a url
 * @author Adrien
 */
public class Cache
{
    private static Cache instance = null;
    
    private Cache() throws SQLException {
    }
    
    public InputStream getStreamFromURL(URL url) throws FileNotFoundException { //TODO
        //first, check the database -> appropriate reccord
        //if record found, 
        throw new FileNotFoundException();
    }
    public InputStream saveFile(InputStream file, URL url) {
    	//TODO
    	return file;
    }
    
    
    public synchronized static Cache instance() {
        if (instance == null)
            try {
                instance = new Cache();
        } catch (SQLException ex) {
            Logger.getLogger(Cache.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
}
