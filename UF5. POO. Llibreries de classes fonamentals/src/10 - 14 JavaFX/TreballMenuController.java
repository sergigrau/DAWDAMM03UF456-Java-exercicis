package edu.fje.daw2dam2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

/**
 * Classe Controladora FXML
 * @author sergi grau
 * @version 1.0 17/01/2015
 */
public class TreballMenuController implements Initializable {

    /**
     * Inicialitza el controlador
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML private MenuItem menuObre;
    
    @FXML protected void canviarText(ActionEvent event) {
    	menuObre.setText("En procés...");
        
    }
}
