package application;
import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class SeeAllMedicalExaminationController {
	

	

	public class SeeAllMedicalExamination {

	    @FXML
	    private TableView<?> tableP;

	    @FXML
	    private Button exitButton;

	    @FXML
	    private Button backButton;
	    
	    

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

}
