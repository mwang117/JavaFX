package unilim.info.ihm.tp4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LoginAppSb extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("vue/LoginForm.fxml"));
        BorderPane root = loader.load();

        //Créer une scène avec la racine obtenue
        Scene scene = new Scene(root);

        //Configurer la scène sur la fenêtre principale
        primaryStage.setScene(scene);

        //Afficher la fenêtre principale
        primaryStage.show();
    }
	
    public static void main(String[] args) {
        Application.launch(args);
    }

}


