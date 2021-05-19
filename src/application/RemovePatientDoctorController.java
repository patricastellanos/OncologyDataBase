
package application;

import actions.SQLMaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RemovePatientDoctorController {
	
	private SQLMaster db;
	@FXML
	private Button seeAllP;

	@FXML
	private Button backButton;

	@FXML
	private TextField id;

	@FXML
	private Button removeP;

	@FXML
	private Button exitButton;

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
	void actionRemove(ActionEvent event) {
		db = new SQLMaster();
		db.removePatient(Integer.parseInt(id.getText()));
		
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

}
