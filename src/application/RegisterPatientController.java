package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegisterPatientController {
	   @FXML
	    private Button registerPatient;

	    @FXML
	    void actionConfirmPassword(ActionEvent event) {

	    }

	    @FXML
	    void actionPassword(ActionEvent event) {

	    }

	    @FXML
	    void actionRegisterPatient(ActionEvent event) {
	    	try {

				Parent root = FXMLLoader.load(getClass().getResource("LogInPatient.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				stage.setScene(scene);
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}


	    }


  
}

