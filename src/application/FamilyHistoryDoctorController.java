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

public class FamilyHistoryDoctorController {

	  @FXML
	    private Button addFamHist;

	    @FXML
	    private Button seeFamHist;

	    @FXML
	    private TextField convertToXML;

	    @FXML
	    private TextField convertXMLtoFamHist;

	    @FXML
	    private Button exitButton;

	    @FXML
	    private Button backButton;

    @FXML
    void actionAddFam(ActionEvent event) {

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
    void actionConvertToXML(ActionEvent event) {

    }

    @FXML
    void actionConvertXMLToFamHist(ActionEvent event) {

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionSeeFamHist(ActionEvent event) {

    }

}

