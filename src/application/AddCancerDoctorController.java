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
import oncology.db.pojos.Cancer;


public class AddCancerDoctorController {
	private DBMaster db = Main.getdbMaster();

    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private TextField type;

    @FXML
    private Button add;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;

    @FXML
    void actionAdd(ActionEvent event) {
    	
    	Cancer cancer= new Cancer(type.getText());
    	
    	db.addCancer(cancer, Integer.parseInt(id.getText()));


    }

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("CancerDoctor.fxml"));
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
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsCancer.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
