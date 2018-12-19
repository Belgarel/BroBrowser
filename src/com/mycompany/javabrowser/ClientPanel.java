package com.mycompany.javabrowser;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ClientPanel extends Parent {

	public TextArea receivedBasicText;
	public Button transformBtn;
	public HBox page;
	
	public ClientPanel(String html) {
		this.receivedBasicText = new TextArea(html);
		this.receivedBasicText.setLayoutX(20);
		this.receivedBasicText.setLayoutY(20);
		this.receivedBasicText.setPrefWidth(560);
		this.receivedBasicText.setPrefHeight(200);
		this.getChildren().add(this.receivedBasicText);
		this.transformBtn = new Button("Transform");
		this.transformBtn.setOnAction(new TransformClick(this ));
		this.transformBtn.setLayoutX(500);
		this.transformBtn.setLayoutY(225);
		this.transformBtn.setPrefWidth(80);
		this.transformBtn.setPrefHeight(20);
		this.getChildren().add(this.transformBtn);
		this.page = new HBox();
		this.page.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.page.setLayoutX(20);
		this.page.setLayoutY(255);
		this.page.setPrefWidth(560);
		this.page.setPrefHeight(350);
		this.getChildren().add(this.page);
	}
}
