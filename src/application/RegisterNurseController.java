package application;

import javafx.event.ActionEvent;
import java.security.MessageDigest;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

//import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.Role;
import oncology.db.pojos.users.User;
import oncology.ui.Menu;


public class RegisterNurseController {
	
	private static UserMaster userman = new JPAUserMaster();

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
   		String username = username.getText();
   		String password = password.getText();
   		String confirmPassword = confirmPassword.getText();
   		
   		if(!password.equals(confirmPassword)) {
   			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password again");
   			return;
   		}
   		
   		Role nurse=new Role();
   		MessageDigest md = MessageDigest.getInstance("MD5");
   		md.update(password.getBytes());
   		byte[] hash = md.digest();
   		User user = new User(username,hash,nurse);
   		userman.newUser(user);
   		
   		
   	}
    
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message ) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.initOwner(owner);
    	alert.show();
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





