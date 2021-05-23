package application;

import com.gluonhq.charm.glisten.control.TextField;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.stage.Window;
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
	    private ComboBox<String> newState;
	    private String[] actualStates = {"Acute Rehabilitation", "Lowstream Rehabilitation", "Complex care", 
	    		"Convalescent Care", "Paliative Care", "Recovered", "Death"};


	    @FXML
	    private Button exitButton;
	    
	    @FXML
	    private Button seePatients;
	    
	    public void initialize() {
	    	newState.getItems().addAll(actualStates);
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
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }
    
    @FXML
    void actionSeeP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsPatient.fxml"));
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
    	Window owner = updateP.getScene().getWindow();
    	
    	db= new SQLMaster();
    	
    	String newActState=newState.getValue();
    	
    	
    	db.update_patient_state(Integer.parseInt(idPatient.getText()), newActState );
    	
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsPatient.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message ) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.initOwner(owner);
    	alert.show();
    }


}
