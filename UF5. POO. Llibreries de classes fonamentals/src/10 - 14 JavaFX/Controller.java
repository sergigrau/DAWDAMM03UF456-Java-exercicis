package edu.fje.daw2dam2;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.IOException;

/**
 * @author sergi.grau@fje.edu
 * @version 1.0 10.01.2017
 */
public class Controller {
    @FXML
    private Button boto1;
    @FXML
    private Button boto2;

    @FXML
    private void canviarEscenaAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==boto1){
            stage=(Stage) boto1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("segonaEscena.fxml"));
        }
        else {
            stage=(Stage) boto2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("terceraEscena.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
