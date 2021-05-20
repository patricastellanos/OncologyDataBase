package application;

import java.sql.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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

    	Patient p= new Patient(name.getText(), surname.getText(),patientSex.getText(),Date.valueOf(dob.getText()),patientLocation.getText(),patientState.getText());
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

}
