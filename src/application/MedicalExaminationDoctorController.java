package application;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MedicalExaminationDoctorController {

    @FXML
    private Button addMedExam;

    @FXML
    private Button seeMedExam;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    @FXML
    private Button seeAllMedExam;

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
    void actionAddMedExam(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("AddMedicalExaminationDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void actionSeeMedExam(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeMedicalExaminationDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    @FXML
    void actionSeeAllMedExam(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllMedicalExaminationDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
