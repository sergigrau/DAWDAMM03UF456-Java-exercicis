package edu.fje.daw2dam2;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.ObservableList;
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
public class ConversorController implements Initializable {

	@FXML
	private TableView<Dada> taula;

	@FXML
	private TextField entrada;

	@FXML
	protected void operar(ActionEvent event) {
		ObservableList<Dada> dades = taula.getItems();
		String ascii = entrada.getText();
		int decimal = (int) ascii.charAt(0);
		
		dades.add(new Dada("ASCii", ascii));
		dades.add(new Dada("decimal", String.valueOf(decimal)));
		dades.add(new Dada("binari", Integer.toBinaryString(decimal).toString()));
		entrada.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
