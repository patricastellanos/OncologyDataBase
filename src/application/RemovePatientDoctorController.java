
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
import oncology.db.interfaces.DBMaster;

public class RemovePatientDoctorController {
	
	private DBMaster db = Main.getdbMaster();
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
		
		db.removePatient(Integer.parseInt(id.getText()));
		
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

}
