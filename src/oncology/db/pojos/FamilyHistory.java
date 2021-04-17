package oncology.db.pojos;

import java.io.Serializable;

public class FamilyHistory implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id_famHistory;
	private String type_cancerFam;
	private String member;
	private Patient p;
	
	//constructor
	public FamilyHistory(Integer id_famHistory, String type_cancerFam, String member) {
		super();
		this.id_famHistory = id_famHistory;
		this.type_cancerFam = type_cancerFam;
		this.member = member;
	}

	//getters and setter
	public Integer getId_famHistory() {
		return id_famHistory;
	}

	public String getType_cancerFam() {
		return type_cancerFam;
	}

	public void setType_cancerFam(String type_cancerFam) {
		this.type_cancerFam = type_cancerFam;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//toString

	@Override
	public String toString() {
		return "FamilyHistory [id_famHistory=" + id_famHistory + ", type_cancerFam=" + type_cancerFam + ", member="
				+ member + "]";
	}

	//hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_famHistory == null) ? 0 : id_famHistory.hashCode());
		result = prime * result + ((member == null) ? 0 : member.hashCode());
		result = prime * result + ((type_cancerFam == null) ? 0 : type_cancerFam.hashCode());
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
		FamilyHistory other = (FamilyHistory) obj;
		if (id_famHistory == null) {
			if (other.id_famHistory != null)
				return false;
		} else if (!id_famHistory.equals(other.id_famHistory))
			return false;
		if (member == null) {
			if (other.member != null)
				return false;
		} else if (!member.equals(other.member))
			return false;
		if (type_cancerFam == null) {
			if (other.type_cancerFam != null)
				return false;
		} else if (!type_cancerFam.equals(other.type_cancerFam))
			return false;
		return true;
	}
	
	
	

}
