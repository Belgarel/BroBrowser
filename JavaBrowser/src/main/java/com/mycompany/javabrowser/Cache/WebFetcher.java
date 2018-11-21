/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.javabrowser.Cache;

import java.net.URL;

/**
 *
 * @author p1514527
 */
public class WebFetcher {
    private static WebFetcher instance;
    
    public boolean fetchFrom(URL url) {
        return false; //TODO. For now, the ressource should not be fetched
    }
    
    public synchronized static WebFetcher instance() {
        if (instance != null)
            instance = new WebFetcher();
        return instance;
    }
    
}
