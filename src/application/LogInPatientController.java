package application;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Window;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.User;

public class LogInPatientController {
	private static UserMaster userman = new JPAUserMaster();

    public LogInPatientController() {
		
	}

	@FXML
    private PasswordField passText;

    @FXML
    private TextField userText;
    
    @FXML
    private Button loginButton;

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

		User doctor = userman.checkPassword(username, password);
		if (doctor == null) {
			infoMessage("Please enter correct username or password", null, "Failed");
		} else {
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