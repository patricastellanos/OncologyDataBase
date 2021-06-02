package userInteraction;
import java.io.BufferedReader;

import java.io.InputStreamReader;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;

public class SubMenusPatient {
	private static DBMaster dbmasterSubMenuPatient;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void setDBMasterSubMenus(DBMaster dbm2) {
		dbmasterSubMenuPatient=dbm2;
	}	
		public static void familyHistorySubmenuPatient() {
			while (true) {
				System.out.println("1. See your family history ");
				System.out.println("2. Back to the main menu");
				try {
					int choice = Integer.parseInt(reader.readLine());
					while (choice < 0 || choice > 2) {
						System.out.println("Choose an option within the range:");
						choice = Integer.parseInt(reader.readLine());
					}
					switch (choice) {
					case 1:
						UserInteraction.seeFamilyHistoryMenu();
						break;
					case 2:
						return;
					default:
						break;
					}
				} catch (Exception e) {
					System.out.println("An error has ocurred");
				}
			}

		}
		
		 public static void medicalExaminationSubmenuPatient() {
				
				while (true) {
					System.out.println("1.See your medical examination");
					System.out.println("2. Back to the main menu");
					try {
						int choice = Integer.parseInt(reader.readLine());
						while (choice < 0 || choice > 2) {
							System.out.println("Choose an option within the range:");
							choice = Integer.parseInt(reader.readLine());
						}
						switch (choice) {
						case 1:
							UserInteraction.printMedicalExaminationMenu();
							break;
						case 2:
							return;
						}
					} catch (Exception e) {
						System.out.println("An error has ocurred");
					}
				}
			}
		 
		 public static void infoPatientSubmenuPatient() {
				while (true) {
					System.out.println("1. See your information ");
					System.out.println("2. Back to the main menu");
					try {
						int choice = Integer.parseInt(reader.readLine());
						while (choice < 0 || choice > 2) {
							System.out.println("Choose an option within the range:");
							choice = Integer.parseInt(reader.readLine());
						}
						switch (choice) {
						case 1:
							UserInteraction.seeInfoPatientMenu();
							break;
						case 2:
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
