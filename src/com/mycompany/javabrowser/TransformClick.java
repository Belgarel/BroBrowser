package com.mycompany.javabrowser;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TransformClick implements EventHandler<ActionEvent> {
	
	private ClientPanel cPanel;
	
	public TransformClick(ClientPanel cPanel) {
		this.cPanel = cPanel;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		// Html content
		String html = this.cPanel.receivedBasicText.getText();
		// Create an array to create the dom of the page
		ArrayList<Tag> tags = new ArrayList<Tag>();
		while(html.length() > 0) {
			// index du début de la première balise
			int firstOpen = html.indexOf("<");
			// index de fin de la première balise
			int lastOpen = html.indexOf(">");
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
			int nextIndexOpen = html.indexOf("<", firstOpen);
			int nextIndexClose = html.indexOf("</", firstOpen);
			
			boolean validTag = false;
			while(!validTag) {
				// Si le prochain index de balise d'ouverture est égal à la prochaine balise de fermeture,
				// cela veut dire que la prochaine
				if(nextIndexOpen == nextIndexClose) {
					
				}
			}
			int indexClose = html.indexOf(tagClose);
			String content = html.substring(lastOpen+1, indexClose);
			Tag tag = new Tag(firstTag.substring(1, firstTag.length()-1), "", content);
			tags.add(tag);
			System.out.println(content + "\n");
			html = content;
		}
	}
}
