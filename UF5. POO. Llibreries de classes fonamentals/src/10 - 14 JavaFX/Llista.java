package edu.fje.daw2dam2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

/**
 * Classe que demostra el funcionament d'una llista
 *
 * @author sergi grau
 * @version 1.0 8/02/2014
 */
public class Llista extends Application {

    public static final ObservableList cursos = 
        FXCollections.observableArrayList();
    public static final ObservableList alumnes = 
        FXCollections.observableArrayList();
       
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Llista");        
        
        final ListView llista = new ListView(alumnes);
        llista.setPrefSize(200, 250);
        llista.setEditable(true);
        
        cursos.addAll(
             "DAW","DAM","ASIX"
        );
         
        for (int i = 0; i < 18; i++) {
            alumnes.add("alumne"+i);
        }
          
        llista.setItems(alumnes);
        llista.setCellFactory(ComboBoxListCell.forListView(cursos));              
               
        StackPane arrel = new StackPane();
        arrel.getChildren().add(llista);
        stage.setScene(new Scene(arrel, 200, 250));
        stage.show();
    }

}
