package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class RegisterDoctorController {
	

    public RegisterDoctorController() {
		
	}

	@FXML
    private PasswordField doctorPassword;

    @FXML
    private PasswordField doctorConfirmPassword;

    @FXML
    private Button RegisterDoctor;

    @FXML
    private Label UserNameLabel;

    @FXML
    void actionConfirmPassword(ActionEvent event) {

    }

    @FXML
    void actionPassword(ActionEvent event) {

    }

    @FXML
    void actionRegister(ActionEvent event) {
    	try {

			Parent root = FXMLLoader.load(getClass().getResource("LogInDoctor.fxml"));
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

