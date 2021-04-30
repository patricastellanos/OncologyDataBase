package oncology.db.interfaces;

import java.util.List;

import oncology.db.pojos.Cancer;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Patient;
import oncology.db.pojos.Symptoms;
import oncology.db.pojos.Treatment;

public interface DBMaster {
	public void connect();
    public void disconnect();
	
    public void addPatient(Patient p);
    public void removePatient(int id);
    public List<Patient> searchPatientByName(String name,String surname);
    public void update_patient_state(int id, String actual_state);
    public List<Patient> printPatients();
    
    public FamilyHistory printFamHistory(int id);
    public void addFamHistory(int id,FamilyHistory famHist); //Modificar ER, DDL y createTables() y añadir foreign key en famHistory 
    
    public List<Symptoms> printPatientSymptoms(int id);
    public void addSymptoms(Symptoms s, int id_patient); 
    public void removeSymptoms(int id_patient);
   
    public MedicalExamination printMedExamination (int id);
    public void addMedExam(MedicalExamination m, int id);//deberíamos cambiarlo y pasarle tmb el id
    
    public void addCancer(Cancer cancer, int id_patient);
    public boolean diagnosis(MedicalExamination m, int id); //si no tiene cancer remove de db, //No en el menú(?)
   
    public void addTreatment(Treatment t, int id);
    public Treatment assessTreatment(int id_patient); //hay que hacer un insert de los treatments
    public boolean treatment_worked(int id_patient);  
    
    


}
