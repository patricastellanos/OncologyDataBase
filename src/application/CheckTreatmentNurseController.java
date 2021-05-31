package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;

public class CheckTreatmentNurseController {

	private DBMaster db = Main.getdbMaster();
	
	@FXML
    private Button backButton;

    @FXML
    private TextField idPatient;

    @FXML
    private Button checkButton;

    @FXML
    private Button seeAllP;

    @FXML
    private Button exitButton;

    @FXML
    void actionBack(ActionEvent event) {
    	
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
    void actionCheckTreat(ActionEvent event) {
    	
    	boolean result=db.treatment_worked(Integer.parseInt(idPatient.getText()));
    	String patientState=db.printActualState(Integer.parseInt(idPatient.getText()));
    	
    	if(result) {
    		
    		infoMessage("Patient deleted because the state was "+patientState, null, "Message");
    		db.removePatient(Integer.parseInt(idPatient.getText()));
    		
    	}else {
    		infoMessage("Patient state: "+patientState+" (no modifications)", null, "Message");
    	}
    	

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);
    }

    @FXML
    void actionSeeP(ActionEvent event) {
    	
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsTreatmentNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    public static void infoMessage(String infoMessage, String headerText, String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

}

