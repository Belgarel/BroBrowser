package com.mycompany.javabrowser;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ressource.RessourceManager;
import ressource.RessourceNotFoundException;

public class TransformClick implements EventHandler<ActionEvent> {
	
	private ClientPanel cPanel;
	
	public TransformClick(ClientPanel cPanel) {
		this.cPanel = cPanel;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
    	try {
    		// Get the url of the navigation bar
			URL url = new URL(this.cPanel.getURL());
			// Get the html text of the page and launch the dom interpertor
	        InputStream is = RessourceManager.instance().getRessource(url);
	        this.cPanel.DOMInterpretor(RessourceManager.getFileContent(is));
		} catch (MalformedURLException | RessourceNotFoundException e) {
			// if there is a problem, pop an alert
			e.printStackTrace();
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Explorer");
			alert.setHeaderText(null);
			alert.setContentText(e.getMessage());

			alert.showAndWait();
		}
    	/*
		// Html content
		String html = this.cPanel.receivedBasicText.getText();
		// Create an array to create the dom of the page
		ArrayList<Tag> tags = new ArrayList<Tag>();
		while(html.length() > 0) {
			// index du début de la première balise
			int firstOpen = html.indexOf("<");
			// index de fin de la première balise
			int lastOpen = html.indexOf(">");
			
			if(firstOpen != -1 && lastOpen != -1) {
				// séparation du premier tag dans une variable
				String firstTag = html.substring(firstOpen, lastOpen+1);
				// Récupération du tag de fermeture
				String tagClose = "";
				// Récupération du nom du tag d'ouverture en enlevant tout les arguments (style, class, ...)
				// pour écrire le tag de fermeture à trouver
				if(firstTag.contains(" "))
					tagClose = "</" + firstTag.substring(1, firstTag.indexOf(" ")) + ">";
				else
					tagClose = "</" + firstTag.substring(1, firstTag.length()-1) + ">";
				// Parcours du dom pour trouver le tag de fermeture correspondant au tag d'ouverture
				int nextIndexOpen = html.indexOf("<", firstOpen+1);
				int nextIndexClose = html.indexOf("</", firstOpen+1);
				
				int cpt = 0;
				int domLevel = 0;
				boolean validTag = false;
				while(cpt < 1 && !validTag) {
					// Si le prochain index de balise d'ouverture est égal à la prochaine balise de fermeture,
					// cela veut dire que la prochaine balise est la fermeture recherchée
					System.out.println(nextIndexOpen + " - " + nextIndexClose);
					if(nextIndexOpen == nextIndexClose) {
						System.out.println("Sa passe ici 1");
						// Verif que l'on soit au bout niveau du dom ( niveau 0 )
						if(domLevel == 0) {
							System.out.println("Sa passe ici 2 " + nextIndexClose);
							// Verif que le tag close soit bien le bon tag
							String tagCloseVerif = html.substring(nextIndexClose, html.indexOf(">", nextIndexClose)+1);
							if(tagCloseVerif.equals(tagClose))
								validTag = true;
						} else {
							System.out.println("Sa passe ici 3");
							// Sinon on passe ce tag et on va au prochain tout en décrémentant un niveau
							nextIndexOpen = html.indexOf("<", nextIndexOpen+1);
							nextIndexClose = html.indexOf("</", nextIndexClose+1);
							domLevel--;
						}
					} else if(nextIndexOpen < nextIndexClose) {
						System.out.println("Sa passe ici 4");
						// Dans ce cas, la balise qui vient d'être trouvée est une autre balise d'ouverture, donc il
						// va falloir passer à la prochaine balise car ce n'est pas la bonne
						nextIndexOpen = html.indexOf("<", nextIndexOpen);
						nextIndexClose = html.indexOf("</", nextIndexClose);
						domLevel++;
					}
					System.out.println(domLevel + " - " + nextIndexOpen + " - " + nextIndexClose);
					System.out.flush();
					cpt++;
				}
				
				// Récup du contenu html entre les 2 balises
				String content = html.substring(lastOpen+1, nextIndexClose);
				Tag tag = new Tag(firstTag.substring(1, firstTag.length()-1), "", content);
				tags.add(tag);
				html = content;
			} else
				html = "";
		}
		
		for(Tag t : tags) {
			Label l = new Label(t.getContent());
			this.cPanel.page.getChildren().add(l);
		}
				*/
	}
}
