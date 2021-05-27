package application;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class RemoveUserDoctorController {

    @FXML
    private PasswordField passText;

    @FXML
    private TextField userText;

    @FXML
    private Button deleteUserButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionBack(ActionEvent event) {
    	
    	 try{
    			Parent root = FXMLLoader.load(getClass().getResource("LogInDoctor.fxml"));
    			Scene scene = new Scene(root);
    			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    		
    			stage.setScene(scene);
    			stage.show();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}

    }

    @FXML
    void actionDeleteUser(ActionEvent event) {


    }

    @FXML
    void actionExit(ActionEvent event) {

    }

}

