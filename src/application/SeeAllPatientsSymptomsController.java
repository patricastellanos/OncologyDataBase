package application;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Patient;
import oncology.db.pojos.Symptoms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;


public class SeeAllPatientsSymptomsController {

    @FXML
    private TableView<Patient> tableP;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    private DBMaster db = Main.getdbMaster();
    
    public void initialize(){
    	
    	List<Symptoms> symptoms_list = db.printPatientSymptoms(Integer.parseInt(id.getText()));
    	
    	
    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Symptoms, String> idCol = new TableColumn<>("ID");
    	TableColumn<Symptoms, String> typeCol = new TableColumn<>("Details");
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_symp())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("Details"));
    	
    	
        tableP.getColumns().addAll(idCol, typeCol);
        tableP.getItems().addAll(symptoms_list);
        
    }
    
    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SymptomsDoctor.fxml"));
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
