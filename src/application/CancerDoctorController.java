package application;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.DBMaster;
import userInteraction.UserInteraction;

public class CancerDoctorController {
	
	private DBMaster db = Main.getdbMaster();
	
	@FXML
	private Button addCancer;

	@FXML
	private Button seeCancer;

	@FXML
	private TextField convertXML;

	@FXML
	private TextField convertfromXMLtoCancer;

	@FXML
	private TextField convertXMLtoHTML;

	@FXML
	private Button exitButton;

	@FXML
	private Button backButton;

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
    	
    	db.cancerToXml(Integer.parseInt(convertXML.getText()));
    	infoMessage("File created and saved", null, "Message");

    }

    @FXML
    void actionConvertXMLtoCancer(ActionEvent event) {
    	
    	UserInteraction.XmlToCancerMenu();
    	infoMessage("Cancer created and saved", null, "Message");
   
    }


    @FXML
    void actionXMLtoHTML(ActionEvent event) {
    	
    	UserInteraction.cancerXmlToHtml();
    	infoMessage("File created and saved", null, "Message");
    }
    
    public static void infoMessage(String infoMessage, String headerText, String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }
   

}
