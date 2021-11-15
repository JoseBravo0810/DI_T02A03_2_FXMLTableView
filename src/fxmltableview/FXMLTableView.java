/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jose
 */

// Clase main
public class FXMLTableView extends Application {
    
    // Metodo que se ejecuta al inicializar la aplicacion
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Establece titulo
       primaryStage.setTitle("FXML TableView Example");
       // Carga el FXML
       Pane myPane = (Pane)FXMLLoader.load(getClass().getResource
    ("fxml_tableview.fxml"));
       // Instancia la escena
       Scene myScene = new Scene(myPane);
       // Establece la escena en la ventana
       primaryStage.setScene(myScene);
       // Muestra la ventana 
       primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
