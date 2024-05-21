package unilim.info.ihm.tp2.exo1;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FormInscriptionFX extends Application {
	
	private Label lblTitreHaut;
	private Label lblTitreHaut2;
	private Label lblCivilite;
	
	private ComboBox<String> cbbCivilite;
	private Label lblNom;
	private TextField tfdNom;
	private Label lblPrenom;
	private TextField tfdPrenom;
	private Label lblEmail;
	private TextField tfdEmail;
	
	private Label lblComfirmeEmail;
	private TextField tfdComfirmeEmail;
	
	private CheckBox cbCGU;
	
	private Button btnSouscrire;
	
	private Label lblMsgErreurNom;
	private Label lblMsgErreurPrenom;
	private Label lblMsgErreurEmail;
	private Label lblMsgErreurComfirme;
	private Label lblMsgErreurCGU;
	
	private Label lblInfosBas;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.lblTitreHaut = new Label();
		this.lblTitreHaut.setText("Souscrivez à notre université !");
		this.lblTitreHaut.setAlignment(Pos.CENTER);
		this.lblTitreHaut.setUnderline(true);
		this.lblTitreHaut.setMaxWidth(Double.MAX_VALUE);
		
		this.lblTitreHaut2 = new Label();
		this.lblTitreHaut2.setText("Bienvenue à notre newsletter, inscrivez-vous pour avoir des nouvelles !");
		this.lblTitreHaut2.setAlignment(Pos.CENTER);
		this.lblTitreHaut2.setMaxWidth(Double.MAX_VALUE);
		
		String civilite[] = {"M", "Mme", "Mlle"};
		
		this.lblCivilite = new Label("Civilité");
		this.cbbCivilite = new ComboBox<String>();
		this.cbbCivilite.setValue(civilite[0]);
		this.cbbCivilite.getItems().addAll(civilite);
		
		this.lblNom = new  Label("Nom");
		this.tfdNom = new TextField();
		
		this.lblPrenom = new  Label("Prénom");
		this.tfdPrenom = new TextField();
		
		this.lblEmail = new  Label("Email");
		this.tfdEmail = new TextField();
		
		this.lblComfirmeEmail = new  Label("Comfirmez votre email");
		this.tfdComfirmeEmail = new TextField();
		
		this.cbCGU = new CheckBox("J'accepte les conditions générales d'utilisation de la newesletter");
		
		this.lblMsgErreurNom = new Label();
		this.lblMsgErreurNom.setTextFill(Color.RED);
		this.lblMsgErreurNom.setFont(Font.font(null, FontWeight.BOLD, -1));
		
		this.lblMsgErreurPrenom = new Label();
		this.lblMsgErreurPrenom.setTextFill(Color.RED);
		this.lblMsgErreurPrenom.setFont(Font.font(null, FontWeight.BOLD, -1));
		
		this.lblMsgErreurEmail = new Label();
		this.lblMsgErreurEmail.setTextFill(Color.RED);
		this.lblMsgErreurEmail.setFont(Font.font(null, FontWeight.BOLD, -1));
		
		this.lblMsgErreurComfirme = new Label();
		this.lblMsgErreurComfirme.setTextFill(Color.RED);
		this.lblMsgErreurComfirme.setFont(Font.font(null, FontWeight.BOLD, -1));
		
		this.lblMsgErreurCGU = new Label();
		this.lblMsgErreurCGU.setTextFill(Color.RED);
		this.lblMsgErreurCGU.setFont(Font.font(null, FontWeight.BOLD, -1));
		
		this.btnSouscrire = new Button();
		this.btnSouscrire.setText("Souscrire");
		this.btnSouscrire.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
		        lblMsgErreurNom.setText("");
		        lblMsgErreurPrenom.setText("");
		        lblMsgErreurEmail.setText("");
		        lblMsgErreurComfirme.setText("");
		        lblMsgErreurCGU.setText("");
		        lblInfosBas.setText("");
				
				if (tfdNom.getText().trim().isEmpty()) {
		            lblMsgErreurNom.setText("Le nom est obligatoire");
		            lblInfosBas.setText("Utilisateur non inscrit");
		        }
		        if (tfdPrenom.getText().trim().isEmpty()) {
		            lblMsgErreurPrenom.setText("Le prénom est obligatoire");
		            lblInfosBas.setText("Utilisateur non inscrit");
		        }
		        if (tfdEmail.getText().trim().isEmpty()) {
		            lblMsgErreurEmail.setText("Le mail est obligatoire");
		            lblInfosBas.setText("Utilisateur non inscrit");
		        }
		        if (tfdComfirmeEmail.getText().trim().isEmpty()) {
		            lblMsgErreurComfirme.setText("La vérification du mail est obligatoire");
		            lblInfosBas.setText("Utilisateur non inscrit");
		        }
		        if (!cbCGU.isSelected()) {
		            lblMsgErreurCGU.setText("Il faut accepter les CGU");
		            lblInfosBas.setText("Utilisateur non inscrit");
		        }
		        if (lblMsgErreurNom.getText().isEmpty() && 
		            lblMsgErreurPrenom.getText().isEmpty() && 
		            lblMsgErreurEmail.getText().isEmpty() && 
		            lblMsgErreurComfirme.getText().isEmpty() && 
		            lblMsgErreurCGU.getText().isEmpty()) {
		        	
		            Date date = new Date();
		            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy 'a' HH:mm:ss");
		            lblInfosBas.setText(
		                    cbbCivilite.getValue() + " " + tfdNom.getText() + " " 
		                    + tfdPrenom.getText() + " s'est inscrit(e) le " + format.format(date)
		            );
		        }
			}
		});
		
		this.lblInfosBas = new Label();
		this.lblInfosBas.setAlignment(Pos.CENTER);
		this.lblInfosBas.setMaxWidth(Double.MAX_VALUE);
		
		//Création d'un noeud racine
		BorderPane root = new BorderPane();
		
		//Création d'une grille
		GridPane grid = new GridPane();
		grid.add(this.lblCivilite, 0, 0);
		grid.add(this.cbbCivilite, 0, 1);
		grid.add(this.lblNom, 0, 2);
		grid.add(this.tfdNom, 0, 3);
		grid.add(this.lblMsgErreurNom, 0, 4);
		grid.add(this.lblEmail, 0, 5);
		grid.add(this.tfdEmail, 0, 6);
		grid.add(this.lblMsgErreurEmail, 0, 7);
		grid.add(this.lblPrenom, 2, 2);
		grid.add(this.tfdPrenom, 2, 3);
		grid.add(this.lblMsgErreurPrenom, 2, 4);
		grid.add(this.lblComfirmeEmail, 2, 5);
		grid.add(this.tfdComfirmeEmail, 2, 6);
		grid.add(this.lblMsgErreurComfirme, 2, 7);
		
		grid.setHgap(10);
		grid.setVgap(10);
		
		//Création de la VBox
		VBox topBox = new VBox();
		topBox.setPadding(new Insets(10));
		topBox.getChildren().addAll(lblTitreHaut, lblTitreHaut2);
		topBox.setSpacing(10);
		
		VBox midBox = new VBox();
		midBox.setPadding(new Insets(10));
		midBox.getChildren().addAll(grid, cbCGU, lblMsgErreurCGU);
		midBox.setSpacing(10);
		
		VBox bottomBox = new VBox();
		bottomBox.getChildren().addAll(btnSouscrire, lblInfosBas);
		bottomBox.setAlignment(Pos.CENTER);
		
		root.setTop(topBox);
		BorderPane.setMargin(topBox, new Insets(0, 0, 10, 0));
		
		root.setCenter(midBox);
		BorderPane.setMargin(midBox, new Insets(0, 0, 0, 15));
		
		root.setBottom(bottomBox);
		BorderPane.setMargin(bottomBox, new Insets(15, 15, 15, 15));
		BorderPane.setAlignment(bottomBox, Pos.CENTER);
		
		
		
		//Création de la scène
		Scene scene = new Scene(root, 600, 450);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application Newsletter");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {

		Application.launch(args);
	}
}

