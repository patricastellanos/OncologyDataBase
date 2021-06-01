package application;

import java.sql.Date;

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
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Patient;

public class AddPatientDoctorController {
	@FXML
    private ToggleGroup sexRadioButton;
	@FXML
    private ToggleGroup locationRadioButton;

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
    private RadioButton homebutton;

    @FXML
    private RadioButton hospitalbutton;

    @FXML
    private TextField IDNum;

    @FXML
    private RadioButton malebutton;

    @FXML
    private RadioButton femalebutton;
    
    @FXML
    private ComboBox<String> actualStateChoice;
    private String[] actualStates = {"Acute Rehabilitation", "Lowstream Rehabilitation", "Complex care", 
    		"Convalescent Care", "Paliative Care", "Recovered", "Death"};
    
    
    private DBMaster db = Main.getdbMaster();
    
    public void initialize() {
    	actualStateChoice.getItems().addAll(actualStates);
    }

    @FXML
    void actionAdd(ActionEvent event) {
    	Window owner = addP.getScene().getWindow();
    	String sex ="";
    	if(malebutton.isSelected()) {
    	     sex = "Male";
    	}if(femalebutton.isSelected()) {
    		sex ="Female";
    	}
    	
    	String location= "";
    	if(homebutton.isSelected()) {
    		location = "Home";
    	}if(hospitalbutton.isSelected()) {
    		location = "Hospital";
    	}
    	String state=actualStateChoice.getValue();
    	
    	/*if(!state.equalsIgnoreCase("ACUTE REHABILITATION")&&
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
    	}*/
    	
    	Patient p= new Patient(IDNum.getText(), name.getText(), surname.getText(),sex,
    			Date.valueOf(dob.getText()),location ,state);
    	db.addPatient(p);
    	
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
