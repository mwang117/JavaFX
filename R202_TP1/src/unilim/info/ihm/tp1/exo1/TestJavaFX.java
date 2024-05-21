package unilim.info.ihm.tp1.exo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestJavaFX extends Application {

	public static void main(String[] args) {

		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		
		Button btn = new Button();
		btn.setText("Valider");
		
		root.getChildren().add(btn);
		
		
		Scene scene = new Scene(root, 600, 250);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Première fenêtre");
		primaryStage.show();
		
	}

}
