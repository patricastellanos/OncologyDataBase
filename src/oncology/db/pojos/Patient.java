package oncology.db.pojos;

import java.io.Serializable;

import java.sql.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import oncology.xml.utils.SQLDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name= "Patient")
@XmlType(propOrder= {"name", "surname","sex","birth_date","location","actual_state","famHistory_list","treatment_list"})

public class Patient implements Serializable {

private static final long serialVersionUID = 1L;
@XmlTransient
 private Integer id;
@XmlTransient
private String IDNumber;
@XmlElement
 private String name;
@XmlElement
 private String surname;
@XmlElement
 private String sex;
@XmlElement(name = "dob")
@XmlJavaTypeAdapter(SQLDateAdapter.class)

 private Date birth_date; 
@XmlElement
 private String location;
@XmlElement
 private String actual_state;

@XmlElement(name= "FamilyHistory")
@XmlElementWrapper(name= "FamilyHistorials")
 private List<FamilyHistory> famHistory_list;

@XmlElement(name= "Treatment")
@XmlElementWrapper(name= "Treatments")
 private List<Treatment> treatment_list;

 @XmlTransient
 private List<Symptoms> symptoms_list;
 @XmlTransient
 private List<MedicalExamination> medExamList;
 
 
 
public Patient() {
	super();
}

public Patient (String IDNumber) {
	super();
	this.IDNumber = IDNumber;
}

public Patient(String IDNumber, String name, String surname, String sex, Date birth_date,String location, String actual_state) {
	super();
	this.IDNumber = IDNumber;
	this.name = name;
	this.surname = surname;
	this.sex=sex;
	this.birth_date=birth_date;
	this.location=location;
	this.actual_state=actual_state;
	
}

public Patient(int id, String IDNumber, String name, String surname, String sex, Date birth_date,String location, String actual_state) {
	super();
	this.id = id;
	this.IDNumber = IDNumber;
	this.name = name;
	this.surname = surname;
	this.sex=sex;
	this.birth_date=birth_date;
	this.location=location;
	this.actual_state=actual_state;
	
}


public String getIDNumber() {
	return IDNumber;
}

public void setIDNumber(String iDNumber) {
	IDNumber = iDNumber;
}

	//Constructor for the method searchPatientByName
	public Patient(Integer id, String name,String surname) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
}
	
	
	

//Constructor for addPatient (name, surname,sex,Date.valueOf(date_birth),actual_state,location)
	public Patient(Integer id,String name, String surname, String sex, Date birth_date,String location, String actual_state) {
		super();
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.sex=sex;
		this.birth_date=birth_date;
		this.location=location;
		this.actual_state=actual_state;
		
	}
	public Patient(String name, String surname, String sex, Date birth_date,String location, String actual_state) {
		super();
		this.id=id;
		this.name = name;
		this.surname = surname;
		this.sex=sex;
		this.birth_date=birth_date;
		this.location=location;
		this.actual_state=actual_state;
		
	}

public Patient(Integer id, String name, String surname, String sex, Date birth_date, String location,
		String actual_state, List<Treatment> treatment_list, List<Symptoms> symptoms_list) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
	this.sex = sex;
	this.birth_date = birth_date;
	this.location = location;
	this.actual_state = actual_state;
	this.treatment_list = treatment_list;
	this.symptoms_list = symptoms_list;
}


//getters and setters
public Integer getId_patient() {
	return id;
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


@Override
public String toString() {
	return "Patient"+", "+ "[id_patient=" + id + ", " +"name=" + name +", " +"surname=" + surname 
			+ ", "+"sex=" + sex+", "+ "birth_date=" + birth_date +", "+"location=" 
			+ location +", "+"actual_state=" + actual_state + "]";
}

//hashcode just id
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
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
