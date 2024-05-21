package unilim.info.ihm.tp1.exo2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
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
	
	private Button btnSouscrire;

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
		
		this.btnSouscrire = new Button();
		this.btnSouscrire.setText("Souscrire");
		
		
		BorderPane root = new BorderPane();
		
		GridPane grid = new GridPane();
		
		VBox box = new VBox();
		
		grid.add(this.lblCivilite, 0, 0);
		grid.add(this.cbbCivilite, 0, 1);
		grid.add(this.lblNom, 0, 2);
		grid.add(this.tfdNom, 0, 3);
		grid.add(this.lblEmail, 0, 4);
		grid.add(this.tfdEmail, 0, 5);
		grid.add(this.lblPrenom, 2, 2);
		grid.add(this.tfdPrenom, 2, 3);
		grid.add(this.lblComfirmeEmail, 2, 4);
		grid.add(this.tfdComfirmeEmail, 2, 5);
		
		grid.setHgap(10);
		grid.setVgap(10);
		
		
		box.setPadding(new Insets(10));
		box.getChildren().addAll(lblTitreHaut, lblTitreHaut2);
		box.setSpacing(10);
		
		root.setTop(box);
		BorderPane.setMargin(box, new Insets(0, 0, 10, 0));
		
		root.setCenter(grid);
		BorderPane.setMargin(grid, new Insets(0, 0, 0, 30));
		
		root.setBottom(this.btnSouscrire);
		BorderPane.setMargin(this.btnSouscrire, new Insets(15, 15, 15, 15));
		BorderPane.setAlignment(this.btnSouscrire, Pos.CENTER);
		
		Scene scene = new Scene(root, 600, 450);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Application Newsletter");
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {

		Application.launch(args);
	}
}
