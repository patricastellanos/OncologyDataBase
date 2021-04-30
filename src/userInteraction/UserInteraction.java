package userInteraction;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import oncology.db.pojos.Cancer;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Patient;
import oncology.db.pojos.Symptoms;
import oncology.db.pojos.Treatment;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;

public class UserInteraction {
	private static DBMaster dbmaster;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static List<Patient> patient_list = new ArrayList<Patient>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void setDBMaster(DBMaster dbm) {
		dbmaster=dbm;
	}

	// this method asks for the patient's name
	public static String printPatientNameMenu(){
		String name="";
		try {
		System.out.println("Please, input the patient's name:");
		name = reader.readLine();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return name;

	}

	// this method asks for the patient's surname
	public static String printPatientSurnameMenu(){
		System.out.println("Please, input the patient's surname:");
		String surname="";
		try {
			surname = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return surname;

	}

	// This method asks for the patient's actual state
	public static String printPatientStateMenu() throws IOException {
		
		int nactual_state=1;
		String actual_state="";
		try {
		do {
			System.out.println("Please, input the patient's actual state: ");
					System.out.println("1.ACUTE_REHABILITATION, 2.LOWSTREAM_REHABILITATION, "
							+ "3.COMPLEX_CARE, 4.CONVALESCENT_CARE, 5.PALLIATIVE_RESPITE, 6.RECOVERED, 7.DEATH");
			nactual_state = Integer.parseInt(reader.readLine());
		   switch (nactual_state) {
			   case 1: 
				   actual_state="ACUTE_REHABILITATION";
				   break;
			   case 2:
				   actual_state="LOWSTREAM_REHABILITATION";
				   break;
			   case 3: 
				   actual_state="COMPLEX_CARE";
				   break;
			   case 4:
				   actual_state="CONVALESCENT_CARE";
				   break;
			   case 5: 
				   actual_state="PALLIATIVE_RESPITE";
				   break;
			   case 6:
				   actual_state="RECOVERED";
				   break;
			   case 7: 
				   actual_state="DEATH";
				   break;
				   }

		} while (nactual_state<1 || nactual_state>7);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return actual_state;
	}
		
  
	
	

	// this method asks for the patient's sex
	public static String printPatientSexMenu() throws IOException {
		String sex="FEMALE";
		try {
		do {

			System.out.println("Please, input the patient's sex(MALE/FEMALE)");
			sex = reader.readLine().toUpperCase();

		} while (!sex.equalsIgnoreCase("MALE") && !sex.equalsIgnoreCase("FEMALE"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sex;
	}

	// this method asks for the patient's location
	public static String printPatientLocationMenu() {
		String location="HOME";
		try {
		do {

			System.out.println("Please, input the patient's location (HOME/HOSPITAL)");
			location = reader.readLine().toUpperCase();

		} while (!location.equalsIgnoreCase("HOME") && !location.equalsIgnoreCase("HOSPITAL"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return location;
	}

	// this method asks for the patient's date of birth
	public static LocalDate printPatientDateMenu(){
		LocalDate date_birth=null;
		try {
		System.out.println("Please, input the patient's date of birth (yyyy-MM-dd):");
	    date_birth = LocalDate.parse(reader.readLine(), formatter);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return date_birth;
	}
	//this method prints the details of the patient's symptoms
	public static String printSymptomsDetailMenu(){
		String detail="";
		try {
		System.out.println("Please, input the symptoms' detail:");
	    detail=reader.readLine();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return detail;
	}
	
	//this method is used to add a new patient to the db
	public static void addPatientMenu(){
		try {

		String name = printPatientNameMenu();
		String surname = printPatientSurnameMenu();
		String sex = printPatientSexMenu();
		LocalDate date_birth = printPatientDateMenu();
		String location = printPatientLocationMenu();
		String actual_state = printPatientStateMenu();

		dbmaster.addPatient(new Patient(name, surname, sex, Date.valueOf(date_birth), location, actual_state));//review
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//this method removes a patient from the db
	public static void removePatientMenu(){
		try {
		printPatientsMenu();
		System.out.println("Please, input the id of the patient:");
		Integer id= Integer.parseInt(reader.readLine());
		dbmaster.removePatient(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//this method shows all the patients in the db
	public static void printPatientsMenu(){
		try {
		patient_list = dbmaster.printPatients();
		for (int i = 0; i < patient_list.size(); i++) {
			System.out.println(patient_list.get(i));

		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    //this method is used to search a patient in the db by the name and surname
	public static void searchPatientMenu() { 
		System.out.println("Please, input the search term:");
		try {

		String name = printPatientNameMenu();
		String surname = printPatientSurnameMenu();
		List<Patient> p = dbmaster.searchPatientByName(name, surname);
		if (p.isEmpty()) {
			System.out.println("No results.");
		} else {
			System.out.println(p);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//this method is used to update a patient´s state
	public static void update_patient_stateMenu() {
		try {

		printPatientsMenu();
		System.out.println("Choose the id of the patient which you want to modify");
		Integer id = Integer.parseInt(reader.readLine());
		String actual_state = printPatientStateMenu();
		dbmaster.update_patient_state(id, actual_state);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void addCancerMenu() {
		
		try {
			printPatientsMenu();
			System.out.println("Please insert the id of the patient you want to add a cancer");
			int id_patient= Integer.parseInt(reader.readLine());
			System.out.println("Please insert the type of cancer");
			String cancer_type= reader.readLine();
			Cancer cancer=new Cancer(cancer_type);
			dbmaster.addCancer(cancer, id_patient);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	//this method is used in order to add a family history 
	public static void addFamilyHistoryMenu(){
		try {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want to add the family history");
		int id = Integer.parseInt(reader.readLine());
		System.out.println("Please, input the member's type of cancer:");

		String type_cancerFam = reader.readLine();
		
		System.out.println("Please, input the member with cancer:");
		String member = reader.readLine();
		FamilyHistory famHist= new FamilyHistory(null, type_cancerFam, member);
		dbmaster.addFamHistory(id,famHist);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	//this method is used to see a patient´s family history
	public static void seeFamilyHistoryMenu(){
		try {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want see its family history");
		int id = Integer.parseInt(reader.readLine());
		System.out.println(dbmaster.printFamHistory(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//this method is used to add new symptoms
	public static void addSymptomsMenu(){
		try {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want to add the symptoms");
		int id = Integer.parseInt(reader.readLine());

		String detail=printSymptomsDetailMenu();
		Symptoms s= new Symptoms(id,detail);
		
		dbmaster.addSymptoms(s, id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//this method removes all the symptoms associated to a patient
	public static void removeSymptomsMenu() {
		try {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you delete the symptoms");
		int id=Integer.parseInt(reader.readLine());
		dbmaster.removeSymptoms(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//this method prints all the symptoms of a desired patient
	public static void printSymptomsMenu() {
		try {
		List <Symptoms> symptom_listMenu=null;
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want see its symptoms");
		int id = Integer.parseInt(reader.readLine());
		symptom_listMenu = dbmaster.printPatientSymptoms(id);
		if(symptom_listMenu==null) {
			System.out.println("There are no symptoms associated with this patient");
		}else {
			System.out.println(symptom_listMenu = dbmaster.printPatientSymptoms(id));
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	//this method adds a new medical examination but WE HAVE TO DO ITTTTTTT!!!!!
	public static void addMedicalExaminationMenu(){//revisar el SQL
		try {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want to add the medical examination");
		int id = Integer.parseInt(reader.readLine());
		
		System.out.println("Please, input the type of medical examination");
		String medExam_type= reader.readLine();
		
		System.out.println("Please, input the medical examination's date (yyyy-MM-dd):");
	    LocalDate dateMedExam = LocalDate.parse(reader.readLine(), formatter);
	    
	    System.out.println("Please, input the diagnosis of the medical examination");
	    String diagnosis = reader.readLine();
	    
	    MedicalExamination m = new MedicalExamination(medExam_type, Date.valueOf(dateMedExam), diagnosis);
		

		dbmaster.addMedExam(m, id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	//this method prints the medical examination of a patient
	public static void printMedicalExaminationMenu(){
		try {
		printPatientsMenu();
		System.out.println("Choose the id of the patient from which you want see its medical examination");
		int id = Integer.parseInt(reader.readLine());
		System.out.println(dbmaster.printMedExamination(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	
	public static void addTreatmentMenu()  {
		
		try {
			printPatientsMenu();
			System.out.println("Choose the id of the patient which you want to add a treatment");
			int id_patient = Integer.parseInt(reader.readLine());
			System.out.println("Please, input the treatment's name:");

			String type_treat = reader.readLine();
			
			System.out.println("Please, input the startdate of the treatment (yyyy-MM-dd):");
			LocalDate startdate = LocalDate.parse(reader.readLine(), formatter);
			
			System.out.println("Please, input the duration of the treatment:");
			int duration = Integer.parseInt(reader.readLine());
			
			Treatment t= new Treatment(type_treat,Date.valueOf(startdate),duration);
			
			dbmaster.addTreatment(t, id_patient);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void assesTreatmentMenu() {
		try {
			printPatientsMenu();
			System.out.println("Choose the id of the patient which you want to asses");
			int id_patient= Integer.parseInt(reader.readLine());
			Treatment treat= dbmaster.assessTreatment(id_patient);
			System.out.println(treat);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void treatmentWorkoutMenu() {
		try {
			System.out.println("Choose the id of the patient which you want check the treatment");
			int id_patient= Integer.parseInt(reader.readLine());
			boolean result= dbmaster.treatment_worked(id_patient);
			System.out.println(result);
			/*if(result==true) {
				
			}else {
				
			}*/
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
