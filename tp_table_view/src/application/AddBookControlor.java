package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AddBookControlor implements Initializable {
    @FXML
    private TextField Email;

    @FXML
    private TableColumn<Person, String> Emailc;

    @FXML
    private TextField Nom;

    @FXML
    private TableColumn<Person, String> Nomc;

    @FXML
    private TextField Prenom;

    @FXML
    private TableColumn<Person, String> Prenomc;

    @FXML
    private TableView<Person> table;
    @FXML	
    private Button ajout;
    @FXML
    private Button supp;
    @FXML
    private Button exp;

    @FXML
    private Button imp;
    
    private DataClass data;
    @FXML
    void add(ActionEvent event) {
    	 String nomValue = Nom.getText();
         String prenomValue = Prenom.getText();
         String emailValue = Email.getText();
         
         Person newPerson = new Person(nomValue, prenomValue, emailValue);
         table.getItems().add(newPerson);

    }
    @FXML
    void delete(ActionEvent event) {
    	Person selectedPerson = table.getSelectionModel().getSelectedItem();
       
        if (selectedPerson != null) {
            table.getItems().remove(selectedPerson);
        } else {
        	Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez sélectionner une personne à supprimer.");
            alert.showAndWait();
        }
        }
    @FXML
    void exp(ActionEvent event) {
    	data.setExportList(table.getItems());

    }

    @FXML
    void imp(ActionEvent event) {
    	for (Person p:data.getImportList()) {
			table.getItems().add(p);
		}
    	

    }

    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Nomc.setCellValueFactory(new PropertyValueFactory("lastName"));
		Prenomc.setCellValueFactory(new PropertyValueFactory("firstName"));
		Emailc.setCellValueFactory(new PropertyValueFactory("email"));
		 data =new DataClass();
		for (Person p:data.getImportList()) {
			table.getItems().add(p);
		}
	}


}
