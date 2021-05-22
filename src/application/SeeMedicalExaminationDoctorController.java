package application;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Patient;

public class SeeMedicalExaminationDoctorController {
	private DBMaster db = Main.getdbMaster();
    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private Button see;
    
    @FXML
    private TableView<?> table;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MedicalExaminationDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    @FXML
    void actionSeeP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsMedicalExaminationDoctor.fxml"));
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
    void actionSee(ActionEvent event) {
    	
    	MedicalExamination medicalExamination = db.printMedExamination(Integer.parseInt(id.getText()));	
       
    	table.getItems().addAll(medicalExamination);
       
    }
    public void initialize() {

    	table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Patient, String> idCol = new TableColumn<>("ID");
    	TableColumn<Patient, String> typeCol = new TableColumn<>("Type");
    	TableColumn<Patient, String> dateCol = new TableColumn<>("Date");
    	TableColumn<Patient, String> diagnosisCol = new TableColumn<>("Diagnosis");
    	
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_patient())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    	DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd");
    	dateCol.setCellValueFactory(data -> new SimpleStringProperty(dateformat.format(data.getValue().getDate_birth())));
    	diagnosisCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
    
    	
    	table.getColumns().addAll( idCol, typeCol, dateCol, diagnosisCol);
    }

 
}
