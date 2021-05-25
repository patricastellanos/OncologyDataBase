package oncology.ui;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import oncology.db.interfaces.UserMaster;
import oncology.db.pojos.users.*;
import oncology.db.jpa.JPAUserMaster;
import userInteraction.SubMenusDoctor;
import userInteraction.SubMenusNurse;
import userInteraction.SubMenusPatient;
import userInteraction.UserInteraction;

public class Menu {
	
	private static SQLMaster dbmasterMenu =new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static UserMaster userman = new JPAUserMaster();
	private EntityManager em;

	
	public static void main(String[] args) throws Exception {
		
		//IT IS NOT USERMAN, WE HAVE TO DO IT AFTER DOING ALL THE METHODS
		// TO DO THE ROLE CLASS
		
		do {
			System.out.println("Choose an option:");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("0. Exit");
			int choice = Integer.parseInt(reader.readLine());
			switch (choice) {
			case 1:
				register();
				break;
			case 2:
				login();
				break;
			case 0:
				System.out.println("Data base closed");
				dbmasterMenu.disconnect();
				userman.disconnect();
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);
	}
		
	 public static void register() throws Exception {
			
	System.out.println("Please, write your email address:");
	String email = reader.readLine();
	System.out.println("Please write your password:");
	String password = reader.readLine();
	
	System.out.println(userman.getRolesList());
	System.out.println("Type the chosen role ID:");
	int id = Integer.parseInt(reader.readLine());
	Role role = userman.getRole(id);
	//System.out.println(role);
	// Generate the hash
	
	boolean userRepeated= userman.userNameTaken(email);
	if(userRepeated==true) {
		System.out.println("ERROR, exiting user");
	}else {

	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(password.getBytes());
	byte[] hash = md.digest();
	User user = new User(email, hash, role);
	userman.newUser(user);
	}
}

	 
	public static void login() throws Exception {
		// Ask the user for an email
		System.out.println("Please, write your email address:");
		String email = reader.readLine();
		// Ask the user for a password
		System.out.println("Please write your password:");
		String password = reader.readLine();
		User user = userman.checkPassword(email, password);
		if (user == null) {
			System.out.println("Wrong email or password");
			return;
		} else if (user.getRole().getName().equalsIgnoreCase("patient")) {
			patientMenu();
		} else if (user.getRole().getName().equalsIgnoreCase("doctor")) {
			doctorMenu();
		} else if (user.getRole().getName().equalsIgnoreCase("nurse")) {
			nurseMenu();
		}
		// Check the type of the user and redirect her to the proper menu
	}

	
		
		private static void patientMenu() throws Exception {
			do {
				System.out.println("Choose an option:");
				System.out.println("1. Family History");
				System.out.println("2. Medical Examination");
				System.out.println("3. Change password");
				System.out.println("0. Back to the main menu");
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 7) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:
					SubMenusPatient.familyHistorySubmenuPatient();
					break;
				case 2:
					SubMenusPatient.medicalExaminationSubmenuNurse();
					break;
				case 3:
					System.out.println("user");
					String email=reader.readLine();
					System.out.println("new password");
					String newPass=reader.readLine();
					userman.changePassword(email, newPass);
				case 0:
					return;
				default:
					break;
				}
			} while (true);
		}
			
			
		private static void nurseMenu() throws Exception {
			do {
				System.out.println("Choose an option:");
				
				System.out.println("1. See all the patients");
				System.out.println("2. Search a patient");
				System.out.println("3. Family History");
				System.out.println("4. Medical Examination");
				System.out.println("5. Cancer");
				System.out.println("6. See all the cancers");
				System.out.println("7. Treatment");
				System.out.println("0. Back to the main menu");
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 7) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
                    }
				switch (choice) {
				case 1:
					SubMenusNurse.showPatientsSubMenuNurse();
					break;
				case 2:
					SubMenusNurse.searchPatientSubMenuNurse();
					break;
				case 3:
					SubMenusNurse.familyHistorySubmenuNurse();
					break;
				case 4:
					SubMenusNurse.medicalExaminationSubmenuNurse();
					break;
					
				case 5:
					SubMenusNurse.cancerSubmenuNurse();
					break;
				case 6:
					SubMenusNurse.showCancersSubMenuNurse();
					break;
				case 7:
					SubMenusNurse.treatmentSubmenuNurse();
					break;
					
				case 0:
					return;
				
				}
			} while(true);
		}
			
		
	private static void doctorMenu() throws Exception {
		while (true) {
		System.out.println("Choose an option:");
		System.out.println("1.Act on a patient");
		System.out.println("2.See all the patients");
		System.out.println("3.Act on family history");
		System.out.println("4.Act on symptoms");
		System.out.println("5.Act on medical examination");
		System.out.println("6.Act on patient's cancer");
		System.out.println("7.See all the cancers");
		System.out.println("8.Act on patient's treatment");
		System.out.println("0.Back to the main menu");
			
		try {
				
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 8) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
                    }

				switch (choice) {
				case 1:

				SubMenusDoctor.patientSubmenu();
				break;
			case 2:
				SubMenusDoctor.showPatientsSubMenu();
				break;
			case 3:
				SubMenusDoctor.familyHistorySubmenu();
				break;
			case 4:
				SubMenusDoctor.symptomsSubmenu();
				break;
			case 5:
				SubMenusDoctor.medicalExaminationSubmenu();
				break;
			case 6:
				SubMenusDoctor.cancerSubmenu();
				break;
			case 7:
				SubMenusDoctor.showCancersSubMenuDoctor();
				break;
			case 8:
				SubMenusDoctor.treatmentSubmenu();
				break;
			case 0:
				dbmasterMenu.disconnect();
				System.out.println("Data base closed");
				System.exit(0);
				break;
			
				}
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
}


			
		
	
	
	
	


