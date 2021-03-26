package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Patient;

public class Menu {
	
	
	private static DBMaster dbmaster = new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private List<Patient> patient_list=new ArrayList();
	public static void main(String[] args) throws Exception {
		dbmaster.connect();
		do {
		System.out.println("Choose an option:");
		System.out.println("1. Add a patient");
		System.out.println("2. Search patient");
		System.out.println("3. Remove patient");
		//create a method about show the list patient
		System.out.println("0. Exit");
		int choice = Integer.parseInt(reader.readLine());
		switch (choice) {
		case 1:
			addPatientMenu();
			break;
		case 2:
			searchPatientMenu();
			break;
		case 3:
			removePatientMenu();
		case 0:
			dbmaster.disconnect();
			System.exit(0);
			break;
		default:
			break;
		}
		} while (true);
		
	}
	
	private static void addPatientMenu() throws Exception {
		System.out.println("Please, input the patient's name:");
		System.out.println("Please, input the patient's surname:");
		System.out.println("Please, input the patient's sex:");
		System.out.println("Please, input the patient's date of birth:");
		System.out.println("Please, input the patient's location:");
		System.out.println("Please, input the patient's actual state:");
		
		String name = reader.readLine();
		String surname=reader.readLine();
		String sex=reader.readLine();
		String date_birth=reader.readLine();
		String location=reader.readLine();
		String actual_state=reader.readLine();
		dbmaster.addPatient(new Patient(name, surname,sex,date_birth,location,actual_state));//change constructor
	}
	private static void removePatientMenu() throws Exception {
		System.out.println("Please, input the patient's name:");
		System.out.println("Please, input the patient's surname:");
		
		String name = reader.readLine();
		String surname=reader.readLine();
		dbmaster.removePatientByName(name,surname);
	}
	
	
	private static void searchPatientMenu() throws Exception {
		System.out.println("Please, input the search term:");
		System.out.print("Name contains: ");
		System.out.print("Surname contains: ");
		String name = reader.readLine();
		String surname = reader.readLine();
		List<Patient> p = dbmaster.searchPatientByName(name,surname);//ask
		if (p.isEmpty()) {
			System.out.println("No results.");
		}
		else {
			System.out.println(p);
		}
	}
	//add questions about 


}
