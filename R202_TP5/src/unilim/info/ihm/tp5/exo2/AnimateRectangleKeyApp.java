package unilim.info.ihm.tp5.exo2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AnimateRectangleKeyApp extends Application {

    private Rectangle rect;

    @Override
    public void start(Stage primaryStage) throws Exception {
        rect = new Rectangle(50, 50, 150, 100);
        rect.setFill(Color.BLUE);

        // Noeud racine
        Group root = new Group();
        root.getChildren().addAll(rect);

        // Création de la scène
        Scene scene = new Scene(root, 600, 200);
        scene.setFill(Color.LIGHTGREEN);

        EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.Q && rect.getX() > 50) {
                    rect.setX(rect.getX() - 10);
                } else if (event.getCode() == KeyCode.D && rect.getX() < 400) {
                    rect.setX(rect.getX() + 10);
                }
            }
        };
        scene.setOnKeyPressed(keyEventHandler);

        // Affecter la scène à la fenêtre
        primaryStage.setScene(scene);

        // Empêcher de modifier la taille
        primaryStage.setResizable(false);

        // Titre de la scène
        primaryStage.setTitle("Animation d'un rectangle avec clavier");

        // Afficher la fenêtre
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}