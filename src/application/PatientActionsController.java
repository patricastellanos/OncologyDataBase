package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.Patient;

public class PatientActionsController {
	private DBMaster db = Main.getdbMaster();
    
    @FXML
    private TextField pid;

    @FXML
    private Button personalInfo;

    @FXML
    private Button familyHist;

    @FXML
    private TableView<Patient> tableP;

    @FXML
    private TableView<FamilyHistory> tableF;

    @FXML
    void actionSeeFamilyHist(ActionEvent event) {
        FamilyHistory fam = db.showFamilyHistoryByIDNumber(pid.getText());
        
        if(fam==null) {
    		infoMessage("No family history available", null, "Message");
        }else {
        	tableF.getItems().addAll(fam);
        }
    }

    @FXML
    void actionSeePersonalInfo(ActionEvent event) {
    	Patient p = db.showPatientByIDNumber(pid.getText());
    	tableP.getItems().addAll(p);

    }
    
    public void initialize() {

    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Patient, String> idCol = new TableColumn<>("ID");
    	TableColumn<Patient, String> idNumCol = new TableColumn<>("IDNumber");
    	TableColumn<Patient, String> nameCol = new TableColumn<>("Name");
    	TableColumn<Patient, String> surNameCol = new TableColumn<>("SurName");
    	TableColumn<Patient, String> doBCol = new TableColumn<>("Date of birth");
    	TableColumn<Patient, String> sexCol = new TableColumn<>("Sex");
    	TableColumn<Patient, String> locationCol = new TableColumn<>("Location");
    	TableColumn<Patient, String> actualStateCol = new TableColumn<>("Actual State");
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_patient())));
    	idNumCol.setCellValueFactory(new PropertyValueFactory<>("IDNumber"));
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    	surNameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
    	DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd");
    	doBCol.setCellValueFactory(data -> new SimpleStringProperty(dateformat.format(data.getValue().getDate_birth())));
    	sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
    	locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
    	actualStateCol.setCellValueFactory(new PropertyValueFactory<>("actual_state"));
    	
    	
    	tableP.getColumns().addAll(idCol, idNumCol, nameCol, surNameCol, doBCol, sexCol, locationCol, actualStateCol);
    	
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

