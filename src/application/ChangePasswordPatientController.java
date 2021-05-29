package application;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.User;

public class ChangePasswordPatientController {
	
	private static UserMaster userman = new JPAUserMaster();

    @FXML
    private PasswordField passText;

    @FXML
    private TextField userText;

    @FXML
    private Button changePassButton;

    @FXML
    private PasswordField confirmPassText;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionBack(ActionEvent event) {
    	
    	try{
   			Parent root = FXMLLoader.load(getClass().getResource("LogInPatient.fxml"));
   			Scene scene = new Scene(root);
   			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   		
   			stage.setScene(scene);
   			stage.show();
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

    }

    @FXML
    void actionChangePass(ActionEvent event) {
    	
    	String user=userText.getText();
    	String pass=passText.getText();
    	String confirmPass=confirmPassText.getText();
    	
    	User u=userman.getUser(user);
    	Window owner = changePassButton.getScene().getWindow();
    	
    	if(!pass.equals(confirmPass)) {
    		infoMessage("ERROR, repeat the action", null, "Failed");
    	}else if(u!=null) {
    		userman.changePassword(user, pass);
        	infoMessage("Password changed", null, "Message");
        	
    	}
    	try{
   			Parent root = FXMLLoader.load(getClass().getResource("LogInNurse.fxml"));
   			Scene scene = new Scene(root);
   			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   		
   			stage.setScene(scene);
   			stage.show();
   		} catch(Exception e) {
   			e.printStackTrace();
   		}
    }

    @FXML
    void actionExit(ActionEvent event) {
    	
    	System.exit(0);

    }

    @FXML
    void actionPassword(ActionEvent event) {

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
