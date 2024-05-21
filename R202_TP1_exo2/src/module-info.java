module R202_TP1_exo2 {
	requires javafx.controls;
	
	opens application to javafx.graphics, javafx.fxml;
	
	exports unilim.info.ihm.tp1.exo2;
}
