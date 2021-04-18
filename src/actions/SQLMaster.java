package actions;

import java.sql.Connection;
import java.sql.Date;
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
			c = DriverManager.getConnection("jdbc:sqlite:./db/oncology.db");
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
			// Create table family_history
			String sql1 = "CREATE TABLE family_history " + "( id_famHistory INTEGER PRIMARY KEY AUTOINCREMENT, "
								+ "  type TEXT, " + "  member TEXT ," + "patient_id REFERENCES patient (id) ON DELETE SET NULL )";
			stmt1.executeUpdate(sql1);
						
			// Create table patient
			 sql1 = "CREATE TABLE patient " + "( id INTEGER  PRIMARY KEY AUTOINCREMENT, "
					+ " name TEXT NOT NULL, " + " surname TEXT NOT NULL, " + " sex TEXT NOT NULL, "
					+ " date_birth DATE NOT NULL, " + " location TEXT NOT NULL, " + " actual_state TEXT NOT NULL, "
					+ " id_famHistory INTEGER REFERENCES family_history (id_famHistory) ON DELETE SET NULL )";
			stmt1.executeUpdate(sql1);
			
			//Create the table medical examination
			sql1= "CREATE TABLE medical_examination " + "(id_medExam INTEGER PRIMARY KEY AUTOINCREMENT, "
			      + " medExam_type TEXT NOT NULL, " + " dateMedExam DATE NOT NULL )";
			stmt1.executeUpdate(sql1);

			// Create table cancer
			sql1 = "CREATE TABLE cancer " + "( id_cancer INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ " id_medExam REFERENCES medical_examinations (id_medExam) ON DELETE SET NULL, "
					+ " type TEXT NOT NULL )";
			// sql = "INSERT INTO cancer (type) "
			// + "VALUES ('Liver');";
			stmt1.executeUpdate(sql1);
			
			// Create table treatment
			sql1 = "CREATE TABLE treatment " + "( id_treat   INTEGER  PRIMARY KEY AUTOINCREMENT,"
				    + " type    TEXT     NOT NULL, " + " startdate     DATE NOT NULL, " + " enddate DATE NOT NULL )";
			stmt1.executeUpdate(sql1);
			
			// Create table symptoms
			sql1 = "CREATE TABLE symptoms " + "( id_symp  INTEGER  PRIMARY KEY AUTOINCREMENT,"
				   + " detail    TEXT     NOT NULL )";
			stmt1.executeUpdate(sql1);

			// Create table cancer_treatment
			sql1 = "CREATE TABLE cancer_treatment " + "( id_cancer INTEGER REFERENCES cancer (id_cancer), "
					+ " id_treat INTEGER REFERENCES treatment (id_treatment), "
					+ " PRIMARY KEY (id_cancer, id_treat ))";
			stmt1.executeUpdate(sql1);

			// Create table patient_symptoms
			sql1 = "CREATE TABLE patient_symptoms"
					+ "( id INTEGER REFERENCES patient(id) ON DELETE SET NULL, "
					+ " id_symp INTEGER REFERENCES symptoms(id_symp) ON DELETE SET NULL, "
					+ " PRIMARY KEY (id, id_symp) )";

			stmt1.executeUpdate(sql1);

			// Create table cancer_patient
			sql1 = "CREATE TABLE cancer_patient " + "( id_cancer INTEGER REFERENCES cancer (id_cancer), "
					+ " id INTEGER REFERENCES patient (id), "
					+ " PRIMARY KEY (id_cancer, id) )";

			stmt1.executeUpdate(sql1);
			stmt1.close();
		} catch (SQLException e) {
			if (!e.getMessage().contains("already exists")) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void addPatient(Patient p) {
		try {
			String sql = "INSERT INTO patient (name, surname, sex, date_birth, location, actual_state) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, p.getName());
			prep.setString(2, p.getSurname());
			prep.setString(3, p.getSex());
			prep.setDate(4, p.getDate_birth());
			prep.setString(5, p.getLocation());
			prep.setString(6, p.getActual_state());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void removePatient(int id) {
		// TODO Unsafe method, update later
		try {
			String sql = "DELETE FROM patient WHERE id= ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List<Patient> searchPatientByName(String name, String surname) {
		// TODO Unsafe method, update later
		if (name == null) {
			name = "";
		}
		List<Patient> patient_list = new ArrayList<Patient>();
		try {

			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM patient WHERE name LIKE '%" + name + "%' AND surname LIKE '%" + surname + "%'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) { // true: there is another result and I have advanced to it
								// false: there are no more results
				int id = rs.getInt("id");
				String patientName = rs.getString("name");
				String patientSurname = rs.getString("surname");
				String sex=rs.getString("sex");
				String location=rs.getString("location");
				String actual_state=rs.getString("actual_state");
				Date date_birth=rs.getDate("date_birth");
				Patient p = new Patient(id, patientName, patientSurname, sex,date_birth, location, actual_state);
				patient_list.add(p);
				
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patient_list;
	}

	//Update patient state
		public void update_patient_state(int id, String actual_state) {
			try {
				String sql = "UPDATE patient SET actual_state=? WHERE id=?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, actual_state);
				prep.setInt(2, id);
				prep.executeUpdate();
				System.out.println("Update finished.");
				prep.close();
				

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		public List<Patient> printPatients() {
			
			List <Patient> patient_list=new ArrayList<Patient>();
			try {
				Statement stmt = c.createStatement();
				String sql = "SELECT * FROM patient";
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					Integer id_patient = rs.getInt("id");
					String name = rs.getString("name");
					String surname = rs.getString("surname");
					String sex = rs.getString("sex");
					Date birth_date = rs.getDate("date_birth");
					String location = rs.getString("location");
					String actual_state = rs.getString("actual_state");				
					Patient p= new Patient ( id_patient, name, surname,sex,birth_date,location,actual_state);
					patient_list.add(p);	
					}
				
				rs.close();
				stmt.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return patient_list;
		
			
		}
		
	
	public void addFamHistory(FamilyHistory famhyst) {
		try {
			String sql = "INSERT INTO family_history (type, member) VALUES( ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, famhyst.getType_cancerFam());
			prep.setString(2, famhyst.getMember());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public FamilyHistory printFamHistory(int id) {
		FamilyHistory famHist=null;
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM family_history WHERE id_patient= ? ";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_famHistory = rs.getInt("id_famHistory");
				String type = rs.getString("type");
				String member = rs.getString("member");
				famHist=new FamilyHistory(id_famHistory,type, member);	
				
			}
			rs.close();
			stmt.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return famHist;
		
	}

	
	//New method 
	public void addSymptoms(Symptoms s, int id_patient) {
		try {
			String sql;
			sql= "INSERT INTO symptoms (details) VALUES( ?)";
			sql= "INSERT INTO patient_symptoms (id_patient, id_symp) VALUES ( ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, s.getDetails());
			prep.setInt(2, id_patient);
			prep.setInt(3, s.getId_symp());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void update_patient_symptoms(int id, String type, String detail) {
		try {
			String sql = "UPDATE symptoms SET type=?, detail=? WHERE id_symp= SELECT id_symp FROM patient_symptoms WHERE id= ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, type);
			prep.setString(2, detail);
			prep.setInt(3, id);
			prep.executeUpdate();
			System.out.println("Update finished.");
			prep.close();
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public List<Symptoms> printPatientSymptoms(int id) {
			
		List <Symptoms> symptoms_list=new ArrayList<Symptoms>();
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM symptoms AS s JOIN patient_symptoms AS ps ON ps.id_symp=s.id_symp WHERE ps.id= ?";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_symp = rs.getInt("id_symp");
				String detail = rs.getString("detail");
				Symptoms s= new Symptoms ( id_symp, detail);
				symptoms_list.add(s);				
			}
			rs.close();
			stmt.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return symptoms_list;
		}
	
	//New method 
	public void addMedExam(MedicalExamination m) {
		try {
			String sql="INSERT INTO medical_examination (medExam_type, dateMedExam ) VALUES( ?, ?)";
		    PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, m.getMedExam_type());
			prep.setDate(2, (Date) m.getDateMedExam());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

	@Override
	public MedicalExamination printMedExamination(int id) {//ver
		MedicalExamination m= null;
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM medical_examination AS m JOIN symptoms AS s ON m.id_medExam=s.id_symp JOIN patient AS p ON p.id_patient=s.id_symp WHERE p.id_patient= ?";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_medExam = rs.getInt("id_medExam");
				String medExam_type = rs.getString("medExam_type");
				Date dateMedExam = rs.getDate("dateMedExam");
			    m=new MedicalExamination(id_medExam,medExam_type,dateMedExam);	
				
			}
			rs.close();
			stmt.close();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
			
	}
	
	//New method
	/*public void Diagnosis(MedicalExamination m, Cancer can) {
		try {
			if(m.getDiagnosis().equals("Cancer")) {
				String sql="INSERT INTO cancer (type, id_medExam) VALUES(?,?)";
			    PreparedStatement prep = c.prepareStatement(sql);
				prep.setString(1, can.getCancer_type());
				prep.setInt(2, m.getId_medExam());
				//Habr�a que asign�rselo tambi�n al paciente 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/



	@Override
	public boolean diagnosis(Patient p, MedicalExamination m) {
		// TODO Auto-generated method stub
		
		return false;
	}
	@Override
	public void addCancer(Cancer cancer, Patient p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Treatment assesTreatment(Cancer cancer) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean treatment_worked(Patient p) {
		// TODO Auto-generated method stub
		return false;
	}

	

	



	

}
