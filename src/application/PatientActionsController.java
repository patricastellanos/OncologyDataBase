package application;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.Patient;

public class PatientActionsController {
	private DBMaster db = Main.getdbMaster();
    
    @FXML
    private TextField pid;

    @FXML
    private Button familyHist;

    @FXML
    private TableView<Patient> tableP;

    @FXML
    private TableView<FamilyHistory> tableF;
    
    @FXML
    private Button exit;

    @FXML
    private Button back;

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SecondInteractionPatient.fxml"));
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
    void actionSeeFamilyHist(ActionEvent event) {
        FamilyHistory fam = db.showFamilyHistoryByIDNumber(pid.getText());
        
        if(fam==null) {
    		infoMessage("No family history available", null, "Message");
        }else {
        	tableF.getItems().addAll(fam);
        }
    }

   
    
    public void initialize() {

    	
        tableF.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<FamilyHistory, String> idFCol = new TableColumn<>("ID");
    	TableColumn<FamilyHistory, String> typeCol = new TableColumn<>("Type");
    	TableColumn<FamilyHistory, String> memberCol = new TableColumn<>("Member");
    	
    	
    	idFCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_famHistory())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("type_cancerFam"));
    	memberCol.setCellValueFactory(new PropertyValueFactory<>("member"));
    	
    	
    	tableF.getColumns().addAll( idFCol, typeCol, memberCol);
    }
    
    public static void infoMessage(String infoMessage, String headerText, String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

}

