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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.users.User;

public class SeeMedicalExaminationPatientController {
	
	private DBMaster db = Main.getdbMaster();
	private static UserMaster userman = new JPAUserMaster();

    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private Button see;

    @FXML
    private Button seeP;

    @FXML
    private TableView<MedicalExamination> table;

    @FXML
    void actionBack(ActionEvent event) {
    	
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MainMenuPatient.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void actionSee(ActionEvent event) {
    	
    	int idSee=Integer.parseInt((id.getText()));
    	String userName=LogInPatientController.getUserPatient();
    	User u=userman.getUser(userName);
    	int idUser=u.getId();
    	
    	if(idSee==idUser) {
    		List<MedicalExamination> medExamList = db.printMedExamPatient(idSee);	
        	
        	table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        	
        	TableColumn<MedicalExamination, String> idCol = new TableColumn<>("ID");
        	TableColumn<MedicalExamination, String> typeCol = new TableColumn<>("Type");
        	TableColumn<MedicalExamination, String> dateCol = new TableColumn<>("Date");
        	TableColumn<MedicalExamination, String> diagnosisCol = new TableColumn<>("Diagnosis");
        	
        	
        	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_medExam())));
        	typeCol.setCellValueFactory(new PropertyValueFactory<>("medExam_type"));
        	DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
        	dateCol.setCellValueFactory(data -> new SimpleStringProperty(dateformat.format(data.getValue().getDateMedExam())));
        	diagnosisCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
        	
        
        	
        	table.getColumns().addAll(idCol, typeCol, dateCol, diagnosisCol);
        	table.getItems().addAll(medExamList);
    	}else {
    		infoMessage("Information not available", null, "Message");
    	}
    	
    	
    		

    }

    @FXML
    void actionSeeP(ActionEvent event) {

    }
    
    public static void infoMessage(String infoMessage, String headerText, String title) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

}

