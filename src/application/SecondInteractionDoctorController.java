package application;

import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondInteractionDoctorController {


    public SecondInteractionDoctorController() {
		
	}

	@FXML
    private Button loginDoctor;

    @FXML
    private Button registerDoctor;
    
    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    @FXML
    void actionBack(ActionEvent event) {
    	try{
			Parent root = FXMLLoader.load(getClass().getResource("first_interaction.fxml"));
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
    void actionLoginDoctor(ActionEvent event) {
    	 try{
 			
 			Parent root = FXMLLoader.load(getClass().getResource("LogInDoctor.fxml"));
 			Scene scene = new Scene(root);
 			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
 			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 		
 			stage.setScene(scene);
 			stage.show();
 		} catch(Exception e) {
 			e.printStackTrace();
 		}

     

    }

    @FXML
    void actionRegisterDoctor(ActionEvent event) {
    try{
			
			Parent root = FXMLLoader.load(getClass().getResource("RegisterDoctor.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
			stage.setScene(scene);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

    }

}




