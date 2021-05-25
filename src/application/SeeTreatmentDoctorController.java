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
import com.gluonhq.charm.glisten.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
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
    
    private DBMaster db = Main.getdbMaster();

    public void initialize(){
    	
    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Treatment, String> idCol = new TableColumn<>("ID");
    	TableColumn<Treatment, String> typeCol = new TableColumn<>("Type");
    	TableColumn<Treatment, String> dateCol = new TableColumn<>("StartDate");
    	TableColumn<Treatment, String> durationCol = new TableColumn<>("Duration");
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_treat())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("treat_type"));
    	DateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
    	dateCol.setCellValueFactory(data -> new SimpleStringProperty(dateformat.format(data.getValue().getStart_date())));
    	durationCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getDuration())));
    	
        tableP.getColumns().addAll( idCol, typeCol, dateCol, durationCol);
        
        
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
    	List<Treatment> treatment = db.seeTreatment(Integer.parseInt(id.getText()));
    	tableP.getItems().addAll(treatment);

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