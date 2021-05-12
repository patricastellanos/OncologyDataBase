package application;

import javafx.event.ActionEvent;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class RegisterDoctorController {

    @FXML
    private PasswordField doctorPassword;

    @FXML
    private PasswordField doctorConfirmPassword;

    @FXML
    private Button RegisterDoctor;

    @FXML
    private TextField username;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;


    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SecondInteractionDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void actionConfirmPassword(ActionEvent event) {

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionPassword(ActionEvent event) {

    }

    @FXML
    void actionRegister(ActionEvent event) {

    }

}
