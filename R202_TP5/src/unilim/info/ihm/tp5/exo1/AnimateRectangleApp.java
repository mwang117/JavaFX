package unilim.info.ihm.tp5.exo1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AnimateRectangleApp extends Application {

    private Rectangle rect;
    private boolean movingRight = true;
    
    private Button btngauche;

    @Override
    public void start(Stage primaryStage) throws Exception {
        rect = new Rectangle(50, 50, 150, 100);
        rect.setFill(Color.BLUE);
        
        //bouton gauche
        this.btngauche = new Button("Reset");
        btngauche.setOnAction(new EventHandler<ActionEvent>() {
        	
            @Override
            public void handle(ActionEvent event) {
                rect.setX(50);
                movingRight = true;
            }
        });
        
        // Noeud racine
        Group root = new Group();
        root.getChildren().addAll(rect, btngauche);

        // Création de la scène
        Scene scene = new Scene(root, 600, 200);
        scene.setFill(Color.LIGHTGREEN);

        // Affecter la scène à la fenêtre
        primaryStage.setScene(scene);

        // Empêcher de modifier la taille
        primaryStage.setResizable(false);

        // Titre de la scène
        primaryStage.setTitle("Animation d'un rectangle");

        // Afficher la fenêtre
        primaryStage.show();

        // Démarrer l'animation avec AnimationTimer
        startAnimation();
    }

    private void startAnimation() {

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (movingRight) {
                    rect.setX(rect.getX() + 2);
                    if (rect.getX() + rect.getWidth() >= 400) {
                        movingRight = false;
                    }
                }
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}