package application;

import java.security.MessageDigest;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.PasswordField;
import com.gluonhq.charm.glisten.control.TextField;

import javafx.stage.Stage;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.users.Role;
import oncology.db.pojos.users.User;

public class RegisterDoctorController {
	
	private static UserMaster userman = new JPAUserMaster();

	@FXML
    private PasswordField doctorPassword;

    @FXML
    private PasswordField doctorConfirmPassword;

    @FXML
    private Button RegisterDoctor;

    @FXML
    private TextField username;

    @FXML
    void actionConfirmPassword(ActionEvent event) {

    }

    @FXML
    void actionPassword(ActionEvent event) {

    }
    
    //public void register() throws Exception{
    	

    @FXML
    void actionRegister(ActionEvent event) {
    	try {
    		String usern = username.getText();
        	String password = doctorPassword.getText();
        	String confirmpassword = doctorConfirmPassword.getText();
        	Role role = new Role("doctor");
        	
        	MessageDigest md = MessageDigest.getInstance("MD5");
    		md.update(password.getBytes());
    		byte[] hash = md.digest();
        	
        	User user = new User(usern, hash, role);
        	
        	userman.newUser(user);

			Parent root = FXMLLoader.load(getClass().getResource("LogInDoctor.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

    }

}

