package application;

import javafx.application.Application;

import javafx.event.ActionEvent;
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
import oncology.db.pojos.Patient;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import actions.SQLMaster;

public class SeeAllPatientsDoctorController {

    @FXML
    private TableView<Patient> tableP;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    private SQLMaster db;
    
    public void initialize(){
    	db = new SQLMaster();
    	List<Patient> patients_list = db.printPatients();
    	
    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Patient, Integer> idCol = new TableColumn<>("ID");
    	TableColumn<Patient, String> nameCol = new TableColumn<>("Name");
    	TableColumn<Patient, String> surNameCol = new TableColumn<>("SurName");
    	TableColumn<Patient, Date> doBCol = new TableColumn<>("Date of birth");
    	TableColumn<Patient, String> sexCol = new TableColumn<>("Sex");
    	TableColumn<Patient, String> locationCol = new TableColumn<>("Location");
    	TableColumn<Patient, String> actualStateCol = new TableColumn<>("Actual State");
    	
    	idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
    	surNameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
    	doBCol.setCellValueFactory(new PropertyValueFactory<>("birth_date"));
    	sexCol.setCellValueFactory(new PropertyValueFactory<>("sex"));
    	locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));
    	actualStateCol.setCellValueFactory(new PropertyValueFactory<>("actual_state"));
    	
    	
        tableP.getColumns().addAll( idCol, nameCol, surNameCol, doBCol, sexCol, locationCol, actualStateCol);
        tableP.getItems().add(new Patient("pepe", "perez", "male", new Date(1935, 05, 06),"home","complex_care"));
        tableP.getItems().addAll(patients_list);
        System.out.println("Nombre primer paciente" + patients_list.get(0).getName());
    }
    
    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("PatientDoctor.fxml"));
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
