/**
 * 
 */
/**
 * 
 */
module R202_TP2 {
	requires javafx.controls;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	
	exports unilim.info.ihm.tp2.exo1;
}