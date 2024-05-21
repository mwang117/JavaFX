package unilim.info.ihm.tp5.exo3;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class MoveMarioController implements EventHandler<KeyEvent> {

    private ImageView ImgVMario;
    private Image imgDroite;
    private Image imgGauche;
    private Image imgHaut;
    private Image imgBas;
    private boolean regardeDroite = true;

    public MoveMarioController(ImageView marioImageView) {
        this.ImgVMario = marioImageView;

        // Chargement des images
        imgDroite = new Image("file:///D:/BUT1/R2_01/JAVAFX/R202_TP5/src/unilim/info/ihm/tp5/exo3/droite.png");
        imgGauche = new Image("file:///D:/BUT1/R2_01/JAVAFX/R202_TP5/src/unilim/info/ihm/tp5/exo3/gauche.png");
        imgHaut = new Image("file:///D:/BUT1/R2_01/JAVAFX/R202_TP5/src/unilim/info/ihm/tp5/exo3/haut.png");
        imgBas = new Image("file:///D:/BUT1/R2_01/JAVAFX/R202_TP5/src/unilim/info/ihm/tp5/exo3/bas.png");
    }

    @Override
    public void handle(KeyEvent event) {
        // Déplacements en fonction du clavier
        switch (event.getCode()) {
            case Z:
                ImgVMario.setImage(imgHaut);
                break;
            case S:
                ImgVMario.setImage(imgBas);
                break;
            case Q:
            	if (ImgVMario.getX > 0) {
	                ImgVMario.setX(ImgVMario.getX() - 10);
	                ImgVMario.setImage(imgGauche);
	                regardeDroite = false;
            	}
                break;
            case D:
                ImgVMario.setX(ImgVMario.getX() + 10);
                ImgVMario.setImage(imgDroite);
                regardeDroite = true;
                break;
            case SPACE:
                if (regardeDroite) {
                    sautTransition(ImgVMario, true);
                } else {
                    sautTransition(ImgVMario, false);
                }
                break;
            default:
                // Ne rien faire pour d'autres touches
        }
    }

    private void sautTransition(ImageView ImgVMario, boolean versDroite) {
        TranslateTransition sautHaut = new TranslateTransition(Duration.seconds(0.50), ImgVMario);
        sautHaut.setByY(- 50);
        if (versDroite) {
            sautHaut.setByX(50);
        } else {
            sautHaut.setByX(-50);
        }

        TranslateTransition sautBas = new TranslateTransition(Duration.seconds(0.50), ImgVMario);
        sautBas.setByY(50);
        if (versDroite) {
            sautBas.setByX(50);
        } else {
            sautBas.setByX(-50);
        }

        sautHaut.setOnFinished(event -> sautBas.play());

        sautHaut.play();
    }
}
