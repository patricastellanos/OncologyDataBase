package userInteraction;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import oncology.db.pojos.Patient;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;

public class UserInteraction {
	private static DBMaster dbmaster = new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static List<Patient> patient_list = new ArrayList();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void addPatientMenu() throws Exception {

		String name = printPatientNameMenu();
		String surname = printPatientSurnameMenu();
		String sex = printPatientSexMenu();
		LocalDate date_birth = printPatientDateMenu();
		String location = printPatientLocationMenu();
		String actual_state = printPatientStateMenu();

		dbmaster.addPatient(new Patient(name, surname, sex, Date.valueOf(date_birth), location, actual_state));
	}

	// this method ask about the patient's name
	public static String printPatientNameMenu() throws IOException {
		System.out.println("Please, input the patient's name:");
		String name = reader.readLine();
		return name;

	}

	// this method ask about the patient's surname
	public static String printPatientSurnameMenu() throws IOException {
		System.out.println("Please, input the patient's surname:");
		String surname = reader.readLine();
		return surname;

	}

	// This method ask about the patient's actual state
	public static String printPatientStateMenu() throws IOException {
		System.out.println(
				"Please, input the patient's actual state: ACUTE_REHABILITATION, SLOWSTREAM_REHABILITATION, COMPLEX_CARE, CONVALESCENT_CARE, PALLIATIVE_RESPITE");
		String actual_state;
		do {

			actual_state = reader.readLine().toUpperCase();

		} while (!actual_state.equalsIgnoreCase("ACUTE_REHABILITATION")
				&& !actual_state.equalsIgnoreCase("SLOWSTREAM_REHABILITATION")
				&& !actual_state.equalsIgnoreCase("COMPLEX_CARE") && !actual_state.equalsIgnoreCase("CONVALESCENT_CARE")
				&& !actual_state.equalsIgnoreCase("PALLIATIVE_RESPITE"));
		return actual_state;
	}

	// this method ask about the patient's sex
	public static String printPatientSexMenu() throws IOException {
		String sex;
		do {

			System.out.println("Please, input the patient's sex(MALE/FEMALE)");
			sex = reader.readLine().toUpperCase();

		} while (!sex.equalsIgnoreCase("MALE") && !sex.equalsIgnoreCase("FEMALE"));
		return sex;
	}

	// this method ask about the patient's location
	public static String printPatientLocationMenu() throws IOException {
		String location;
		do {

			System.out.println("Please, input the patient's location (HOME/HOSPITAL)");
			location = reader.readLine().toUpperCase();

		} while (!location.equalsIgnoreCase("HOME") && !location.equalsIgnoreCase("HOSPITAL"));
		return location;
	}

	// this method ask about the patient's date of birth
	public static LocalDate printPatientDateMenu() throws IOException {
		System.out.println("Please, input the patient's date of birth (yyyy-MM-dd):");
		LocalDate date_birth = LocalDate.parse(reader.readLine(), formatter);
		return date_birth;
	}

	public static void removePatientMenu() throws Exception {
		printPatientsMenu();
		String name = printPatientNameMenu();
		String surname = printPatientSurnameMenu();
		dbmaster.removePatientByName(name, surname);// cambiaria el metodo a removePatient(int id)
	}

	public static void searchPatientMenu() throws Exception {
		System.out.println("Please, input the search term:");

		String name = printPatientNameMenu();
		String surname = printPatientSurnameMenu();
		List<Patient> p = dbmaster.searchPatientByName(name, surname);
		if (p.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(p);
		}
	}

	public static void update_patient_stateMenu() throws Exception {

		printPatientsMenu();
		System.out.println("Choose the id of the patient which you want to modify");
		Integer id = Integer.parseInt(reader.readLine());
		String actual_state = printPatientStateMenu();

		dbmaster.update_patient_state(id, actual_state);

	}

	// method in order to know the type of cancer according to the medical
	// examination result
	public static void resultMedExaminationMenu() throws Exception {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want to know the type of cancer");
		int id = Integer.parseInt(reader.readLine());
		// complete

	}

	public static void printPatientsMenu() throws Exception {
		patient_list = dbmaster.printPatients();
		for (int i = 0; i < patient_list.size(); i++) {
			System.out.println(patient_list.get(i));

		}
	}

}
