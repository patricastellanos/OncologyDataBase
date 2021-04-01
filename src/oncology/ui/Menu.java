package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import userInteraction.UserInteraction;

/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Patient;*/



public class Menu {
	
	private static DBMaster dbmaster = new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	/*private static List<Patient> patient_list = new ArrayList();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");*/

	public static void main(String[] args) throws Exception {
		dbmaster.connect();
		while (true) {
			System.out.println("Choose an option:");
			System.out.println("1. Add a patient");
			System.out.println("2. Search patient");
			System.out.println("3. Remove patient");
			System.out.println("4. Update patient´s cancer state");
			System.out.println("5. Type of cancer according to the medical examination");
			System.out.println("6. See the patients");
			System.out.println("0. Exit");
			try {
				int choice = Integer.parseInt(reader.readLine());
				while (choice <= 0 || choice > 6) {
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
					UserInteraction.resultMedExaminationMenu();
					break;
				case 6:
					UserInteraction.printPatientsMenu();
					break;
				case 0:
					dbmaster.disconnect();
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
