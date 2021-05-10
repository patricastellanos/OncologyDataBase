package application;
	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import actions.SQLMaster;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import oncology.db.interfaces.DBMaster;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.Patient;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;



public class Main extends Application {
	
	private static DBMaster dbmaster= new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static UserMaster userman = new JPAUserMaster();
	
	@Override
	public void start(Stage firstStage) {
		 try{
			 //dbmaster.connect();
			
			Parent root = FXMLLoader.load(getClass().getResource("first_interaction.fxml"));
			Scene scene = new Scene(root,650,650);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			firstStage.setScene(scene);
			firstStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	
		/*FXMLLoader loader = new FXMLLoader(getClass().getResource("/Users/agarc/git/OncologyDataBase/first_interaction.fxml"));
		
		Parent root = loader.load();
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
