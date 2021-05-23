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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Treatment;

public class SeeTreatmentDoctorController {

    @FXML
    private Button backButton;

    @FXML
    private TextField id;
    @FXML
    private TableView<Treatment> tableP;

    @FXML
    private Button check;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;

    public void initialize(){
    	
    	List<Treatment> treatment_list = null;
    	
    	
    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Treatment, String> idCol = new TableColumn<>("ID");
    	TableColumn<Treatment, String> typeCol = new TableColumn<>("Type");
    	TableColumn<Treatment, String> dateCol = new TableColumn<>("Date");
    	TableColumn<Treatment, String> locationCol = new TableColumn<>("Diagnosis");
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_treat())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("medExam_type"));
    	DateFormat dateformat=new SimpleDateFormat("yyyy-mm-dd");
    	dateCol.setCellValueFactory(data -> new SimpleStringProperty(dateformat.format(data.getValue().getStart_date())));
    	locationCol.setCellValueFactory(new PropertyValueFactory<>("diagnosis"));
    	
        tableP.getColumns().addAll( idCol, typeCol, dateCol, locationCol);
        tableP.getItems().addAll(treatment_list);
        
    }

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("TreatmentDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

    @FXML
    void actionCheck(ActionEvent event) {

    }

    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionSeeAllP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsTreatment.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}