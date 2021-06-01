package application;


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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Cancer;


public class SeeAllCancersNurseController {

	    @FXML
	    private TableView<Cancer> tableC;

	    @FXML
	    private Button exitButton;

	    @FXML
	    private Button backButton;
	    
	    private DBMaster db = Main.getdbMaster();

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
	    
    public void initialize(){
	    	
	    	List<Cancer> cancerList = db.printCancers();
	    	
	    	
	    	tableC.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
	    	
	    	TableColumn<Cancer, String> idCol = new TableColumn<>("ID");
	    	TableColumn<Cancer, String> typeCol = new TableColumn<>("Type");
	    	
	    	
	    	idCol.setCellValueFactory(data -> new SimpleStringProperty(Integer.toString(data.getValue().getId_cancer())));
	    	typeCol.setCellValueFactory(new PropertyValueFactory<>("cancer_type"));
	    	
	    	
	        tableC.getColumns().addAll(idCol, typeCol);
	        tableC.getItems().addAll(cancerList);
	        
	    }


}
