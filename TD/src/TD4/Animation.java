package TD4;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Animation<Animationconfiner> extends Application implements EventHandler<MouseEvent> {

	//Déclaration
	private Integer nbFrame = 0;
	private Label lblnbFrame();
	
	public Animation(Rectangle rect) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		//noeaud racine 
		Group root = new Group();
		root.getChildren().add(rect);
		
		Rectangle rect = new Rectangle(50, 50, 100, 100);
		rect.setFill(Color.BLUE);
		
		Animation anim = new Animation(rect);
		anim.start(rect);
		
		//Création de la scène
		Scene scene = new Scene(root, 600, 200);
		scene.setFill(Color.LIGHTGREEN);
		
		//affecter la scene à la fenetre
		primaryStage.setScene(scene);
		
		//empecher de modifier la taille
		primaryStage.setTitle("Application d'un Rectangle avec Animation");
		
		//afficher la fenetre
		primaryStage.show();
		
	}
	
	
	@Override
	public void handle(MouseEvent arg0) {
	
		
	}
	
	private AnimationTimer animerRecetangle(Rectangle rect) {
		Animationconfiner anim = new Animationconfiner() {
			public void handle(long row) {
				nbFrame();
				System.out.println(nbFrame);
				
				if(rect.opacityProperty().get() < 400) { 
					rect.opacityProperty().set(rect.opacityProperty).get()
				}
			};
		};
		return anim;
		
	}

	private void creerLabelnbFrame() {
		Label lblTitreFrame = new Label();
		lblnbFrame = new Label("0");
		
		lblTitreFrame.setFont(null);
		
		HBox ligne = new HBox(5, lblTitreFrame, lblnbFrame);
		return ligne;
	}


	public static void main(String[] args) {
        Application.launch(args);
    }

}
