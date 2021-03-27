package actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Cancer;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Patient;
import oncology.db.pojos.Symptoms;
import oncology.db.pojos.Treatment;

public class SQLMaster implements DBMaster {

	private Connection c;

	@Override
	public void connect() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/oncologyDB");
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
		try {
			// Close database connection
			c.close();
		} catch (SQLException e) {
			System.out.println("There was a problem while closing the database connection.");
			e.printStackTrace();
		}
	}

	private void createTables() {
		// If the tables are not created already, create them
		Statement stmt1;
		try {
			stmt1 = c.createStatement();
			// Create table patient
			String sql1 = "CREATE TABLE patient "
					+ "(id       INTEGER  PRIMARY KEY AUTOINCREMENT, "
					+ " name     TEXT     NOT NULL, "
					+ " surname     TEXT     NOT NULL, "
					+ " sex TEXT NOT NULL, "
					+ " date_birth DATE NOT NULL, " 
					+ " location TEXT NOT NULL, " 
					+ " actual_state TEXT NOT NULL, "
					+ " id_famHistory INTEGER REFERENCES family_history (id_famHistory) ON DELETE SET NULL )";
			stmt1.executeUpdate(sql1);
			
			// Create table cancer
			sql1 = "CREATE TABLE cancer " 
					+ "( id_cancer INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ " id_medExam REFERENCES medical_examinations (id_medExam) ON DELETE SET NULL, "
					+ " type TEXT NOT NULL )";
			//sql = "INSERT INTO cancer (type) "
			//+ "VALUES ('Liver');";

			stmt1.executeUpdate(sql1);
			
			// Create table cancer_treatment
			sql1 = "CREATE TABLE cancer_treatment " 
					+ "( id_cancer INTEGER REFERENCES cancer (id_cancer), "
					+ " id_treat INTEGER REFERENCES treatment (id_treatment), " 
					+ " PRIMARY KEY (id_cancer, id_treat ))";
			stmt1.executeUpdate(sql1);
			
			// Create table symptoms
			sql1 = "CREATE TABLE symptomps " 
					+ "(id_symp  INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " detail    TEXT     NOT NULL )";
			stmt1.executeUpdate(sql1);
			
			// Create table treatment
			sql1 = "CREATE TABLE treatment " 
					+ "(id_treat   INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " type    TEXT     NOT NULL, "
					+ " startdate     DATE NOT NULL, "
					+ " enddate DATE NOT NULL )";
			stmt1.executeUpdate(sql1);
			
			// Create table patient_symptoms
			sql1 = "CREATE TABLE patient_symptoms"
					+ "(id_patient INTEGER REFERENCES patient(id_patient) ON DELETE SET NULL, "
					+ " id_symp INTEGER REFERENCES symptoms(id_symp) ON DELETE SET NULL, "
					+ " PRIMARY KEY (id_patient, id_symp) )";

			stmt1.executeUpdate(sql1);
			
			// Create table family_history
			sql1 = "CREATE TABLE family_history "
					+  "(id_famHistory INTEGER PRIMARY KEY AUTOINCREMENT, "
					+  "  type TEXT, "
					+  "  member TEXT )";
					
			stmt1.executeUpdate(sql1);
			
			
			// Create table cancer_patient
			sql1 = "CREATE TABLE cancer_patient "
					+  "(id_cancer INTEGER REFERENCES cancer (id_cancer), "
					+  " id_patient INTEGER REFERENCES patient (id_patient), "
					+  " PRIMARY KEY (id_cancer, id_patient) )";
					
			stmt1.executeUpdate(sql1);
			stmt1.close();
		} catch (SQLException e) {
			//if (!e.getMessage().contains("already exists")) {
				e.printStackTrace();
			//}
		}

	}

	@Override
	public void addPatient(Patient p) {
		try{
			String sql="INSERT INTO patient (name, surname, sex, date_birth, location, actual_state) "
					+ "VALUES(?, ?, ?, ?)";
			PreparedStatement prep=c.prepareStatement(sql);
			prep.setString(1, p.getName());
			prep.setString(2, p.getSurname());
			prep.setString(3, p.getSex());
			prep.setDate(4, p.getDate_birth());
			prep.setString(5, p.getLocation());
			prep.setString(6, p.getActual_state());
			prep.executeUpdate();
			prep.close();
			}
			catch(Exception e){
			e.printStackTrace();
			}
			
	}

	
	
	public List<Patient> searchPatientByName (String name,String surname) { 
		// TODO Unsafe method, update later
		if(name==null) {
			name="";
		}
		List<Patient> patient_list = new ArrayList<Patient>();
		try {
			//String sql= SELECT * FROM patient WHERE name LIKE ? AND surname LIKE ?
			//PreparedStatement stm= c.prepareStatement(sql)
			//stmt.setString(1, "%" + name + "%");
			//stmt.setString(2, "%" + surname + "%");
			//ResultSet rs = stmt.executeQuery();
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM patient WHERE name,surname "
					+ " LIKE '%" + name + "% ' , '%"+ surname + "%'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int id = rs.getInt("id");
				String patientName = rs.getString("name");
				String patientSurname=rs.getString("surname");
				Patient p = new Patient (id, patientName,patientSurname);
				patient_list.add(p);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient_list;
	}
	
	
	
	public void removePatient(int patient_id) {
		// TODO Unsafe method, update later
		try {
			String sql = "DELETE FROM patient WHERE patient_id= ? " ;
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient_id);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@Override
	public Cancer resultMedExamination(MedicalExamination m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Treatment assesTreatment(Cancer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FamilyHistory> showFamHistorial(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Symptoms patientSymptoms(Patient p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MedicalExamination infoSymptoms(Symptoms s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> removePatientByName(String name, String surname) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//print patient and update the state (it can also be in the menu)
	
	//Method to assign a cancer to a patient (similar to hire method)
	//public void assignDiagnosis(Cancer can, Patient p) {
		//try {
		//String sql= "INSERT INTO cancer_patient (id_cancer, id_patient) VALUES (?,?)";
		//PreparedStatement prep= c.prepareStatement(sql);
		//prep.setInt(1, can.getId());
		//prep.setInt(2,p.getId());
		//prep.executeUpdate();
		//prep.close();
		//}catch(Exception e) {
			//e.printStackTrace();
		
		//}
		
	//}





}
