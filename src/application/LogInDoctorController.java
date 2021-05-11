package application;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LogInDoctorController {
	

    public LogInDoctorController() {
		
	}

	@FXML
    private PasswordField passText;

    @FXML
    private TextField userText;

    @FXML
    void actionLogin(ActionEvent event) {
    	if(userText.getText().equals("")&& passText.getText().equals("123")) {
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

		}

    }

    @FXML
    void actionPassword(ActionEvent event) {
    
		}
    

}