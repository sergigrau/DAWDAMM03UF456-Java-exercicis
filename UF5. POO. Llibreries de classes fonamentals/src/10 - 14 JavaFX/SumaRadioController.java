package edu.fje.daw2dam2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author sergi.grau@fje.edu
 */
public class SumaRadioController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private Label resultat;
     @FXML
    private TextField numero1, numero2;
      @FXML
    private RadioButton suma, resta;

    @FXML
    protected void operar(ActionEvent event) {
        int n1 = Integer.parseInt(numero1.getText());
        int n2 = Integer.parseInt(numero2.getText());
        int res = 0;
        if (suma.isSelected()) {
            res = n1 + n2;
        } else if (resta.isSelected()) {
            res = n1 - n2;
        }

        resultat.setText("El resultat és " + res);

    }

}
