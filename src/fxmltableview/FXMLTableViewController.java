/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmltableview;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author jose
 */
// Controlador de la vista e el modelo MVC
public class FXMLTableViewController {
    // Variables extraidas en el mapeo del FXML, son los objetos con identificador
    @FXML private TableView<Person> tableView;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private TextField emailField;
    
    // Metodo para añadir personas, es el metodo que se ejecuta al hacer click en el boton de añadir
    @FXML
    protected void addPerson(ActionEvent event) {
        // Atraves del contenido de los camposs de texto, creamos una persona que añadimos a la tabla
        ObservableList<Person> data = tableView.getItems();
        data.add(new Person(firstNameField.getText(),
            lastNameField.getText(),
            emailField.getText()
        ));
        
        // Dejamos vacios los campos de texto para una nueva insercion
        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");   
    }
}
