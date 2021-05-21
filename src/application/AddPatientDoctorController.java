package application;

import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Patient;

public class AddPatientDoctorController {

    @FXML
    private Button backButton;

    @FXML
    private Button addP;

    @FXML
    private Button exitButton;
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private MenuBar sex;

    @FXML
    private TextField dob;

    @FXML
    private MenuBar loc;

    @FXML
    private MenuBar actualState;
    
    @FXML
    private TextField patientSex;

    @FXML
    private TextField patientLocation;

    @FXML
    private TextField patientState;
    
    private DBMaster db = Main.getdbMaster();

    @FXML
    void actionAdd(ActionEvent event) {
    	Window owner = addP.getScene().getWindow();
    	
    	
    	String sex =patientSex.getText();
    	String location= patientLocation.getText();
    	String state=patientState.getText();
    	
    	if(!state.equalsIgnoreCase("ACUTE REHABILITATION")&&
    	   !state.equalsIgnoreCase("LOWSTREAM REHABILITATION")&&
    	   !state.equalsIgnoreCase("COMPLEX CARE")&&
    	   !state.equalsIgnoreCase("CONVALESCENT CARE")&&
    	   !state.equalsIgnoreCase("PALLIATIVE RESPITE")&&
    	   !state.equalsIgnoreCase("RECOVERED")&&
    	   !state.equalsIgnoreCase("DEATH")&&
    	   !sex.equalsIgnoreCase("MALE")&&
    	   !sex.equalsIgnoreCase("FEMALE")&&
    	   !location.equalsIgnoreCase("HOME")&&
    	   !location.equalsIgnoreCase("HOSPITAL")) {
    		
    		showAlert(Alert.AlertType.ERROR, owner, "Error!", "States available: 1.ACUTE REHABILITATION, 2.LOWSTREAM REHABILITATION,"
    				+ " 3.COMPLEX CARE, 4.CONVALESCENT CARE, 5.PALLIATIVE RESPITE, 6.RECOVERED, 7.DEATH\n Gender available: MALE, FEMALE"
    				+ "\n Locations available: HOME, HOSPITAL");
    	}
    	
    	Patient p= new Patient(name.getText(), surname.getText(),sex,
    			Date.valueOf(dob.getText()),location ,state);
    	db.addPatient(p);
    	

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
    
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message ) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.initOwner(owner);
    	alert.show();
    }

}
