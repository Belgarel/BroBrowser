package ressource;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class MainRessource {
    
    public static void main (String args[]) throws MalformedURLException, FileNotFoundException, RessourceNotFoundException, RessourceNotFoundException {
//        URL url = new URL("http://lolololol.com/testfile.html");
//        Cache.instance().getStringFromURL(url);
    	URL url = new URL("https://stackoverflow.com/questions/921262/how-to-download-and-save-a-file-from-internet-using-java");
        InputStream is = RessourceManager.instance().getRessource(url);
        System.out.println(RessourceManager.getFileContent(is));
        System.out.println("url protocol: " + url.getProtocol());
        System.out.println("url host: " + url.getHost());
        System.out.println("url port: " + url.getPort());
        System.out.println("url filename: " + url.getFile());
    }

}
