package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AskIDSymptomsDoctorController {

    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private Button add;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;

    @FXML
    void actionAdd(ActionEvent event) {

    }

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SymptomsDoctor.fxml"));
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
    void actionSeeAllP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsSymptoms.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
