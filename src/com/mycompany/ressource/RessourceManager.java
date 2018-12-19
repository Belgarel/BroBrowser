/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ressource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class RessourceManager {
    private static RessourceManager instance;
    
    public InputStream getRessource(URL url) throws RessourceNotFoundException {
        InputStream ret = null;

        //First, check that the resource is not already in the cache
        try {
            System.out.println("Searching file " + url + "in cache.");
            ret = Cache.instance().getStreamFromURL(url);
        } catch (FileNotFoundException ex) {
            ret = null;
            System.out.println("File " + url + " not found in cache.");
        }
        
        if (ret == null) //then, if it was not found, go fetch it.
        {
            try {
                ret = url.openStream();
            } catch (IOException ex) {
                System.out.println("Error: RessourceManager > getRessource > IOException " + ex.getMessage());
                ret = null;
            }
            if (ret == null) //then, if the file still was not found, abort
                throw new RessourceNotFoundException();
            
            //if the find was found, send it to the cache for treatment
            ret = Cache.instance().saveFile(ret, url);
        }
        return ret;
    }
    
    public static String getFileContent(InputStream stream) {
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(isr);
        String ret = "";
        try {
            String line = br.readLine();
            while (line != null) {
                ret = ret.concat(line + "\n");
                line = br.readLine();
            }
        } catch (IOException ex) {
            System.out.println("IOException: RessourceManager > getFileContent, stream: " + stream);
        }
        return ret;
    }
    
    public synchronized static RessourceManager instance() {
        if (instance == null)
            instance = new RessourceManager();
        return instance;
    }
}
