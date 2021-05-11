package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import oncology.db.interfaces.UserMaster;
import oncology.db.pojos.users.*;
import oncology.db.jpa.JPAUserMaster;
import userInteraction.SubMenusDoctor;
import userInteraction.UserInteraction;
public class Menu {
	
	private static DBMaster dbmasterMenu;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static UserMaster userman = new JPAUserMaster();
	
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
				dbmasterMenu.disconnect();
				userman.disconnect();
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);
	}
		
		
		 private static void register() throws Exception {
		
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
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] hash = md.digest();
		User user = new User(email,hash,role);
		userman.newUser(user);
	}
	
		 
		private static void login() throws Exception {
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
				System.out.println("0. Exit");
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 7) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:
					UserInteraction.seeFamilyHistoryMenu();
					break;
				case 2:
					UserInteraction.printMedicalExaminationMenu();
					break;
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
				System.out.println("1. Family History");
				System.out.println("2. Medical Examination");
				System.out.println("3. Cancer");
				System.out.println("4. Treatment");
				System.out.println("0. Exit");
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 4) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
                    }
				switch (choice) {
				case 1:
					UserInteraction.seeFamilyHistoryMenu();
					break;
				case 2:
					UserInteraction.printMedicalExaminationMenu();
					break;
					
				case 3:
					UserInteraction.printCancerMenu();
					break;
					
				case 4:
					UserInteraction.assesTreatmentMenu();
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
		System.out.println("7.Act on patient's treatment");
		System.out.println("0.Exit");
			
		try {
				
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 7) {
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


			
		
	/*//dbmaster.connect();
	SubMenus.setDBMasterSubMenus(dbmasterMenu)
	while (true) {
		System.out.println("Choose an option:");
		System.out.println("1.Act on a patient");
		System.out.println("2.See all the patients");
		System.out.println("3.Act on family history");
		System.out.println("4.Act on symptoms");
		System.out.println("5.Act on medical examination");
		System.out.println("6.Act on patient's cancer");
		System.out.println("7.Act on patient's treatment");
		System.out.println("0.Exit");
		try {
			int choice = Integer.parseInt(reader.readLine());
			while (choice < 0 || choice > 7) {
				System.out.println("Choose an option within the range:");
				choice = Integer.parseInt(reader.readLine());
			}

			switch (choice) {
			case 1:

				SubMenus.patientSubmenu();
				break;
			case 2:
				SubMenus.showPatientsSubMenu();
				break;
			case 3:
				SubMenus.familyHistorySubmenu();
				break;
			case 4:
				SubMenus.symptomsSubmenu();
				break;
			case 5:
				SubMenus.medicalExaminationSubmenu();
				break;
			case 6:
				SubMenus.cancerSubmenu();
				break;
			case 7:
				SubMenus.treatmentSubmenu();
				break;
			
			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("An error has ocurred");
		}
	}

}*/
	
	
	


