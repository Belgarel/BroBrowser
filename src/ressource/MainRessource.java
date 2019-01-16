package ressource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainRessource {
    
    public static void main (String args[]) throws RessourceNotFoundException, RessourceNotFoundException, IOException {
//        URL url = new URL("http://lolololol.com/testfile.html");
//        Cache.instance().getStringFromURL(url);
    	URL url = new URL("https://lorest.github.io/");
        InputStream is = RessourceManager.instance().getRessource(url);
        System.out.println(RessourceManager.getFileContent(is));
        System.out.println("url protocol: " + url.getProtocol());
        System.out.println("url host: " + url.getHost());
        System.out.println("url port: " + url.getPort());
        System.out.println("url filename: " + url.getFile());
    }

}
