package userInteraction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import actions.SQLMaster;
import oncology.db.interfaces.DBMaster;
import oncology.db.interfaces.UserMaster;
import oncology.db.jpa.JPAUserMaster;
import oncology.db.pojos.Cancer;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Patient;
import oncology.db.pojos.Symptoms;
import oncology.db.pojos.Treatment;
import oncology.db.pojos.users.User;

public class UserInteraction {
	
	private static DBMaster dbmaster= new SQLMaster();
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static List<Patient> patient_list = new ArrayList<Patient>();
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static UserMaster userman = new JPAUserMaster();
	private static List<Cancer> cancer_list = new ArrayList<Cancer>();
	private static List<Treatment> treat_list = new ArrayList<Treatment>();
	private static List<MedicalExamination> medExam_list = new ArrayList<MedicalExamination>();
	
	
	public static void setDBMasterUI(DBMaster dbm) {
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
	
	public static String printIDNumberMenu(){
		String IDNumber=null;
		try {
		System.out.println("Please, input the patient's ID number:");
	    IDNumber = reader.readLine();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return IDNumber;
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
        String IDNumber = printIDNumberMenu();
		String name = printPatientNameMenu();
		String surname = printPatientSurnameMenu();
		String sex = printPatientSexMenu();
		LocalDate date_birth = printPatientDateMenu();
		String location = printPatientLocationMenu();
		String actual_state = printPatientStateMenu();

		dbmaster.addPatient(new Patient(IDNumber, name, surname, sex, Date.valueOf(date_birth), location, actual_state));//review
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
			List <Cancer> insertedCancer = dbmaster.printCancers();
			System.out.println("Please insert the type of cancer");
			String cancer_type= reader.readLine();
			if(insertedCancer.size()==0) {
				Cancer cancer=new Cancer(cancer_type);
				dbmaster.addCancer(cancer, id_patient);
			}else {
				for(int i=0; i<insertedCancer.size(); i++) {
					if(insertedCancer.get(i).getCancer_type().equalsIgnoreCase(cancer_type)) {
						dbmaster.addExistingCancer(insertedCancer.get(i).getId_cancer(), id_patient);
						break;
						
					}else {
						Cancer cancer=new Cancer(cancer_type);
						dbmaster.addCancer(cancer, id_patient);
						break;
					}
					
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void printCancerMenu() {
		
		try {
			printPatientsMenu();
			System.out.println("Choose the id of the patient");
			int id = Integer.parseInt(reader.readLine());
			System.out.println(dbmaster.printCancersPatient(id));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printCancersMenu(){
		try {
		cancer_list = dbmaster.printCancers();
		for (int i = 0; i < cancer_list.size(); i++) {
			System.out.println(cancer_list.get(i));

		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cancerToXmlMenu() {
		try {
			System.out.print("Choose a cancer to turn into an XML file:");
			printCancersMenu();
			int can_id = Integer.parseInt(reader.readLine());
			dbmaster.cancerToXml(can_id);
			
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void XmlToCancerMenu() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Cancer.class);
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			File file = new File("./xmls/Cancer.xml");
			Cancer can = (Cancer) unmarshaller.unmarshal(file);
			
			System.out.println("Cancer:");
			System.out.println("Type: " + can.getCancer_type());
			List<Patient> p = can.getPatients();
		    System.out.println(p);
		    
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cancerXmlToHtml () {
		dbmaster.simpleTransform("./xmls/Cancer.xml", "./xmls/Cancer.xslt", "./xmls/Cancer.html");
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
	
	public static void familyHistoryToXmlMenu() {
		try {
			printPatientsMenu();
			System.out.print("Choose a patient to turn its family history into an XML file:");
			int patient_id = Integer.parseInt(reader.readLine());
			dbmaster.familyHistoryToXml(patient_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
	
	public static void XmlToFamilyHistoryMenu() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(FamilyHistory.class);
		    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

			File file = new File("./xmls/FamilyHistory.xml");
			FamilyHistory famhist = (FamilyHistory) unmarshaller.unmarshal(file);
			
			System.out.println("Family History:");
			System.out.println("Type: " + famhist.getType_cancerFam());
			System.out.println("Member: " + famhist.getMember());
			
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void familyHistoryXmlToHtml () {
		dbmaster.simpleTransform("./xmls/FamilyHistory.xml", "./xmls/FamilyHistory.xslt", "./xmls/FamilyHistory.html");
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
		/*System.out.println("Choose the id of the symptom you want to delete");
		int idSymp=Integer.parseInt(reader.readLine());*/
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
	
	public static void addMedicalExaminationMenu(){
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
		System.out.println(dbmaster.printMedExamPatient(id));
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
	public static void printAllMedicalExaminationsMenu(){
		try {
		medExam_list = dbmaster.printAllMedExam();
		for (int i = 0; i < medExam_list.size(); i++) {
			System.out.println(medExam_list.get(i));

		}
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
	
	public static void printTreatmentMenu() {
		try {
			printPatientsMenu();
			System.out.println("Choose the id of the patient which you want to asses");
			int id_patient= Integer.parseInt(reader.readLine());
			try {
				treat_list = dbmaster.seeTreatment(id_patient);
				for (int i = 0; i < treat_list.size(); i++) {
					System.out.println(treat_list.get(i));

				}
				}catch(Exception e) {
					e.printStackTrace();
				}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void removeTreatmentMenu() {
		try {
			printPatientsMenu();
			System.out.println("Choose the id of the patient which you want to delete a treatment");
			int id_patient=Integer.parseInt(reader.readLine());
			//IMPRIME LOS TREATMENT 
			try {
				treat_list = dbmaster.seeTreatment(id_patient);
				for (int i = 0; i < treat_list.size(); i++) {
					System.out.println(treat_list.get(i));

				}
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			System.out.println("Choose the id of the treatment which you want to delete");
			int id_treat=Integer.parseInt(reader.readLine());
			dbmaster.removeTreatment(id_patient, id_treat);
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void treatmentWorkoutMenu() {
		try {
			printPatientsMenu();
			System.out.println("Choose the id of the patient which you want check the treatment");
			int id_patient= Integer.parseInt(reader.readLine());
			boolean result= dbmaster.treatment_worked(id_patient);
			//System.out.println(result);
			String patientState=dbmaster.printActualState(id_patient);
			
			if(result==true) {
				System.out.println("Patient deleted because the state was "+patientState);
				dbmaster.removePatient(id_patient);
			}else {
				System.out.println("Patient state:"+patientState+" (no modifications)");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changePasswordMenu() {
		
		try {
			System.out.println("Please write your email");
			String email= reader.readLine();
			System.out.println("Please write your new password");
			String newPass1=reader.readLine();
			System.out.println("Please confirm your new password");
			String newPass2=reader.readLine();
			
			if(!newPass1.equals(newPass2)) {
				System.out.println("Error, repeat the action");
			}else {
			userman.changePassword(email, newPass1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void removeUserMenu() {
		
		try {
			System.out.println("Please write your email");
			 String email2 = reader.readLine();
			System.out.println("Please write your password");
			String pass=reader.readLine();
			User u=userman.getUser(email2);
			//System.out.println(u);
			
			/*if(u==null) {
				System.out.println("Not existing user");
			}else {
				userman.removeUser(email2, pass);
				System.out.println("User deleted");
			}*/
			
			userman.removeUser(email2, pass);
			System.out.println("User deleted");
			
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
