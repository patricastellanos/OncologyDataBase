package application;

import java.io.IOException;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.User;

public class LogInPatientController {
	
	private static UserMaster userman = new JPAUserMaster();

	@FXML
    private PasswordField passText;

    @FXML
    private TextField userText;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button changePassButton;

    @FXML
    private Button removeUserButton;
    
    @FXML
    private Button exitButton;
    
    @FXML
    private Button backButton;
    
    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }
    @FXML
    void actionBack(ActionEvent event) {
    	 try{
  			Parent root = FXMLLoader.load(getClass().getResource("SecondInteractionPatient.fxml"));
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
    	
    	 try{
   			Parent root = FXMLLoader.load(getClass().getResource("ChangePasswordPatient.fxml"));
   			Scene scene = new Scene(root);
   			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
   		
   			stage.setScene(scene);
   			stage.show();
   		} catch(Exception e) {
   			e.printStackTrace();
   		}

    }

    @FXML
    void actionRemoveUser(ActionEvent event) {
    	
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("RemoveUserPatient.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}


    }


    @FXML
	void actionLogin(ActionEvent event) {
		Window owner = loginButton.getScene().getWindow();
		if (userText.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your email");
			return;
		}
		if (passText.getText().isEmpty()) {
			showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password again");
			return;
		}
		String username = userText.getText();
		String password = passText.getText();

		User user = userman.checkPassword(username, password);
		
		if (user == null) {
			infoMessage("Please enter correct username or password", null, "Failed");
		} else {
			infoMessage("Successfull log in !!", null, "Message");
			 try{
		  			Parent root = FXMLLoader.load(getClass().getResource("PatientActions.fxml")); 
		  			Scene scene = new Scene(root);
		  			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  			
		  			
		  		
		  			stage.setScene(scene);
		  			stage.show();
		  		} catch(Exception e) {
		  			e.printStackTrace();
		  		}
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