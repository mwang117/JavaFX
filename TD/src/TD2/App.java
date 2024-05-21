package TD2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {
	
	//déclaration
	private Label lblTitreHaut;
	
	private Button btnValider;
	
	private Label lblUtilisateur;
	private TextField tfdUtilisateur;
	
	private Label lblMotDePasse;
	private PasswordField pwfMotDePasse;
	
	private Label lblApplication;
	
	private ComboBox<String> cbbApplication;
	
	private Label lblInfosBas;
	
	private Label lblMsgErreur;
	

	@Override
	public void start(Stage primaryStage) throws Exception {

		//initialisation
		this.lblTitreHaut = new Label();
		this.lblTitreHaut.setText("Veuillez saisir vos informations de login");
		this.lblTitreHaut.setAlignment(Pos.CENTER);
		this.lblTitreHaut.setMaxWidth(Double.MAX_VALUE);
		this.lblTitreHaut.setUnderline(true);
		
		this.lblMsgErreur = new Label();
		this.lblMsgErreur.setPrefWidth(250);
		this.lblMsgErreur.setTextFill(Color.RED);
		this.lblMsgErreur.setFont(Font.font(null, FontWeight.BOLD, -1));
		
		this.btnValider = new Button();
		this.btnValider.setText("Valider");
		this.btnValider.setOnMouseClicked(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				if (tfdUtilisateur.getText().trim().equals("")) {
					lblMsgErreur.setText("La saisie de l'utilisateur est obligatoire");
					lblInfosBas.setText("Aucun login saisie");
				} else if (pwfMotDePasse.getText().trim().equals("")) {
					lblMsgErreur.setText("La saisie d'un mot de passe est obligatoire");
					lblInfosBas.setText("Aucun mot de passe saisie");
				} else {
					lblMsgErreur.setText("");
					
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy 'a' HH:mm:ss");
					
					lblInfosBas.setText(
							"login de <" + tfdUtilisateur.getText() 
							+ "> pour application <" + cbbApplication.getValue() 
							+ "> le" + format.format(date)
					);
				}
			}
		});
		
		this.lblUtilisateur = new Label("Utilisateur :");
		this.tfdUtilisateur = new TextField();

		this.lblMotDePasse = new Label("Mot de passe :");
		this.pwfMotDePasse = new PasswordField();
		
		this.lblApplication = new Label("Application :");
		this.cbbApplication = new ComboBox<String>();
		String applications[] = {"Comptabilité", "Paye", "Gestion de production"};
		this.cbbApplication.getItems().addAll(applications);
		this.cbbApplication.setValue(applications[0]);
		
		this.lblInfosBas = new Label();
		this.lblInfosBas.setText("Aucun login saisie");
		this.lblInfosBas.setAlignment(Pos.CENTER);
		this.lblInfosBas.setMaxWidth(Double.MAX_VALUE);
		
		//Création d noeud racine
		BorderPane root = new BorderPane();
		
		//Création du noeud de grille
		GridPane grid = new GridPane();
		grid.add(this.lblUtilisateur, 0, 0);
		grid.add(this.tfdUtilisateur, 1, 0);
		grid.add(this.lblMotDePasse, 0, 1);
		grid.add(this.pwfMotDePasse, 1, 1);
		grid.add(this.lblApplication, 0, 2);
		grid.add(this.cbbApplication, 1, 2);
		
		grid.setHgap(10);
		grid.setVgap(12);
		
		BorderPane.setMargin(this.lblTitreHaut, new Insets(0, 0, 30, 0));
		root.setTop(this.lblTitreHaut);
		
		BorderPane.setMargin(grid, new Insets(0, 0, 0, 30));
		root.setCenter(grid);
		
		BorderPane.setMargin(this.lblMsgErreur, new Insets(10, 0, 10, 0));
		root.setLeft(this.lblMsgErreur);
		
		root.setBottom(this.lblInfosBas);
		
		BorderPane.setMargin(this.btnValider, new Insets(15, 15, 15, 15));
		BorderPane.setAlignment(this.btnValider, Pos.CENTER);
		root.setRight(this.btnValider);
		
		//Création de la scène
		Scene scene = new Scene(root, 600, 400);

		primaryStage.setScene(scene);		
		primaryStage.setTitle("Application Carte de Visite");
		primaryStage.show();
	} 
	
	public static void main(String[] args) {
		
		Application.launch(args);
	}
}
