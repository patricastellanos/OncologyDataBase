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
    	int id=Integer.parseInt(idPatient.getText());
    	String newActState=newState.getText();
    	
    	if(!newActState.equalsIgnoreCase("ACUTE REHABILITATION")&&
    	   !newActState.equalsIgnoreCase("LOWSTREAM REHABILITATION")&&
    	   !newActState.equalsIgnoreCase("COMPLEX CARE")&&
    	   !newActState.equalsIgnoreCase("CONVALESCENT CARE")&&
    	   !newActState.equalsIgnoreCase("PALLIATIVE RESPITE")&&
    	   !newActState.equalsIgnoreCase("RECOVERED")&&
    	   !newActState.equalsIgnoreCase("DEATH")){
    		
    		showAlert(Alert.AlertType.ERROR, owner, "Error!", "States available: 1.ACUTE REHABILITATION, 2.LOWSTREAM REHABILITATION,"
    				+ " 3.COMPLEX CARE, 4.CONVALESCENT CARE, 5.PALLIATIVE RESPITE, 6.RECOVERED, 7.DEATH");
    										
    		}else {
    			db.update_patient_state(id, newActState );
    		}
    	
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
