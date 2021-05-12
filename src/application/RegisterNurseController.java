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
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.User;
import javafx.scene.control.Alert;

public class RegisterNurseController {
	private static MenuMaster menuNurse = new Menu();

    @FXML
    private Button registerNurse;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;


    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SecondInteractionNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
   
    @FXML
   	void actionRegister(ActionEvent event) {
   		Window owner = registerNurse.getScene().getWindow();
   		if (username.getText().isEmpty()) {
   			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your email");
   			return;
   		}
   		if (password.getText().isEmpty()) {
   			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password");
   			return;
   		}
   		if (confirmPassword.getText().isEmpty()) {
   			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password again");
   			return;
   		}
   		String username = username.getText();
   		String password = password.getText();
   		String confirmPassword = confirmPassword.getText();
   		
   		
   		
   		

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
    void actionRegisterNurse(ActionEvent event) {

    }

}





