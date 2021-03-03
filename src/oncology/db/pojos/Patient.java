package oncology.db.pojos;

public class Patient {
 private Integer id_patient;
 private String name;
 private String surname;
 private String sex;
 private String med_condition;
 private String location;
 
 //Constructor
public Patient(Integer id_patient, String name, String surname, String sex, String med_condition, String location) {
	super();
	this.id_patient = id_patient;
	this.name = name;
	this.surname = surname;
	this.sex = sex;
	this.med_condition = med_condition;
	this.location = location;
	
	
}
	//getters and setters
public Integer getId_patient() {
	return id_patient;
}

public void setId_patient(Integer id_patient) {
	this.id_patient = id_patient;
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

public String getMed_condition() {
	return med_condition;
}

public void setMed_condition(String med_condition) {
	this.med_condition = med_condition;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

//toString
@Override
public String toString() {
	return "Patient [id_patient=" + id_patient + ", name=" + name + ", surname=" + surname + ", sex=" + sex
			+ ", med_condition=" + med_condition + ", location=" + location + "]";
}
//hashcode
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id_patient == null) ? 0 : id_patient.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((med_condition == null) ? 0 : med_condition.hashCode());
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
	if (med_condition == null) {
		if (other.med_condition != null)
			return false;
	} else if (!med_condition.equals(other.med_condition))
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
