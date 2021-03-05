package oncology.db.interfaces;

import java.util.List;

import oncology.db.pojos.Cancer;
import oncology.db.pojos.Patient;

public interface DBMaster {
	public void connect();
    public void disconnect();
	
	//Patient
    public void addPatient(Patient p);
    public void removePatient(Patient p);
    public List<Patient> searchPatientByName(String name);
   //Cancer
    public Cancer typeOfCancer(String name);
    
}
