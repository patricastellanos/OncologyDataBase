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

public class FamilyHistoryNurseController {
	private DBMaster db = Main.getdbMaster();

    @FXML
    private TextField convertToXML;

    @FXML
    private TextField convertToFamHist;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("FamilyHistoryNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    void actionConvertToFamHist(ActionEvent event) {
    	UserInteraction.XmlToFamilyHistoryMenu();
    	infoMessage("File imported and saved", null, "Message");

    }

    @FXML
    void actionConvertToXML(ActionEvent event) {
    	UserInteraction.familyHistoryToXmlMenu();
    	infoMessage("File imported and saved", null, "Message");
    	
    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void seeFamHist(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeFamilyHistory.fxml"));
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
