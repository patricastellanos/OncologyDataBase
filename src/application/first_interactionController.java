package application;

import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;


public class first_interactionController extends Application {
	
	@FXML private Button D;
	@FXML private Button N;
	@FXML private Button P;
	
	@FXML
    void accionD(ActionEvent event) throws IOException {
		Parent loginParent = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene loginScene= new Scene(loginParent);
		
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		window.setScene(loginScene);
		window.show();
		
		

    }

    @FXML
    void accionN(ActionEvent event) {

    }

    @FXML
    void accionP(ActionEvent event) {

    }

	public void start(String[] arg0) throws Exception {
		// TODO Auto-generated method stub
		launch(arg0);
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
