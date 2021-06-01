package application;

import java.security.MessageDigest;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.Role;
import oncology.db.pojos.users.User;

public class RegisterDoctorController {
	private static UserMaster userman = new JPAUserMaster();

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button registerDoctor;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField username;

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
    void actionRegisterDoctor(ActionEvent event) {
    	Window owner = registerDoctor.getScene().getWindow();
   		if((username.getText().isEmpty())) {
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
   		String username = this.username.getText();
   		String password = this.password.getText();
   		String confirmPassword = this.confirmPassword.getText();
   		
   		if(!password.equals(confirmPassword)) {
   			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password again");
   			return;
   		}
   		
   		try{
   		Role doctorRole=new Role(2, "doctor");
   		boolean userRepeated= userman.userNameTaken(username);
   		
   		if(userRepeated) {
   			infoMessage("ERROR, existing user", null, "Failed");
   			
   			
   		}else {

   		MessageDigest md = MessageDigest.getInstance("MD5");
   		md.update(password.getBytes());
   		byte[] hash = md.digest();
   		User user = new User(username, hash, doctorRole);
   		userman.newUser(user);
   		
   		
		Parent root = FXMLLoader.load(getClass().getResource("MainMenuDoctor.fxml")); 
		Scene scene = new Scene(root);
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		stage.setScene(scene);
		stage.show();
   		}
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    public static void infoMessage(String infoMessage, String headerText, String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message ) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.initOwner(owner);
    	alert.show();
    }

}
