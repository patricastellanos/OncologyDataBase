package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TreatmentDoctorController {

    @FXML
    private Button addTreat;

    @FXML
    private Button assesTreat;

    @FXML
    private Button checkTreat;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    @FXML
    private Button removeTreat;

    @FXML
    void actionAddTreat(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("AddTreatmentDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    @FXML
    void actionRemoveTreat(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("RemoveTreatmentDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    @FXML
    void actionCheckTreat(ActionEvent event) {
    	
    	
    	
    

    }

    @FXML
    void actionAssesTreat(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeTreatmentDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}


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

}
