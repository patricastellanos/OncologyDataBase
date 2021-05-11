package application;

import actions.SQLMaster;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.Patient;
import oncology.ui.Menu;

public class MainMenuNurseController {
	private static Menu Menu_manager_object;
	private static SQLMaster SQL_manager_object;
	private static JPAUserMaster JPA_manager_object;
	
    public MainMenuNurseController() {
		
	}
    public static void setValues(SQLMaster SQL_manager, JPAUserMaster JPA_manager, Menu menu) {
		SQL_manager_object = SQL_manager;
		JPA_manager_object = JPA_manager;
		Menu_manager_object = menu;
	}
    public static void setMenuController(Menu controller) {
		controller = controller;
	}
	@FXML
    private Button medExamButton;

    @FXML
    private Button famHistoryButton;

    @FXML
    private Button cancerButton;

    @FXML
    private Button treatButton;

    @FXML
    private Button exitButton;

    @FXML
    void actionCancer(ActionEvent event) {

    }
    @FXML
    void actionExit(ActionEvent event) {
    	System.exit(0);

    }

    @FXML
    void actionFamilyHistory(ActionEvent event) {
    	

    }

    @FXML
    void actionMedicalExamination(ActionEvent event) {

    }

    @FXML
    void actionTreatment(ActionEvent event) {

    }

}