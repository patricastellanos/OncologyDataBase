package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import userInteraction.SubMenus;
public class Menu {
	
	private static DBMaster dbmaster = new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		
		//IT IS NOT USERMAN, WE HAVE TO DO IT AFTER DOING ALL THE METHODS
		// TO DO THE ROLE CLASS
		/*
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
				dbman.disconnect();
				userman.disconnect();
				System.exit(0);
				break;
			default:
				break;
			}
		} while (true);
		*/
		
		/* 
		 private static void register() throws Exception {
		// Ask the user for an email
		System.out.println("Please, write your email address:");
		String email = reader.readLine();
		// Ask the user for a password
		System.out.println("Please write your password:");
		String password = reader.readLine();
		// List the roles
		System.out.println(userman.getRoles());
		// Ask the user for a role
		System.out.println("Type the chosen role ID:");
		int id = Integer.parseInt(reader.readLine());
		Role role = userman.getRole(id);
		// Generate the hash
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] hash = md.digest();
		User user = new User(email, hash, role);
		userman.newUser(user);
	}*/
	/*	
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
				adminMenu();
			} else if (user.getRole().getName().equalsIgnoreCase("doctor")) {
				userMenu();
			}
			// Check the type of the user and redirect her to the proper menu
		}

		private static void PatientMenu() throws Exception {
			do {
				System.out.println("Choose an option:");
				System.out.println("1. See my family history");
				System.out.println("2. See my medical examination");
				System.out.println("0. Exit");
				int choice = Integer.parseInt(reader.readLine());
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
			
		
	/*	private static void DoctorMenu() throws Exception {
			do {
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

				SubMenus.PatientSubmenu();
				break;
			case 2:
				SubMenus.ShowPatientsSubMenu();
				break;
			case 3:
				SubMenus.FamilyHistorySubmenu();
				break;
			case 4:
				SubMenus.SymptomsSubmenu();
				break;
			case 5:
				SubMenus.MedicalExaminationSubmenu();
				break;
			case 6:
				SubMenus.CancerSubmenu();
				break;
			case 7:
				SubMenus.TreatmentSubmenu();
				break;
				case 0:
					dbmaster.disconnect();
					System.out.println("Data base closed");
					System.exit(0);
					break;
				default:
					break;
				}
				}
			} while (true);
		}*/

			
		
	dbmaster.connect();
	SubMenus.setDBMaster(dbmaster);
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

				SubMenus.PatientSubmenu();
				break;
			case 2:
				SubMenus.ShowPatientsSubMenu();
				break;
			case 3:
				SubMenus.FamilyHistorySubmenu();
				break;
			case 4:
				SubMenus.SymptomsSubmenu();
				break;
			case 5:
				SubMenus.MedicalExaminationSubmenu();
				break;
			case 6:
				SubMenus.CancerSubmenu();
				break;
			case 7:
				SubMenus.TreatmentSubmenu();
				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("An error has ocurred");
		}
	}

}
	
	
	

}
