package application;

import javafx.event.ActionEvent;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RegisterNurseController {

    @FXML
    private Button registerNurse;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField username;

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
    
   
    public void start(Stage stage) throws Exception {
        System.out.println(getClass());
        Parent root = FXMLLoader.load(getClass().getResource("RegisterNurse.fxml"));
        stage.setTitle("Nurse Registration");
        stage.setScene(new Scene(root, 800, 500));
        stage.show();
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





