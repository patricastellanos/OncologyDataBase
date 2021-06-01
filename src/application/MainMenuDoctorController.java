package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuDoctorController {

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
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }
    @FXML
    void actionAllCancer(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllCancersDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void actionAllPatients(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	
    }



    @FXML
    void actionCancer(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("CancerDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }



    @FXML
    void actionFamilyHistory(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("FamilyHistoryDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void actionMedicalExamination(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MedicalExaminationDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void actionPatient(ActionEvent event) {
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
    void actionSymp(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SymptomsDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

    @FXML
    void actionTreatment(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("TreatmentDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    	

    }

}
