package actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Cancer;
import oncology.db.pojos.Patient;

public class SQLMaster implements DBMaster {
	
  private Connection c;

	@Override
	public void connect() {

		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addPatient(Patient p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePatient(Patient p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Patient> searchPatientByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cancer typeOfCancer(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
