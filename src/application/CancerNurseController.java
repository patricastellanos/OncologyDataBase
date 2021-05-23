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
import oncology.db.interfaces.DBMaster;
import userInteraction.UserInteraction;

public class CancerNurseController {
	private DBMaster db = Main.getdbMaster();

    @FXML
    private TextField  convertToXML;

    @FXML
    private TextField  convertToCancer;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MainMenuNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void actionConvertToCancer(ActionEvent event) {
    	UserInteraction.XmlToCancerMenu();
    	infoMessage("File imported and saved", null, "Message");

    }

    @FXML
    void actionConvertToXML(ActionEvent event) {
    	db.cancerToXml(Integer.parseInt(convertToXML.getText()));
    	infoMessage("File created and saved", null, "Message");

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionSeeCancerP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeCancer.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    public static void infoMessage(String infoMessage, String headerText, String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

}
