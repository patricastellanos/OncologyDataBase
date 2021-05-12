package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class DoctorOptionsController {
	   @FXML
	    private MenuButton patientMenuBotton;

	    @FXML
	    void patientMenuBotton(ActionEvent event) {
	    	MenuItem item1 = new MenuItem("Add a patient");
	    	MenuItem item2 = new MenuItem("Search patient");
	    	MenuItem item3 = new MenuItem("Remove patient");
	    	MenuItem item4 = new MenuItem("Update patient's cancer state");
	    	
	    	MenuButton patientMenuBotton = new MenuButton ("Patient", null, item1, item2, item3, item4);

	    }

}
