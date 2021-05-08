package actions;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import oncology.db.interfaces.DBMaster;
import oncology.db.pojos.Cancer;
import oncology.db.pojos.FamilyHistory;
import oncology.db.pojos.MedicalExamination;
import oncology.db.pojos.Patient;
import oncology.db.pojos.Symptoms;
import oncology.db.pojos.Treatment;
import userInteraction.UserInteraction;

public class SQLMaster implements DBMaster {

	private Connection c;

	
	public SQLMaster() {
		super();
		this.connect();
	}

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
			String sql1 = "CREATE TABLE family_history " + "(id_famHistory INTEGER PRIMARY KEY AUTOINCREMENT, "
								+ "  type TEXT, " + "  member TEXT , " + " patient_id REFERENCES patient (id) ON DELETE SET NULL)";
			stmt1.executeUpdate(sql1);
						
			// Create table patient
			 sql1 = "CREATE TABLE patient " + "( id INTEGER  PRIMARY KEY AUTOINCREMENT, "
					+ " name TEXT NOT NULL, " + " surname TEXT NOT NULL, " + " sex TEXT NOT NULL, "
					+ " date_birth DATE NOT NULL, " + " location TEXT NOT NULL, " + " actual_state TEXT NOT NULL)";					
			stmt1.executeUpdate(sql1);
			
			//Create the table medical examination
			sql1= "CREATE TABLE medical_examination " + "(id_medExam INTEGER PRIMARY KEY AUTOINCREMENT, "
			      + " medExam_type TEXT NOT NULL, " + " dateMedExam DATE NOT NULL, " + " diagnosis TEXT NOT NULL, " + " patient_id INTEGER REFERENCES patient (id) ON DELETE SET NULL)";
			stmt1.executeUpdate(sql1);

			
			// Create table cancer
			sql1 = "CREATE TABLE cancer " + "(id_cancer INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ " id_medExam REFERENCES medical_examination (id_medExam) ON DELETE SET NULL, "
					+ " type TEXT NOT NULL)";
			// sql = "INSERT INTO cancer (type) "
			// + "VALUES ('Liver');";
			stmt1.executeUpdate(sql1);
			
			// Create table treatment
			sql1 = "CREATE TABLE treatment " + "(id_treat   INTEGER  PRIMARY KEY AUTOINCREMENT, "
				    + " type    TEXT  NOT NULL, " + " startdate DATE NOT NULL, " + " duration INTEGER, " + " patient_id INTEGER REFERENCES patient(id) ON DELETE SET NULL)";
			stmt1.executeUpdate(sql1);
			
			// Create table symptoms
			sql1 = "CREATE TABLE symptoms " + "( id_symp  INTEGER  PRIMARY KEY AUTOINCREMENT,"
				   + " detail TEXT NOT NULL)";
			stmt1.executeUpdate(sql1);

			// Create table cancer_treatment
			sql1 = "CREATE TABLE cancer_treatment " + "(id_cancer INTEGER REFERENCES cancer (id_cancer), "
					+ " id_treat INTEGER REFERENCES treatment (id_treat), "
					+ " PRIMARY KEY (id_cancer, id_treat))";
			stmt1.executeUpdate(sql1);

			// Create table patient_symptoms
			sql1 = "CREATE TABLE patient_symptoms"
					+ "(id INTEGER REFERENCES patient(id) ON DELETE SET NULL, "
					+ " id_symp INTEGER REFERENCES symptoms(id_symp) ON DELETE SET NULL, "
					+ " PRIMARY KEY (id, id_symp))";

			stmt1.executeUpdate(sql1);

			// Create table cancer_patient
			sql1 = "CREATE TABLE cancer_patient " + "(id_cancer INTEGER REFERENCES cancer (id_cancer), "
					+ " id INTEGER REFERENCES patient (id), "
					+ " PRIMARY KEY (id_cancer, id))";

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
		
		
	public String printActualState(int id_patient) {
		
		String actual_state=null;
		try {
		String sql= "SELECT * FROM patient WHERE id="+id_patient;
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			actual_state=rs.getString("actual_state");
					
		}
		stmt.close();
		rs.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
		return actual_state;
	}
	
