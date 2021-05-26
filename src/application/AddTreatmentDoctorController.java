package application;

import java.sql.Date;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import com.gluonhq.charm.glisten.control.TextField;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Treatment;

public class AddTreatmentDoctorController {
	
	private DBMaster db = Main.getdbMaster();
    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private TextField startDate;

    @FXML
    private TextField type;

    @FXML
    private Button add;

    @FXML
    private TextField duration;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;

    @FXML
    void actionAdd(ActionEvent event) {
  
    	Treatment treat= new Treatment( type.getText(),Date.valueOf(startDate.getText()), Integer.parseInt(duration.getText()));
    	db.addTreatment(treat,Integer.parseInt(id.getText()));

    }

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("TreatmentDoctor.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsTreatmentDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
