package application;

import com.gluonhq.charm.glisten.control.TextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;

public class RemoveUserNurseController {
	
	private static UserMaster userman = new JPAUserMaster();

    @FXML
    private PasswordField passText;

    @FXML
    private TextField userText;

    @FXML
    private Button removeUserButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button backButton;

    @FXML
    void actionBack(ActionEvent event) {

    }

    @FXML
    void actionExit(ActionEvent event) {

    }

    @FXML
    void actionRemoveUser(ActionEvent event) {

    }

}
