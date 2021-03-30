package oncology.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Patient;

public class Menu {
	
	
	private static DBMaster dbmaster = new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private List<Patient> patient_list=new ArrayList();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public static void main(String[] args) throws Exception {
		dbmaster.connect();
		do {
		System.out.println("Choose an option:");
		System.out.println("1. Add a patient");
		System.out.println("2. Search patient");
		System.out.println("3. Remove patient");
		System.out.println("4. Update patient´s cancer state");
		System.out.println("5. Type of cancer according to the medical examination");
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
		case 4:
			update_patient_stateMenu();
		case 5:
			resultMedExaminationMenu();
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
		String name = reader.readLine();
		System.out.println("Please, input the patient's surname:");
		String surname=reader.readLine();
		System.out.println("Please, input the patient's sex:");
		String sex=reader.readLine();
		System.out.println("Please, input the patient's date of birth (yyyy-MM-dd):");
		LocalDate date_birth=LocalDate.parse(reader.readLine(), formatter);
		System.out.println("Please, input the patient's actual state: ACUTE_REHABILITATION, SLOWSTREAM_REHABILITATION, COMPLEX_CARE, CONVALESCENT_CARE, PALLIATIVE_RESPITE");
		State actual_state=State.valueOf(reader.readLine().toUpperCase());
		System.out.println("Please, input the patient's location:");
		String location=reader.readLine();
		//dbmaster.addPatient(new Patient(name, surname, sex, Date.valueOf(date_birth), actual_state, location));
	}
	private static void removePatientMenu() throws Exception {
		dbmaster.printPatients();
		System.out.println("Please, input the patient's name:");
		System.out.println("Please, input the patient's surname:");
		
		String name = reader.readLine();
		String surname=reader.readLine();
		dbmaster.removePatientByName(name,surname);// cambiaria el metodo a removePatient(int id)
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
	private static void update_patient_stateMenu() throws Exception{
		
		dbmaster.printPatients();
		System.out.println("Choose the id of the patient which you want to modify");
		int id=Integer.parseInt(reader.readLine());
		System.out.println("Please, input the  new patient's actual state: ACUTE_REHABILITATION, SLOWSTREAM_REHABILITATION, COMPLEX_CARE, CONVALESCENT_CARE, PALLIATIVE_RESPITE");
		State actual_state=State.valueOf(reader.readLine().toUpperCase());
		dbmaster.update_patient_state(id,State.actual_state);
		
	}
	//method in order to know the type of cancer according to the medical examination result
	private static void resultMedExaminationMenu() throws Exception{
		dbmaster.printPatients();
		System.out.println("Choose the id of the patient from which you want to know the type of cancer");
		int id=Integer.parseInt(reader.readLine());
		
		
	}


}
