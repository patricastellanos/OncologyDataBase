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
   
    public void patientSymptoms(int id, String symptoms);
    public MedicalExamination infoSymptoms(Symptoms s);
    public Cancer resultMedExamination (MedicalExamination m);//the result will be cancer (type) of not (sane patient)
    public Treatment assesTreatment(Cancer c);
    public List<FamilyHistory> showFamHistorial(Patient p);
    public List<Patient> printPatients();
    public void update_patient_state(int id, String actual_state);
    public void addSymptoms(Symptoms s, int id_patient); //New method
    public void newMedExam(MedicalExamination m);
    //public void Diagnosis(MedicalExamination m, Cancer can); Lo comento porque da error
   

   
    

}
