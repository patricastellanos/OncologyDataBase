package application;

import com.gluonhq.charm.glisten.control.TextField;

import actions.SQLMaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;

public class SearchPatientDoctorController {

    @FXML
    private Button backButton;

    @FXML
    private Button searchP;

    @FXML
    private Button exitButton;
    
    @FXML
    private TextField name;

    @FXML
    private TextField surname;
    
    private DBMaster db = Main.getdbMaster();
    
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
    void actionSearch(ActionEvent event) {
    	
    	db.searchPatientByName(name.getText(), surname.getText());

    }

}
