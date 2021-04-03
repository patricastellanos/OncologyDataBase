package oncology.db.pojos;

import java.io.Serializable;

import java.sql.Date;
import java.util.List;

public class Patient implements Serializable {

private static final long serialVersionUID = 1L;
private Integer id_patient;
 private String name;
 private String surname;
 private String sex;
 private Date birth_date; 
 private String location;
 private String actual_state;
 private List<Cancer> cancer_list;
 private List<Symptoms> symptoms_list;
 
/*
 * actual_state { ACUTE_REHABILITATION, SLOWSTREAM_REHABILITATION, COMPLEX_CARE,
 * CONVALESCENT_CARE, PALLIATIVE_RESPITE; }
 */
 
 
//Constructor for the method searchPatientByName
	public Patient(Integer id_patient, String name,String surname) {
	super();
	this.id_patient = id_patient;
	this.name = name;
	this.surname = surname;
}
	
	
	

//Constructor for addPatient (name, surname,sex,Date.valueOf(date_birth),actual_state,location)
	public Patient(String name, String surname, String sex, Date birth_date,String location, String actual_state) {
		super();
		this.id_patient=id_patient;
		this.name = name;
		this.surname = surname;
		this.sex=sex;
		this.birth_date=birth_date;
		this.location=location;
		this.actual_state=actual_state;
		
	}
	
	
	/*public Patient(Integer id_patient, String name, String surname, String sex, Date birth_date, String location,
			String actual_state) {
		super();
		this.id_patient = id_patient;
		this.name = name;
		this.surname = surname;
		this.sex = sex;
		this.birth_date = birth_date;
		this.location = location;
		this.actual_state = actual_state;
	}*/




//getters and setters
public Integer getId_patient() {
	return id_patient;
}


public Patient(Integer id_patient, String name, String surname, String sex, Date birth_date, String location,
		String actual_state, List<Cancer> cancer_list, List<Symptoms> symptoms_list) {
	super();
	this.id_patient = id_patient;
	this.name = name;
	this.surname = surname;
	this.sex = sex;
	this.birth_date = birth_date;
	this.location = location;
	this.actual_state = actual_state;
	this.cancer_list = cancer_list;
	this.symptoms_list = symptoms_list;
}




public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}


public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public Date getDate_birth() {
	return birth_date;
}
public void setDate_birth(Date date_birth) {
	this.birth_date = date_birth;
}
public String getActual_state() {
	return actual_state;
}
public void setActual_state(String actual_state) {
	this.actual_state = actual_state;
}
//toString
@Override
public String toString() {
	return "Patient [id_patient=" + id_patient + ", name=" + name + ", surname=" + surname + ", sex=" + sex
			+  ", location=" + location + "]";
}
//hashcode
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id_patient == null) ? 0 : id_patient.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((sex == null) ? 0 : sex.hashCode());
	result = prime * result + ((surname == null) ? 0 : surname.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Patient other = (Patient) obj;
	if (id_patient == null) {
		if (other.id_patient != null)
			return false;
	} else if (!id_patient.equals(other.id_patient))
		return false;
	if (location == null) {
		if (other.location != null)
			return false;
	} else if (!location.equals(other.location))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (sex == null) {
		if (other.sex != null)
			return false;
	} else if (!sex.equals(other.sex))
		return false;
	if (surname == null) {
		if (other.surname != null)
			return false;
	} else if (!surname.equals(other.surname))
		return false;
	return true;
}

 

 
}
