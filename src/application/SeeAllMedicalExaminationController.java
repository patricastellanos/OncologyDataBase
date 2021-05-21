package application;
import javafx.event.ActionEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.MedicalExamination;

public class SeeAllMedicalExaminationController {
	


	    @FXML
	    private TableView<MedicalExamination> tableP;

	    @FXML
	    private Button exitButton;

	    @FXML
	    private Button backButton;
	    
	    private DBMaster db = Main.getdbMaster();
	    
	    public void initialize(){
	    	
	    	List<MedicalExamination> medExList = db.printMedExam();
	    	
	    	
	    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    	
	    	TableColumn<MedicalExamination, String> idCol = new TableColumn<>("ID");
	    	TableColumn<MedicalExamination, String> typeCol = new TableColumn<>("Type");
	    	TableColumn<MedicalExamination, String> dateCol = new TableColumn<>("Date");
	    	TableColumn<MedicalExamination, String> diagnosisCol = new TableColumn<>("Diagnosis");
	    	
	    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_medExam())));
	    	typeCol.setCellValueFactory(new PropertyValueFactory<>("medExam_type"));
	    	DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd");
	    	dateCol.setCellValueFactory(data -> new SimpleStringProperty(dateformat.format(data.getValue().getDateMedExam())));
	    	diagnosisCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
	    	
	        tableP.getColumns().addAll(idCol, typeCol, dateCol, diagnosisCol);
	        tableP.getItems().addAll(medExList);
	        
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
	    void actionExit(ActionEvent event) {
	    	System.exit(0);

	    }

	}


