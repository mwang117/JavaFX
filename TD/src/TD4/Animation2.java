package TD4;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle rect = new Rectangle(50, 50, 100, 100);
        rect.setFill(Color.BLUE);

        Transition transition1 = creerTranslateTransition(rect);
        Transition transition2 = creerFadeTransition(rect);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(transition1, transition2);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        //noeaud racine
        Group root = new Group();
        root.getChildren().add(rect);

        //Création de la scène
        Scene scene = new Scene(root, 600, 200);
        scene.setFill(Color.LIGHTGREEN);

        //affecter la scene à la fenetre
        primaryStage.setScene(scene);

        //empecher de modifier la taille
        primaryStage.setResizable(false);

        //titre de la scene
        primaryStage.setTitle("Application d'un Rectangle avec Animation");

        //afficher la fenetre
        primaryStage.show();

    }

    private Transition creerTranslateTransition(Rectangle rect) {
    	//aller vers la droite
        TranslateTransition ttRight = new TranslateTransition(Duration.seconds(2), rect);
        ttRight.setInterpolator(Interpolator.EASE_OUT);
        ttRight.setByX(400);

        //aller vers la gauche
        TranslateTransition ttLeft = new TranslateTransition(Duration.seconds(2), rect);
        ttLeft.setInterpolator(Interpolator.EASE_OUT);
        ttLeft.setByX(-400);

        // Création d'une séquence de transitions pour aller à droite puis à gauche
        SequentialTransition sequence = new SequentialTransition(ttRight, ttLeft);
        return sequence;
    }

    private Transition creerFadeTransition(Rectangle rect) {
    	//opacité 
        FadeTransition ft = new FadeTransition(Duration.seconds(4), rect);
        ft.setFromValue(1.0);
        ft.setToValue(1.0);
        return ft;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}