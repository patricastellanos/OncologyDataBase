package application;

import java.sql.SQLException;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.User;

public class LogInDoctorController {
	

    public LogInDoctorController() {
		
	}
	private static UserMaster userman = new JPAUserMaster();

	@FXML
    private PasswordField passText;

    @FXML
    private TextField userText;
    
    @FXML
    private Button loginButton;
    
    public void actionLogin(ActionEvent event) throws SQLException{
    	/*if(userText.getText().equals("")&& passText.getText().equals("123")) {
			try {

				Parent root = FXMLLoader.load(getClass().getResource("LoginDoctor.fxml"));
				Scene scene = new Scene(root);
				// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

				stage.setScene(scene);
				stage.show();
				
				passText.clear();
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}*/
    	
    	Window owner = loginButton.getScene().getWindow();
    	if (userText.getText().isEmpty()) {
    		showAlert(Alert.AlertType.ERROR, owner,"Error!", "Please enter your email");
    		return;
    	}
    	if (passText.getText().isEmpty()) {
    		showAlert(Alert.AlertType.ERROR, owner,"Error!", "Please enter your password again");
    		return;
    	}
    	String username = userText.getText();
    	String password = passText.getText();
    	
       User doctor = userman.checkPassword(username, password);
       if(doctor==null) {
    	   infoMessage("Please enter correct username or password", null, "Failed");
       }else {
    	   infoMessage("Successfull log in !!", null, "Failed");
       }

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