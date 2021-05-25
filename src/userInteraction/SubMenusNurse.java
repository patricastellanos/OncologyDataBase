package userInteraction;
import java.io.BufferedReader;

import java.io.InputStreamReader;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;

public class SubMenusNurse {
	private static DBMaster dbmasterSubMenuNurse;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void setDBMasterSubMenus(DBMaster dbm2) {
		dbmasterSubMenuNurse=dbm2;
	}
	
	public static void showPatientsSubMenuNurse() {
		UserInteraction.printPatientsMenu();
	}
	
	public static void searchPatientSubMenuNurse() {
		UserInteraction.searchPatientMenu();
	}
	
	public static void familyHistorySubmenuNurse() {
		while (true) {
			System.out.println("1. See the family history of a patient");
			System.out.println("2. Convert to XML file");
			System.out.println("3. Convert from XML to FamilyHistory");
			System.out.println("4. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 4) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:
					UserInteraction.seeFamilyHistoryMenu();
					break;
				case 2:
					UserInteraction.familyHistoryToXmlMenu();
					break;
				case 3:
					UserInteraction.XmlToFamilyHistoryMenu();
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
	
      public static void medicalExaminationSubmenuNurse() {
		
		while (true) {
			System.out.println("1.See the medical examination of a patient");
			System.out.println("2.See the medical examination of all the patients");
			System.out.println("3. Back to the main menu");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice < 0 || choice > 3) {
					System.out.println("Choose an option within the range:");
					choice = Integer.parseInt(reader.readLine());
				}
				switch (choice) {
				case 1:
					UserInteraction.printMedicalExaminationMenu();
					break;
				case 2:
					UserInteraction.printAllMedicalExaminationsMenu();
				case 3:
					return;
				}
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}
	}
      public static void cancerSubmenuNurse() {
  		while (true) {
  			System.out.println("1.See cancer of a patient");
  			System.out.println("2. Convert to XML");
  			System.out.println("3. Convert from XML to Cancer");
  			System.out.println("4. Back to the main menu");
  			try {
  				int choice = Integer.parseInt(reader.readLine());
  				while (choice < 0 || choice > 4) {
  					System.out.println("Choose an option within the range:");
  					choice = Integer.parseInt(reader.readLine());
  				}
  				switch (choice) {
  				case 1:
  					UserInteraction.printCancerMenu();
  					break;
  				case 2:
  					UserInteraction.cancerToXmlMenu();
  					break;
  				case 3:
  					UserInteraction.XmlToCancerMenu();
  					break;
  				case 4:
  					return;
  					
  				}
  				
  			} catch (Exception e) {
  				System.out.println("An error has ocurred");
  			}
  		}
  		
  	}
      public static void showCancersSubMenuNurse() {
  		UserInteraction.printCancersMenu();
  	}
      
      public static void treatmentSubmenuNurse() {
  		
  		
  		while (true) {
  			System.out.println("1.Asses a treatment from patient");
  			System.out.println("2.Check patient´s treatment");
  			System.out.println("3. Back to the main menu");
  			try {
  				int choice = Integer.parseInt(reader.readLine());
  				while (choice < 0 || choice > 3) {
  					System.out.println("Choose an option within the range:");
  					choice = Integer.parseInt(reader.readLine());
  				}
  				switch (choice) {
  				case 1:
  					UserInteraction.printTreatmentMenu();
  					break;
  					
  				case 2:
  					UserInteraction.treatmentWorkoutMenu();
  					
  				case 3:
  					return;
  					
  				}
  			} catch (Exception e) {
  				System.out.println("An error has ocurred");
  			}
  		}
  	}
  	
  	
	

}
