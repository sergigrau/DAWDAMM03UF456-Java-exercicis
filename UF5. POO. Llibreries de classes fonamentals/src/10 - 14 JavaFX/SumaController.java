/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author sergi
 */
public class SumaController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private Label resultat;
    @FXML
    private TextField numero1, numero2;

    @FXML
    protected void sumar(ActionEvent event) {
        int n1 = Integer.parseInt(numero1.getText());
        int n2 = Integer.parseInt(numero2.getText());

        resultat.setText("El resultat és " + (n1 + n2));

    }

}
