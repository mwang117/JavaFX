package unilim.info.ihm.tp3;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Optional;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application implements EventHandler<MouseEvent> {

    //Déclaration partie gauche
    private Label lblTitreHautGauche;
    private Label lblNom;
    private TextField tfdNom;
    private Label lblType;
    private TextField tfdType;
    private Label lblPrix;
    private TextField tfdPrix;
    private Label lblQuantité;
    private TextField tfdQuantité;
    private Label lblImage;
    private Label lblMsgImage;
    private Button btnPhoto;
    private Button btnSauvegarde;
    private Label lblMsgErreurNom;
    private Label lblMsgErreurType;
    private Label lblMsgErreurPrix;
    private Label lblMsgErreurQuantité;
        
    private ImageView imgV;
    private Stage maFenêtre;
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        //partie Formulaire
        this.lblTitreHautGauche = new Label();
        this.lblTitreHautGauche.setText("Sauvegarde de condiment");
        this.lblTitreHautGauche.setAlignment(Pos.CENTER);
        
        this.btnSauvegarde = new Button("Sauvegarde");
        this.btnPhoto = new Button("Photo");
        
        this.lblNom = new  Label("Nom * :");
        this.tfdNom = new TextField();
        
        this.lblPrix = new  Label("Prix * :");
        this.tfdPrix = new TextField();
        
        this.lblType = new  Label("Type * :");
        this.tfdType = new TextField();
        
        this.lblQuantité = new  Label("Quantité * :");
        this.tfdQuantité = new TextField();
        
        this.lblImage = new  Label("Image * :");
        this.lblMsgImage = new Label();
        
        this.lblMsgErreurNom = new Label();
        this.lblMsgErreurNom.setTextFill(Color.RED);
        this.lblMsgErreurNom.setFont(Font.font(null, FontWeight.BOLD, -1));
        
        this.lblMsgErreurPrix = new Label();
        this.lblMsgErreurPrix.setTextFill(Color.RED);
        this.lblMsgErreurPrix.setFont(Font.font(null, FontWeight.BOLD, -1));
        
        this.lblMsgErreurType = new Label();
        this.lblMsgErreurType.setTextFill(Color.RED);
        this.lblMsgErreurType.setFont(Font.font(null, FontWeight.BOLD, -1));
        
        this.lblMsgErreurQuantité = new Label();
        this.lblMsgErreurQuantité.setTextFill(Color.RED);
        this.lblMsgErreurQuantité.setFont(Font.font(null, FontWeight.BOLD, -1));
        
        this.btnPhoto = new Button();
        this.btnPhoto.setText("Photo");
        btnPhoto.setPrefWidth(250);
        
        this.btnSauvegarde = new Button();
        this.btnSauvegarde.setText("Sauvegarder");
        btnSauvegarde.setPrefWidth(250);
        
        // Définition des événements de clic pour les boutons
        btnPhoto.setOnMouseClicked(this);
        btnSauvegarde.setOnMouseClicked(this);
        
        //partie dessin
        Rectangle rect = new Rectangle(50, 50, 100, 100);
        rect.setFill(Color.BLUE);
        
        //Création d'une grille gauche
        GridPane grid = new GridPane();
        grid.add(this.lblTitreHautGauche, 0, 0);
        grid.add(this.lblNom, 0, 1);
        grid.add(this.tfdNom, 0, 2);
        grid.add(this.lblMsgErreurNom, 0, 3);
        grid.add(this.lblType, 0, 4);
        grid.add(this.tfdType, 0, 5);
        grid.add(this.lblMsgErreurType, 0, 6);
        grid.add(this.lblPrix, 0,7);
        grid.add(this.tfdPrix, 0, 8);
        grid.add(this.lblMsgErreurPrix, 0, 9);
        grid.add(this.lblQuantité, 0, 10);
        grid.add(this.tfdQuantité, 0, 11);
        grid.add(this.lblMsgErreurQuantité, 0, 12);
        grid.add(this.lblImage, 0, 13);
        grid.add(this.lblMsgImage, 0, 14);
        grid.add(this.btnPhoto, 0, 15);
        grid.add(this.btnSauvegarde, 0, 16);
        grid.setPrefWidth(250);
        GridPane.setHalignment(this.lblTitreHautGauche, HPos.CENTER);
        
        //VBox left
        VBox leftBox = new VBox();
        leftBox.setPadding(new Insets(10));
        leftBox.getChildren().addAll(grid);
        leftBox.setSpacing(10);
        
        //noeaud racine
        Group group = new Group(rect);

        //Création d'un noeud racine
        BorderPane root = new BorderPane();
        BorderPane.setMargin(leftBox, new Insets(0, 0, 0, 10));
        BorderPane.setMargin(group, new Insets(10)); 

        root.setLeft(leftBox);
        root.setCenter(group);
        
        //transition
        Transition transition1 = creerTranslateTransition(group);
        Transition transition2 = creerFadeTransition(rect);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(transition1, transition2);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        
        //Création de la scène
        Scene scene = new Scene(root, 1500, 600);

        //affecter la scene à la fenetre
        primaryStage.setScene(scene);

        //empecher de modifier la taille
        primaryStage.setResizable(false);

        //titre de la scene
        primaryStage.setTitle("Application Formulaire et d'un Rectangle avec Animation");

        //afficher la fenetre
        primaryStage.show();

    }

    private Transition creerTranslateTransition(Group group) {
        // aller vers la droite
        TranslateTransition ttRight = new TranslateTransition(Duration.seconds(2), group);
        ttRight.setInterpolator(Interpolator.EASE_OUT);
        ttRight.setByX(400);

        // aller vers la gauche
        TranslateTransition ttLeft = new TranslateTransition(Duration.seconds(2), group);
        ttLeft.setInterpolator(Interpolator.EASE_OUT);
        ttLeft.setByX(-400);

        // Création d'une séquence de transitions pour aller à droite puis à gauche
        SequentialTransition sequence = new SequentialTransition(ttRight, ttLeft);
        return sequence;
    }

    private Transition creerFadeTransition(Rectangle rect) {
        // opacité 
        FadeTransition ft = new FadeTransition(Duration.seconds(4), rect);
        ft.setFromValue(1.0);
        ft.setToValue(1.0);
        return ft;
    }
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == btnSauvegarde) {
            if (tfdNom.getText().isEmpty() || tfdPrix.getText().isEmpty() || tfdType.getText().isEmpty() || tfdQuantité.getText().isEmpty()) {
                lblMsgErreurNom.setText("");
                lblMsgErreurType.setText("");
                lblMsgErreurPrix.setText("");
                lblMsgErreurQuantité.setText("");

                if (tfdNom.getText().trim().isEmpty()) {
                    lblMsgErreurNom.setText("Veuillez saisir le nom");
                }
                if (tfdType.getText().trim().isEmpty()) {
                    lblMsgErreurType.setText("Veuillez saisir le type");
                }
                if (tfdPrix.getText().trim().isEmpty()) {
                    lblMsgErreurPrix.setText("Veuillez saisir le prix");
                }
                if (tfdQuantité.getText().trim().isEmpty()) {
                    lblMsgErreurQuantité.setText("Veuillez saisir la quantité");
                }
                
                Alert dialog = new Alert(AlertType.ERROR);
                dialog.setTitle("Erreur de saisie");
                dialog.setHeaderText(null);
                dialog.setContentText("Votre saisie est vide, que voulez-vous faire ?");

                ButtonType btnQuitter = new ButtonType("Quitter");
                ButtonType btnExemple = new ButtonType("Charger un exemple par défaut");
                ButtonType btnRevenir = new ButtonType("Revenir à la saisie");

                dialog.getButtonTypes().setAll(btnQuitter, btnExemple, btnRevenir);
                Optional<ButtonType> choix = dialog.showAndWait();
                if (choix.isPresent()) {
                    if (choix.get() == btnQuitter) {
                        Platform.exit();
                    } else if (choix.get() == btnExemple) {
                        tfdNom.setText("Doe");
                        tfdPrix.setText("10");
                        tfdType.setText("Epice");
                        tfdQuantité.setText("5");
                    }
                }
            }
            
        } else if (event.getSource() == btnPhoto) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Choisir une photo");

            File selectedFile = fileChooser.showOpenDialog(maFenêtre);
            if (selectedFile != null) {
                try {
                    Image img = new Image(selectedFile.toURI().toURL().toString(), 140, 140, true, false);
                    this.imgV.setImage(img); // Assurez-vous d'initialiser imgV
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}