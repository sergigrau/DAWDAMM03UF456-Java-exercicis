
package edu.fje.daw2dam2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * Classe que implementa una suma amb JavaFX
 * utilitzant botons de radio
 * @author sergi grau
 * @version 1.0 15/01/2015
 */

public class SumaRadio extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent arrel = FXMLLoader.load(getClass().getResource("sumaRadio.fxml"));
        
        stage.setTitle("Operacions");
        stage.setScene(new Scene(arrel, 300, 275));
        stage.show();
    }
}
