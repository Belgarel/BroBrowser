package com.mycompany.javabrowser;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}
	
	public void start(Stage stage) throws Exception {
		ClientPanel clientPanel = new ClientPanel("<div><div>blablabla</div></div>");
		Group root = new Group();
		root.getChildren().add(clientPanel);
		Scene scene = new Scene(root, 600, 700);
		stage.setTitle("Parsing HTML/CSS");
		stage.setScene(scene);
		stage.show();
	}

}
