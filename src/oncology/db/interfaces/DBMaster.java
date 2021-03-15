package oncology.db.interfaces;

import java.util.List;

import oncology.db.pojos.Cancer;
import oncology.db.pojos.Patient;

public interface DBMaster {
	public void connect();
    public void disconnect();
	
	//Patient
    public void addPatient(Patient p);
    //public void removePatientByName(Patient p); 
    public List<Patient> removePatientByName(String name);
    public List<Patient> searchPatientByName(String name);
    /*
     * I think that we should implement in a method the evolution of the patient
     * Maybe in treatment (makes sense, to evaluate if the treatment works or not)
     * Maybe in medical examination or in patient (i think that treatment is the best one)
     */
   //Cancer
    public Cancer typeOfCancer(String name);
    /*
     *FOR TREATMENT (2)
     *
     *We need to know the type (maybe quimio,dismissed..)
     *public Treatment typeOfTreatment(String x); I do not know if it has to be the diagnosis, medical examination...
     *
     *If we do what i have proposed above; we are gonna have another method about patientState
     *
     *when we develop the code we have to take into account the decision of how long it lasts
     *FOR FAMILY HISTORY(1)
     *
     *I think that we only need a method that shows the historial of the patient´s family
     *public List <FamilyHistory> showFamHistorial(Patient p); 
     *
     *FOR SYMPTOMPS(1)
     *
     *I think that we only need a method to show them
     *public void showSymptomps(Patient p);
     *
     *FOR MEDICAL EXAMINATION
     *
     *A method to see the results
     *public void showPatientResults(Patient p);
     *A method to know what treatment is the best one (maybe we should put this one in treatment idk)
     *
     *
     *THIS IS ONLY AN IDEA, it is not complete
     *We will see in a few days because 4 BRAINS THINK MORE THAN ONE JAJAJ
     * */
     
}
