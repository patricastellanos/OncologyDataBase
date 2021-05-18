package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchedPatientController {

    @FXML
    private Button backButton;

    @FXML
    private TextField nameP;

    @FXML
    private TextField surnameP;

    @FXML
    private TextField actualStateP;

    @FXML
    private TextField sexP;

    @FXML
    private TextField dobP;

    @FXML
    private TextField locationP;

    @FXML
    private Button exitButton;

    @FXML
    void actionActualStateP(ActionEvent event) {

    }

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("PatientDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void actionDOB(ActionEvent event) {

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionLocation(ActionEvent event) {

    }

    @FXML
    void actionName(ActionEvent event) {

    }

    @FXML
    void actionSex(ActionEvent event) {

    }

    @FXML
    void actionSurname(ActionEvent event) {

    }

}
