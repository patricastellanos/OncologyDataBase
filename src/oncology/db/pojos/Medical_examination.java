package oncology.db.pojos;

import java.io.Serializable;
import java.util.Date;

public class Medical_examination implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id_medExam;
	private String medExam_type;
	private Date dateMedExam;
	private String diagnosis;
	
	//constructor
	public Medical_examination(Integer id_medExam, String medExam_type, Date dateMedExam, String diagnosis) {
		super();
		this.id_medExam = id_medExam;
		this.medExam_type = medExam_type;
		this.dateMedExam = dateMedExam;
		this.diagnosis = diagnosis;
	}
	
	//getters and setters
	
	public Integer getId_medExam() {
		return id_medExam;
	}
	public String getMedExam_type() {
		return medExam_type;
	}
	public void setMedExam_type(String medExam_type) {
		this.medExam_type = medExam_type;
	}
	public Date getDateMedExam() {
		return dateMedExam;
	}
	public void setDateMedExam(Date dateMedExam) {
		this.dateMedExam = dateMedExam;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	//to String
	@Override
	public String toString() {
		return "Medical_examination [id_medExam=" + id_medExam + ", medExam_type=" + medExam_type + ", dateMedExam="
				+ dateMedExam + ", diagnosis=" + diagnosis + "]";
	}
	//hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateMedExam == null) ? 0 : dateMedExam.hashCode());
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((id_medExam == null) ? 0 : id_medExam.hashCode());
		result = prime * result + ((medExam_type == null) ? 0 : medExam_type.hashCode());
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
		Medical_examination other = (Medical_examination) obj;
		if (dateMedExam == null) {
			if (other.dateMedExam != null)
				return false;
		} else if (!dateMedExam.equals(other.dateMedExam))
			return false;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (id_medExam == null) {
			if (other.id_medExam != null)
				return false;
		} else if (!id_medExam.equals(other.id_medExam))
			return false;
		if (medExam_type == null) {
			if (other.medExam_type != null)
				return false;
		} else if (!medExam_type.equals(other.medExam_type))
			return false;
		return true;
	}
	
}
