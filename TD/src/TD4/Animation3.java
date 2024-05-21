package TD4;

import javafx.animation.Interpolator;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Animation3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		StackPane root = new StackPane();
		
		Image img = new Image(getClass().getResource("").toExternalForm());
		BackgroundImage backgroundImage = new BackgroundImage(
				img,
				BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER,
				new BackgroundSize(1, 1, true, true, true, false)
		);
		Background bg = new Background(backgroundImage);
		root.setBackground(bg);
		
		//charger le personnage 
		ImageView perso = chargerPersonnage();
		
		Timeline timeline = new Timeline();
		
		root.getChildren().add(perso);
		
		//Création de la scène
		Scene scene = new Scene(root, 800, 600);
		
		//affecter la scene à la fenetre
		primaryStage.setScene(scene);
		
		//empecher de modifier la taille
		primaryStage.setResizable(false);
		
		//titre de la scene
		primaryStage.setTitle("Application d'un personnage");
		
		//afficher la fenetre
		primaryStage.show();
		
	}
	
	private ImageView chargerPersonnage() {
		Image img = new Image(getClass().getResource("").toExternalForm(
				80, 80, true, false, false));
		ImageView imageView = new ImageView(img);
		return imageView;
	}
	
	private Timeline animerPersonnage(ImageView perso) {
		
		KeyValue kv = new KeyValue(
				perso.translateXProperty(), 
				perso.translateXProperty().get() + 250,
				Interpolator.EASE_BOTH
		);
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().add(kv);
		
		return timeline;
	}
	
	public static void main(String[] args) {
        Application.launch(args);
    }

}
