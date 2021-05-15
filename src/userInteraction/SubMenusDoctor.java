package userInteraction;

import java.io.BufferedReader;

import java.io.InputStreamReader;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;


public class SubMenusDoctor {
	private static DBMaster dbmasterSubMenuDoctor;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void setDBMasterSubMenus(DBMaster dbm2) {
		dbmasterSubMenuDoctor=dbm2;
	}
	
	public static void patientSubmenu() {
		
		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1. Add a patient");
			System.out.println("2. Search patient");
			System.out.println("3. Remove patient");
			System.out.println("4. Update patient´s cancer state");
			System.out.println("5. Back to the main menu");

			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 5) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
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
					return;
				default:
					break;
			
				}
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}
	}
	

	
	public static void showPatientsSubMenu() {
		UserInteraction.printPatientsMenu();
	}
	
	
	
	public static void familyHistorySubmenu() {
		while (true) {
			System.out.println("1. Add a family history");
			System.out.println("2. See the family history of a patient");
			System.out.println("3. Convert to XML file");
			System.out.println("4. Convert from XML to FamilyHistory");
			System.out.println("5. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 5) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:

					UserInteraction.addFamilyHistoryMenu();
					break;
				case 2:
					UserInteraction.seeFamilyHistoryMenu();
					break;
				case 3:
					UserInteraction.familyHistoryToXmlMenu();
				case 4: 
					UserInteraction.XmlToFamilyHistoryMenu();
				case 5:
					return;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}

	}
	
	public static void symptomsSubmenu() {
		while (true) {
			System.out.println("1. Add symptoms to a patient");
			System.out.println("2. Delete symptoms of a patient");
			System.out.println("3. See the symptoms of a patient");
			System.out.println("4. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 4) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:

					UserInteraction.addSymptomsMenu();
					break;
				case 2:
					UserInteraction.removeSymptomsMenu();
					break;
				case 3:
					UserInteraction.printSymptomsMenu();
					break;
				case 4:
					return;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}
		
	}
	public static void medicalExaminationSubmenu() {
		
		while (true) {
			System.out.println("1.Add a medical examination");
			System.out.println("2.See the medical examination of a patient");
			System.out.println("3. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 3) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:

					UserInteraction.addMedicalExaminationMenu();
					break;
				case 2:
					UserInteraction.printMedicalExaminationMenu();
					break;
				case 3:
					return;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}
	}
	
	public static void cancerSubmenu() {
		while (true) {
			System.out.println("1.Add patient's cancer");
			System.out.println("2.See cancer of a patient");
			System.out.println("3. Convert to XML");
			System.out.println("4. Convert from XML to Cancer");
			System.out.println("5. Convert the XML file created to HTML");
			System.out.println("6. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 6) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:

					UserInteraction.addCancerMenu();
					break;
				case 2:
					UserInteraction.printCancerMenu();
					break;
				
				case 3:
					UserInteraction.cancerToXmlMenu();
					
				case 4:
					UserInteraction.XmlToCancerMenu();
				case 5:
					UserInteraction.cancerXmlToHtml();
				case 6:
					return;
				default:
					break;
				}
				
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}
		
	}
	public static void treatmentSubmenu() {
		
		
		while (true) {
			System.out.println("1.Add a treatment for a patient");
			System.out.println("2.Asses a treatment from patient");
			System.out.println("3.Check patient´s treatment");
			System.out.println("4. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 4) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:

					UserInteraction.addTreatmentMenu();
					break;
				case 2:
					UserInteraction.assesTreatmentMenu();
					break;
				case 3:
					UserInteraction.treatmentWorkoutMenu();
					break;
				case 4:
					return;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}
	}
	
	
	
}
