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
import oncology.db.pojos.Symptoms;

public class SeeSymptomsDoctorController {

    @FXML
    private TableView<Symptoms> tableP;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;
    
    private DBMaster db = Main.getdbMaster();
    
public void initialize(){
    	
    	List<Symptoms> sympList = db.printPatientSymptoms(0);
    	
    	
    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Symptoms, String> idCol = new TableColumn<>("ID");
    	TableColumn<Symptoms, String> detailsCol = new TableColumn<>("Details");
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_symp())));
    	detailsCol.setCellValueFactory(new PropertyValueFactory<>("details"));
    	
    	
    	tableP.getColumns().addAll(idCol, detailsCol);
        tableP.getItems().addAll(sympList);
        
    }


    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("AskIDSymptomsDoctor.fxml"));
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

