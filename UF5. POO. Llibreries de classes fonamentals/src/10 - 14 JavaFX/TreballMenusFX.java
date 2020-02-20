package edu.fje.daw2dam2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Aplicació amb JavaFX que mostra el funcionament dels menus, 
 * mitjançamt FXML
 * 
 * @author sergi.grau@fje.edu
 * @version 1.0 17.01.2015
 *
 */

public class TreballMenusFX extends Application {
    
    public static void main(String[] args) {
        Application.launch(TreballMenusFX.class, args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent arrel = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        
        stage.setScene(new Scene(arrel, 300, 275));
        stage.show();
    }
}