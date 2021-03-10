package actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Cancer;
import oncology.db.pojos.Patient;

public class SQLMaster implements DBMaster {
	
  private Connection c;

	@Override
	public void connect() {
			try {
				// Open database connection
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:./db/jobSeeker.db");
				c.createStatement().execute("PRAGMA foreign_keys=ON");
				System.out.println("Database connection opened.");
				this.createTables();
			} catch (SQLException sqlE) {
				System.out.println("There was a database exception.");
				sqlE.printStackTrace();
			} catch (Exception e) {
				System.out.println("There was a general exception.");
				e.printStackTrace();
			}
		

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
