package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import userInteraction.UserInteraction;


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
			}else if (user.getRole().getName().equalsIgnoreCase("nurse")) {
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
		
		private static void NurseMenu() throws Exception {
			do {
				System.out.println("Choose an option:");
				System.out.println("1. See the patients");
				System.out.println("2. Search patient");
				System.out.println("3. Update patient큦 cancer state");
				System.out.println("4. Type of cancer according to the medical examination");//to do
				System.out.println("5. See the family history of a patient");
				System.out.println("6. See the symptoms of a patient");
				System.out.println("7. See the medical examination of a patient");
				System.out.println("0. Exit");
				int choice = Integer.parseInt(reader.readLine());
				switch (choice) {
				case 1:
					UserInteraction.printPatientsMenu();
					break;
				case 2:
					UserInteraction.searchPatientMenu();
					break;
				case 3:
					UserInteraction.update_patient_stateMenu();
					break;
				case 4: TO DO
				break;
				case 5:
				UserInteraction.seeFamilyHistoryMenu();
				break;
				case 6:
				UserInteraction.printSymptomsMenu();
				break;
				case 7:
				UserInteraction.printMedicalExaminationMenu();
				break;
					
				case 0:
					return;
				default:
					break;
				}
			} while (true);
		}*/

		
		
		
	/*	private static void DoctorMenu() throws Exception {
			do {
			System.out.println("1. Add a patient");
			System.out.println("2. Search patient");
			System.out.println("3. Remove patient");
			System.out.println("4. Update patient큦 cancer state");
			System.out.println("5. Type of cancer according to the medical examination");//to do
			System.out.println("6. See the patients");
			System.out.println("7. Add a family history");
			System.out.println("8. See the family history of a patient");
			System.out.println("9. Add symptoms to a patient");
			System.out.println("10. Delete symptoms of a patient");
			System.out.println("11. See the symptoms of a patient");
			System.out.println("12. Add a medical examination");
			System.out.println("13. See the medical examination of a patient");
			System.out.println("14. Add patient's cancer");
			System.out.println("0. Exit");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 14) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
                }

				switch (choice) {
				case 1:
				
					UserInteraction.addPatientMenu();
					break;
				case 2:
					UserInteraction.searchPatientMenu();
					break;
				case 3:
					UserInteraction.removePatientMenu();
					break;
				case 4:
					UserInteraction.update_patient_stateMenu();
					break;
				case 5:
					//complete
					break;
				case 6:
					UserInteraction.printPatientsMenu();
					break;
				case 7:
					UserInteraction.addFamilyHistoryMenu();
					break;
				case 8: 
					UserInteraction.seeFamilyHistoryMenu();
					break;
					
				case 9:
					UserInteraction.addSymptomsMenu();
					break;
				case 10: 
					UserInteraction.removeSymptomsMenu();
					break;
				case 11:
					UserInteraction.printSymptomsMenu();
					break;
				case 12:
					UserInteraction.addMedicalExaminationMenu();
					break;
				case 13:
					UserInteraction.printMedicalExaminationMenu();
					break;
				case 14:
					UserInteraction.addCancerMenu();
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
		UserInteraction.setDBMaster(dbmaster);
		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1. Add a patient");
			System.out.println("2. Search patient");
			System.out.println("3. Remove patient");
			System.out.println("4. Update patient큦 cancer state");
			System.out.println("5. Type of cancer according to the medical examination");//to do
			System.out.println("6. See the patients");
			System.out.println("7. Add a family history");
			System.out.println("8. See the family history of a patient");
			System.out.println("9. Add symptoms to a patient");
			System.out.println("10. Delete symptoms of a patient");
			System.out.println("11. See the symptoms of a patient");
			System.out.println("12. Add a medical examination");
			System.out.println("13. See the medical examination of a patient");
			System.out.println("14. Add patient's cancer");
			System.out.println("15. Add a treatment for a patient");
			System.out.println("16. Asses a treatment from patient");
			System.out.println("17. Check patient큦 treatment");
			System.out.println("0. Exit");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 17) {
					System.out.println("Choose an option within the range:");
                    choice =Integer.parseInt(reader.readLine());
                }

				switch (choice) {
				case 1:
				
					UserInteraction.addPatientMenu();
					break;
				case 2:
					UserInteraction.searchPatientMenu();
					break;
				case 3:
					UserInteraction.removePatientMenu();
					break;
				case 4:
					UserInteraction.update_patient_stateMenu();
					break;
				case 5:
					//complete
					break;
				case 6:
					UserInteraction.printPatientsMenu();
					break;
				case 7:
					UserInteraction.addFamilyHistoryMenu();
					break;
				case 8: 
					UserInteraction.seeFamilyHistoryMenu();
					break;
					
				case 9:
					UserInteraction.addSymptomsMenu();
					break;
				case 10: 
					UserInteraction.removeSymptomsMenu();
					break;
				case 11:
					UserInteraction.printSymptomsMenu();
					break;
				case 12:
					UserInteraction.addMedicalExaminationMenu();
					break;
				case 13:
					UserInteraction.printMedicalExaminationMenu();
					break;
				case 14:
					UserInteraction.addCancerMenu();
					break;
				case 15:
					UserInteraction.addTreatmentMenu();
					break;
				case 16:
					UserInteraction.assesTreatmentMenu();
					break;
				case 17:
					UserInteraction.treatmentWorkoutMenu();
					break;
				case 0:
					dbmaster.disconnect();
					System.out.println("Data base closed");
					System.exit(0);
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
