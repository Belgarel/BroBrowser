package com.mycompany.javabrowser;


import com.mycompany.javabrowser.workclass.DOMElement;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ClientPanel extends Parent {

	private DOMElement DOMElement;
	
	private TextField urlText;
	private Button searchBtn;
	private HBox page;
	
	public ClientPanel() {
		this.DOMElement = new DOMElement();
		
		// Add Basic graphics elements to the page
		this.urlText = new TextField();
		this.urlText.setLayoutX(20);
		this.urlText.setLayoutY(20);
		this.urlText.setPrefWidth(560);
		this.getChildren().add(this.urlText);
		this.searchBtn = new Button("Search");
		this.searchBtn.setOnAction(new TransformClick(this));
		this.searchBtn.setLayoutX(500);
		this.searchBtn.setLayoutY(225);
		this.searchBtn.setPrefWidth(80);
		this.searchBtn.setPrefHeight(20);
		this.getChildren().add(this.searchBtn);
		this.page = new HBox();
		this.page.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.page.setLayoutX(20);
		this.page.setLayoutY(255);
		this.page.setPrefWidth(560);
		this.page.setPrefHeight(350);
		this.getChildren().add(this.page);
	}
	
	public String getURL() {
		return this.urlText.getText();
	}
	
	public void DOMInterpretor(String html) {
		// Transform html text in class objects to create the dom to simplify the navigation
		this.DOMElement.transformHTMLToDOM(html);
	}
}
