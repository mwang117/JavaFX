package unilim.info.ihm.tp5.exo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class HereWeGoApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
        // BorderPane
        BorderPane root = new BorderPane();

        // Image de fond
        Image backgroundImage = new Image("file:///D:/BUT1/R2_01/JAVAFX/R202_TP5/src/unilim/info/ihm/tp5/exo3/niveau.jpg");
        BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
        Background backgroundPane = new Background(background);
        root.setBackground(backgroundPane);

        // Image Mario
        Image ImgMario = new Image("file:///D:/BUT1/R2_01/JAVAFX/R202_TP5/src/unilim/info/ihm/tp5/exo3/droite.png");
        ImageView ImgVMario = new ImageView(ImgMario);

        // Position et Taille de l'image Mario
        ImgVMario.setX(14);
        ImgVMario.setY(530);
        ImgVMario.setFitWidth(20);
        ImgVMario.setFitHeight(30);
        root.getChildren().add(ImgVMario);

        // Création de la classe MoveMarioController avec l'ImageView de Mario en argument
        MoveMarioController controller = new MoveMarioController(ImgVMario);

        // Création de la scène
        Scene scene = new Scene(root, 1200, 622);

        // Ajout MoveMarioController à scène pour le clavier
        scene.setOnKeyPressed(controller);
        
        // Affecter la scène à la fenêtre
        primaryStage.setScene(scene);

        // Empêcher de modifier la taille
        primaryStage.setResizable(false);

        // Titre de la scène
        primaryStage.setTitle("Here we go");

        // Afficher la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
