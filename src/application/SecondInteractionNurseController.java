package application;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondInteractionNurseController {
	
	  public SecondInteractionNurseController() {
			
		}

	  @FXML
	    private Button loginNurse;

	    @FXML
	    private Button registerNurse;
	    
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
	    void actionLoginNurse(ActionEvent event) {
	    	try{
	 			
	 			Parent root = FXMLLoader.load(getClass().getResource("LoginNurse.fxml"));
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
	    void actionRegisterNurse(ActionEvent event) {
	    	 try{
	 			
	 			Parent root = FXMLLoader.load(getClass().getResource("RegisterNurse.fxml"));
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

	




