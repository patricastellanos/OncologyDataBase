package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuNurseController {

    @FXML
    private Button famHistoryButtn;


    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("LogInNurse.fxml"));
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
    void actionAllPatients(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}


    }
    @FXML
    void actionAllCancers(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllCancersNurse.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("CancerNurse.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("FamilyHistoryNurse.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("MedicalExaminationNurse.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("TreatmentNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void searchP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SearchPatientNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    @FXML
    void actionSeeSymptoms(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeSymptomsNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}

