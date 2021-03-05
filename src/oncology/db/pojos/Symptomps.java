package oncology.db.pojos;

import java.io.Serializable;
import java.util.List;

public class Symptomps implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id_symp;
	private String intensity; //fixed values for future
	private String details;
	private List<Patient> patient_list;
	private MedicalExamination m;
	
	//constructor
	
	public Symptomps(Integer id_symp, String intensity, String details) {
		super();
		this.id_symp = id_symp;
		this.intensity = intensity;
		this.details = details;
		
			
	}
	//getters and setters
	public Integer getId_symp() {
		return id_symp;
	}

	public String getIntensity() {
		return intensity;
	}

	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	//toString 
	
	@Override
	public String toString() {
		return "Symptomps [id_symp=" + id_symp + ", intensity=" + intensity + ", details=" + details + "]";
	}

	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id_symp == null) ? 0 : id_symp.hashCode());
		result = prime * result + ((intensity == null) ? 0 : intensity.hashCode());
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
		Symptomps other = (Symptomps) obj;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id_symp == null) {
			if (other.id_symp != null)
				return false;
		} else if (!id_symp.equals(other.id_symp))
			return false;
		if (intensity == null) {
			if (other.intensity != null)
				return false;
		} else if (!intensity.equals(other.intensity))
			return false;
		return true;
	}
	
	
	
}
