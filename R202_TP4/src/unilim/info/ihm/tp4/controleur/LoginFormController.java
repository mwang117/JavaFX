package unilim.info.ihm.tp4.controleur;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginFormController {

    @FXML
    private Label idLibErr;

    @FXML
    private ComboBox<String> idCb;
    
    @FXML
    private TextField idUser;
    
    @FXML
    private PasswordField idPwd;
    

    @FXML
    private void initialize() {
        // Remise à zéro les erreurs
        idLibErr.setText("");

        // Alimenter la ComboBox
        idCb.getItems().addAll("Comptabilité", "Paye", "Gestion de production");
    }

    @FXML
    private void validerSaisies() {
        String utilisateur = idUser.getText();
        String motDePasse = idPwd.getText();
        String application = idCb.getValue();

        if (utilisateur != null && !utilisateur.isEmpty() &&
            motDePasse != null && !motDePasse.isEmpty() &&
            application != null && !application.isEmpty()) {
            idLibErr.setText("");
        } else {
            idLibErr.setText("Veuillez remplir tous les champs.");
        }
    }
}
