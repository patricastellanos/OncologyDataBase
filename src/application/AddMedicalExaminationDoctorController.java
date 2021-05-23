package application;

import java.sql.Date;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.MedicalExamination;


public class AddMedicalExaminationDoctorController {

    @FXML
    private Button backButton;

    @FXML
    private Button add;

    @FXML
    private Button exitButton;
    
    @FXML
    private TextField id;

    @FXML
    private TextField date;

    @FXML
    private TextField type;
    
    @FXML
    private TextField diagnosis;
    
    @FXML
    private Button seeP;
    
    private DBMaster db = Main.getdbMaster();
    
    @FXML
    void actionAdd(ActionEvent event) {
    	
    	MedicalExamination medExam= new MedicalExamination( type.getText(),Date.valueOf(date.getText()),diagnosis.getText());
    	int id_patient= Integer.parseInt(id.getText());
    	db.addMedExam(medExam, id_patient);

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
    void actionSeeAllP(ActionEvent event) {
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
    void actionBack(ActionEvent event) {
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
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }
}
