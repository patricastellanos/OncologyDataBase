package application;

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
    void actionAdd(ActionEvent event) {

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
