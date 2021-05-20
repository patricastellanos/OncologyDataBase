package application;

import com.gluonhq.charm.glisten.control.TextField;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import actions.SQLMaster;

public class UpdatePatientDoctorController {
	  
	private SQLMaster db;

	    @FXML
	    private Button backButton;

	    @FXML
	    private TextField idPatient;

	    @FXML
	    private Button updateP;

	    @FXML
	    private TextField newState;

	    @FXML
	    private Button exitButton;
	    
	    @FXML
	    private Button seePatients;

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
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }
    
    @FXML
    void actionSeeP(ActionEvent event) {
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
    void actionUpdate(ActionEvent event) {
    	db= new SQLMaster();
    	db.update_patient_state(Integer.parseInt(idPatient.getText()), newState.getText());

    }

}
