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

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.FamilyHistory;

public class FamilyHistoryDoctorController {

	  @FXML
	    private Button addFamHist;

	    @FXML
	    private Button seeFamHist;

	    @FXML
	    private TextField convertToXML;

	    @FXML
	    private TextField convertXMLtoFamHist;

	    @FXML
	    private Button exitButton;

	    @FXML
	    private Button backButton;
	    
	    private DBMaster db = Main.getdbMaster();

    @FXML
    void actionAddFam(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("AddFamilyHistoryDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

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
    void actionConvertToXML(ActionEvent event) {
    	db.familyHistoryToXml(Integer.parseInt(convertToXML.getText()));
    	infoMessage("XML file generated and saved", null, "Message");
    	

    }

    @FXML
    void actionConvertXMLToFamHist(ActionEvent event) {
    	try {
			JAXBContext jaxbContext = JAXBContext.newInstance(FamilyHistory.class);
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			File file = new File("./xmls/FamilyHistory.xml");
			FamilyHistory famhist = (FamilyHistory) unmarshaller.unmarshal(file);
			
			System.out.println("Family History:");
			System.out.println("Type: " + famhist.getType_cancerFam());
			System.out.println("Member: " + famhist.getMember());
			
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
    	infoMessage("Family History generated and saved", null, "Message");

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionSeeFamHist(ActionEvent event) {
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
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message ) {
    	Alert alert = new Alert(alertType);
    	alert.setTitle(title);
    	alert.setHeaderText(null);
    	alert.setContentText(message);
    	alert.initOwner(owner);
    	alert.show();
    }

}

