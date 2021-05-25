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


import com.gluonhq.charm.glisten.control.TextField;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.FamilyHistory;


public class SeeFamilyHistoryController {

    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private Button seeP;

    @FXML
    private TableView<FamilyHistory> tableP;

    @FXML
    private Button exitButton;
    
    private DBMaster db = Main.getdbMaster();

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("FamilyHistoryDoctor.fxml"));
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
    
    public void initialize() {

    	tableP.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<FamilyHistory, String> idCol = new TableColumn<>("ID");
    	TableColumn<FamilyHistory, String> typeCol = new TableColumn<>("Type");
    	TableColumn<FamilyHistory, String> memberCol = new TableColumn<>("Member");
    	
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_famHistory())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("type_cancerFam"));
    	memberCol.setCellValueFactory(new PropertyValueFactory<>("member"));
    	
    	
    	tableP.getColumns().addAll( idCol, typeCol, memberCol);
    }


    @FXML
    void actionSee(ActionEvent event) {
    	FamilyHistory fam = db.printFamHistory(Integer.parseInt(id.getText()));
    	
    	tableP.getItems().addAll(fam);
    	

    }

    @FXML
    void actionSeeAllP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsFamilyHistory.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
