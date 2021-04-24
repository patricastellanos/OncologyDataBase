package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import userInteraction.UserInteraction;


public class Menu {
	
	private static DBMaster dbmaster = new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	/*private static List<Patient> patient_list = new ArrayList();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");*/

	public static void main(String[] args) throws Exception {
		dbmaster.connect();
		UserInteraction.setDBMaster(dbmaster);
		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1. Add a patient");
			System.out.println("2. Search patient");
			System.out.println("3. Remove patient");
			System.out.println("4. Update patient´s cancer state");
			System.out.println("5. Type of cancer according to the medical examination");
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
			} catch (Exception e) {
				System.out.println("An error has ocurred");
			}
		}

	}
	
	

}