	public void addFamHistory(int id, FamilyHistory famhist) {
		try {
			String sql = "INSERT INTO family_history (type, member, patient_id) VALUES(?, ?, ?)";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, famhist.getType_cancerFam());
			prep.setString(2, famhist.getMember());
			prep.setInt(3, id);
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
			String sql = "SELECT * FROM family_history WHERE patient_id= ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				Integer id_famHistory = rs.getInt("id_famHistory");
				String type = rs.getString("type");
				String member = rs.getString("member");
				
				famHist=new FamilyHistory(id_famHistory,type, member);	
				
			}
			rs.close();
			stmt.close();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return famHist;
		
	}
	
	public void familyHistoryToXml(int patient_id) {
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM family_history WHERE patient_id = " + patient_id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String type = rs.getString("type");
				String member = rs.getString("member");
				FamilyHistory fh= new FamilyHistory (type, member);
			
				JAXBContext jaxbContext = JAXBContext.newInstance(FamilyHistory.class);
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
				File file = new File("./xmls/FamilyHistory.xml");
				marshaller.marshal(fh, file);
				marshaller.marshal(fh, System.out);
			}
			rs.close();
			stmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}catch(JAXBException j) {
				j.printStackTrace();
			}
	}

	

	public void addSymptoms(Symptoms s, int id_patient) {
		try {
			String sql1;
			sql1= "INSERT INTO symptoms (detail) VALUES( ?)";
			PreparedStatement prep1 = c.prepareStatement(sql1);
			prep1.setString(1, s.getDetails());
			prep1.executeUpdate();
			prep1.close();

			String query = "SELECT last_insert_rowid() AS lastId";
			PreparedStatement p = c.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			Integer lastId = rs.getInt("lastId");
			p.close();
			rs.close();
			
			String sql2;
			sql2= "INSERT INTO patient_symptoms (id, id_symp) VALUES (?, ?)";
			PreparedStatement prep2 = c.prepareStatement(sql2);
			prep2.setInt(1, id_patient);
			prep2.setInt(2, lastId);
		
			prep2.executeUpdate();
			prep2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void removeSymptoms(int id_patient) {
		try {
				String sql = "DELETE FROM patient_symptoms WHERE id= ?";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setInt(1, id_patient);
				prep.executeUpdate();
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
			String sql = "SELECT * FROM symptoms AS s JOIN patient_symptoms AS ps ON ps.id_symp=s.id_symp WHERE ps.id= " +id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_symp = rs.getInt(1);
				String detail = rs.getString("detail");
				Symptoms s= new Symptoms ( id_symp, detail);
				//System.out.println(s);
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
	public void addMedExam(MedicalExamination m, int id) {//le deberķamos pasar el id del paciente tmb 
		try {
			String sql="INSERT INTO medical_examination (medExam_type, dateMedExam, diagnosis, patient_id) VALUES( ?, ?, ?, ?)";
		    PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, m.getMedExam_type());
			prep.setDate(2, (Date) m.getDateMedExam());
			prep.setString(3, m.getDiagnosis());
			prep.setInt(id, id);
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
			String sql = "SELECT * FROM medical_examination WHERE patient_id = "+ id;
			
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_medExam = rs.getInt("id_medExam");
				String medExam_type = rs.getString("medExam_type");
				Date dateMedExam = rs.getDate("dateMedExam");
				String diagnosis = rs.getString("diagnosis");
			    m=new MedicalExamination(id_medExam,medExam_type,dateMedExam,diagnosis);	
				
			}
			rs.close();
			stmt.close();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
			
	}
	
	
	@Override
	public void addCancer(Cancer cancer, int id_patient) {
		try {
		String sql1 = "INSERT INTO cancer (type) VALUES ( ?)";
		PreparedStatement prep1 = c.prepareStatement(sql1);
		prep1.setString(1, cancer.getCancer_type());
		prep1.executeUpdate();
		prep1.close();
		//System.out.println(cancer.getCancer_type());
		//System.out.println(cancer.getId_cancer());
		
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p = c.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		Integer lastId = rs.getInt("lastId");
		p.close();
		rs.close();
		
		String sql2 = "INSERT INTO cancer_patient (id_cancer, id) VALUES ( ?,?)";
		PreparedStatement prep2 = c.prepareStatement(sql2);
		prep2.setInt(1, lastId);
		prep2.setInt(2, id_patient);
		prep2.executeUpdate();
		prep2.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Cancer printCancer(int id_patient) {
		
		Cancer cancer= null;
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM cancer AS c JOIN cancer_patient AS cp ON cp.id_cancer=c.id_cancer WHERE cp.id= " +id_patient;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_cancer = rs.getInt(1);
				String type = rs.getString("type");
				cancer= new Cancer ( id_cancer, type);
				
			}
			rs.close();
			stmt.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return cancer;
	}
	
	public void cancerToXml(int id) {
		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT * FROM cancer WHERE id_cancer = " + id;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Integer id_cancer = rs.getInt(1);
				String type = rs.getString("type");
				Cancer can= new Cancer ( id_cancer, type);
			
				JAXBContext jaxbContext = JAXBContext.newInstance(Cancer.class);
				Marshaller marshaller = jaxbContext.createMarshaller();
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
				File file = new File("./xmls/Cancer.xml");
				marshaller.marshal(can, file);
				marshaller.marshal(can, System.out);
			}
			rs.close();
			stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
	
			
		public void addTreatment(Treatment t, int id) {
		 String sql = "INSERT INTO treatment (type, startDate, duration, patient_id) VALUES (?, ?, ?, ?)";
		 PreparedStatement prep;
		try {
			prep = c.prepareStatement(sql);
			prep.setString(1, t.getTreat_type());
			prep.setDate(2, (Date) t.getStart_date());
			prep.setInt(3, t.getDuration());
			prep.setInt(4, id);
			prep.executeUpdate();
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		 
	 }
	@Override
	public Treatment assessTreatment(int id_patient) {
		
		Treatment treatment=null;
		try {
			
			Statement stmt=c.createStatement();
			String sql= "SELECT * FROM treatment AS t JOIN cancer_treatment AS ct ON t.id_treat= ct.id_treat JOIN cancer AS c ON ct.id_cancer= c.id_cancer JOIN cancer_patient AS cp ON c.id_cancer= cp.id_cancer WHERE cp.id=  "+id_patient;
					/*"SELECT * FROM treatment AS t JOIN cancer_treatment AS ct ON t.id_treat=ct.id_treat JOIN cancer_patient AS cp "
					+ "ON ct.id_cancer=cp.id WHERE cp.id = " +id_patient;*/
					
			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id = rs.getInt("id_treat");
				String type = rs.getString("type"); 
				Date startdate = rs.getDate("startdate");
				int duration = rs.getInt("duration");		
				return treatment=new Treatment(id, type, startdate, duration);		
			}
			
			rs.close();
			stmt.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return treatment;
	}
	
	
	public boolean treatment_worked(int id_patient) {

		try {
			Statement stmt = c.createStatement();
			String sql = "SELECT actual_state FROM patient WHERE id LIKE '%" + id_patient + "%'";
			ResultSet rs = stmt.executeQuery(sql);

			String actual_state = null;

			while (rs.next()) {

				actual_state = rs.getString("actual_state");
			}

			if (!actual_state.equalsIgnoreCase("RECOVERED") && !actual_state.equalsIgnoreCase("DEATH")) {
				return false;

			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	
		
		

}
