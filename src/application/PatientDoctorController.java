package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PatientDoctorController {

    @FXML
    private Button addP;

    @FXML
    private Button removeP;

    @FXML
    private Button searchP;

    @FXML
    private Button updateP;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionAddP(ActionEvent event) {

    }

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MainMenuDoctor.fxml"));
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
    void actionRemoveP(ActionEvent event) {

    }

    @FXML
    void actionSearchP(ActionEvent event) {

    }

    @FXML
    void actionUpdateP(ActionEvent event) {

    }

}
