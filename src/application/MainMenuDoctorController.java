package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuDoctorController {

    @FXML
    private Button allPatientsButton;

    @FXML
    private Button famHistoryButton;

    @FXML
    private Button medExamButton;

    @FXML
    private Button cancerButton;

    @FXML
    private Button treatButton;

    @FXML
    private Button allCancersButton;

    @FXML
    private Button PatientButton;

    @FXML
    private Button SympButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionAllPatients(ActionEvent event) {

    }

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
    void actionCancer(ActionEvent event) {

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionFamilyHistory(ActionEvent event) {

    }

    @FXML
    void actionMedicalExamination(ActionEvent event) {

    }

    @FXML
    void actionPatient(ActionEvent event) {

    }

    @FXML
    void actionSymp(ActionEvent event) {

    }

    @FXML
    void actionTreatment(ActionEvent event) {

    }

}
