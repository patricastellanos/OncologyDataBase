package application;


import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Cancer;
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
import com.gluonhq.charm.glisten.control.TextField;

public class SeeCancerController {
	
	private DBMaster db = Main.getdbMaster();

    @FXML
    private Button backButton;

    @FXML
    private TextField id;

    @FXML
    private Button see;

    @FXML
    private Button seeP;

    @FXML
    private Button exitButton;
    
    @FXML
    private TableView<Cancer> cancerTable;

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("CancerDoctor.fxml"));
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
    	Cancer cancer = db.printCancer(Integer.parseInt(id.getText()));	
        
    	cancerTable.getItems().addAll(cancer);

    }
    
    public void initialize() {

    	cancerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    	
    	TableColumn<Cancer, String> idCol = new TableColumn<>("ID");
    	TableColumn<Cancer, String> typeCol = new TableColumn<>("Type");
    	
    	
    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_cancer())));
    	typeCol.setCellValueFactory(new PropertyValueFactory<>("cancer_type"));
    	
        cancerTable.getColumns().addAll(idCol, typeCol);
    }


    @FXML
    void actionSeeP(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("SeeAllPatientsCancer.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}
