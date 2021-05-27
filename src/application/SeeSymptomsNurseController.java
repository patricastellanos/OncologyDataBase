package application;



import java.util.List;


import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Symptoms;
import javafx.scene.Node;


public class SeeSymptomsNurseController {
	
	private DBMaster db = Main.getdbMaster();

    

    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private Button seeSymp;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;
    
    @FXML
    private TableView<Symptoms> tableP;

    @FXML
    void actionSeeSymptomsassociated(ActionEvent event) {
    	List<Symptoms> symptoms_list = db.printPatientSymptoms(Integer.parseInt(id.getText()));
    	tableP.getItems().addAll(symptoms_list);

    }
   

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("MainMenuNurse.fxml"));
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
    void actionSeeAllP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsNurse.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }
    
    public void initialize(){
    	
    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Symptoms, String> idCol = new TableColumn<>("ID");
    	TableColumn<Symptoms, String> typeCol = new TableColumn<>("Details");
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_symp())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("details"));
        tableP.getColumns().addAll(idCol, typeCol);
        
        
    }
    
    @FXML
    void actionseeSymp(ActionEvent event) {
    	
    	List<Symptoms> sympList=db.printPatientSymptoms(id.getAnchor());
    	tableP.getItems().addAll(sympList);
    }

}

