package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.DBMaster;

public class CancerDoctorController {

    @FXML
    private Button addCancer;

    @FXML
    private Button seeCancer;

    @FXML
    private Button convertXML;

    @FXML
    private Button convertXMLtoCancer;

    @FXML
    private Button ConvertXMLtoHTML;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    private DBMaster db = Main.getdbMaster();
    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MainMenuDoctor.fxml"));
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
    void actionAddCancer(ActionEvent event) {
  
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("AddCancerDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}


    }
    @FXML
    void actionSeeCancer(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeCancerDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}


    }

  
    @FXML
    void actionConvertXML(ActionEvent event) {
    	
    	
    	

    }

    @FXML
    void actionConvertXMLtoCancer(ActionEvent event) {

    }


    @FXML
    void actionXMLtoHTML(ActionEvent event) {

    }
    
   

}
