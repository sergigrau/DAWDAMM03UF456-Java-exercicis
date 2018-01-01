/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fje.daw2dam2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
* @author sergi grau
 * @version 1.0 15/01/2015
 */
public class CalculadoraController implements Initializable {

	  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private Label resultat;

    @FXML
    protected void operar(ActionEvent event) {
        Button boto = (Button) event.getSource();
        resultat.setText(resultat.getText()+boto.getText());
        

    }
    
    @FXML
    protected void esborrar(ActionEvent event) {
        resultat.setText("");
        

    }
    @FXML
    protected void canviarMenu(ActionEvent event) {
    	MenuItem menu = (MenuItem) event.getSource();
    	if (menu.getText().equals("Caspian")){
    	    Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    	}
    	else if  (menu.getText().equals("Modena")){
    		Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    	}     
    }

}
