/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javabrowser;

import com.mycompany.javabrowser.Cache.Cache;
import com.mycompany.javabrowser.Cache.RessourceNotFoundException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Home
 */
public class JavaBrowser {
    
    public void main (String args[]) throws MalformedURLException, FileNotFoundException, RessourceNotFoundException, RessourceNotFoundException {
        URL url = new URL("http://lolololol.com/testfile.html");
        Cache.instance().getStringFromURL(url);
    }
    
}
