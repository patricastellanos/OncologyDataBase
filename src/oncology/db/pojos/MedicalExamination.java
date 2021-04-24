package oncology.db.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MedicalExamination implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id_medExam;
	private String medExam_type;
	private Date dateMedExam;
	private String diagnosis; 
	private List<Cancer> cancer_list;
	private List<Symptoms> symptoms_list;
	
	//constructor
	public MedicalExamination(Integer id_medExam, String medExam_type, Date dateMedExam, String diagnosis) {
		super();
		this.id_medExam = id_medExam;
		this.medExam_type = medExam_type;
		this.dateMedExam = dateMedExam;
		this.diagnosis= diagnosis;
	}
	
	public MedicalExamination(String medExam_type, Date dateMedExam, String diagnosis) {
		super();
		this.medExam_type = medExam_type;
		this.dateMedExam = dateMedExam;
		this.diagnosis= diagnosis;
	}
	//getters and setters
	
	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

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
	
	@Override
	public String toString() {
		return "MedicalExamination [id_medExam=" + id_medExam + ", medExam_type=" + medExam_type + ", dateMedExam="
				+ dateMedExam + ", diagnosis=" + diagnosis + ", cancer_list=" + cancer_list + ", symptoms_list="
				+ symptoms_list + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancer_list == null) ? 0 : cancer_list.hashCode());
		result = prime * result + ((dateMedExam == null) ? 0 : dateMedExam.hashCode());
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((id_medExam == null) ? 0 : id_medExam.hashCode());
		result = prime * result + ((medExam_type == null) ? 0 : medExam_type.hashCode());
		result = prime * result + ((symptoms_list == null) ? 0 : symptoms_list.hashCode());
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
		MedicalExamination other = (MedicalExamination) obj;
		if (cancer_list == null) {
			if (other.cancer_list != null)
				return false;
		} else if (!cancer_list.equals(other.cancer_list))
			return false;
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
		if (symptoms_list == null) {
			if (other.symptoms_list != null)
				return false;
		} else if (!symptoms_list.equals(other.symptoms_list))
			return false;
		return true;
	}
	
}
