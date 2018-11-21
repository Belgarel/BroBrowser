/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javabrowser.Cache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Singleton service to get a ressource from the cache OR web from a url
 * @author Adrien
 */
public class Cache
{
    private static Cache instance;
    
    /**
     * Returns a string from a ressource file, wether it is on the cache or distant
     * @param url the url where the the ressource is to be found (if it is not in the cache)
     * @return a string representing the content of the file
     * @throws FileNotFoundException The file was not in the cache, even after fetching it.
     * @throws com.mycompany.javabrowser.Cache.RessourceNotFoundException the file could not be fetched
     */
    public String getStringFromURL(URL url) throws FileNotFoundException, RessourceNotFoundException {
        String ret = "";
        //for now, I just want to open a file, regardless of its location
        String fileLocation = url.getFile(); //TODO navigate directories depending on the parsing of the url
        try {
            ret = getStringFromCache(fileLocation);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: Cache > getStringFromURL, url: " + url);
            System.out.println("Fetching file from url: " + url);
            if (WebFetcher.instance().fetchFrom(url))
                ret = getStringFromCache(fileLocation);
            else
                throw new RessourceNotFoundException();
        }
        return ret;
    }
    public String getStringFromCache(String filePath) throws FileNotFoundException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(filePath);
        if (is == null)
            throw new FileNotFoundException(filePath + " not found");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String ret = "";
        try {
            String line = br.readLine();
            ret = ret.concat(line);
        } catch (IOException ex) {
            System.out.println("IOException: Cache > getStringFromCache, filePath: " + filePath);
        }
        return ret;
    }
    
    
    public synchronized static Cache instance() {
        if (instance != null)
            instance = new Cache();
        return instance;
    }
}
