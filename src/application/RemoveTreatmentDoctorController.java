package application;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;

	public class RemoveTreatmentDoctorController {
		private DBMaster db = Main.getdbMaster();

	    @FXML
	    private TextField id;

	    @FXML
	    private Button removeButton;

	    @FXML
	    private Button backButton;

	    @FXML
	    private Button exitButton;

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
	    void actionExit(ActionEvent event) {
	    	System.exit(0);

	    }

	    @FXML
	    void actionRemove(ActionEvent event) {
	    	//db.removeTreatment(Integer.parseInt(id.getText()));
	    	
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

}