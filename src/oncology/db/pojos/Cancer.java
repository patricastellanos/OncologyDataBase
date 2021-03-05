package oncology.db.pojos;

import java.io.Serializable;

public class Cancer implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id_cancer;
	private String cancer_type;
	
	//constructor
	
	public Cancer(Integer id_cancer, String cancer_type) {
		super();
		this.id_cancer = id_cancer;
		this.cancer_type = cancer_type;
	}
	
	//getters and setters
	public Integer getId_cancer() {
		return id_cancer;
	}
	public String getCancer_type() {
		return cancer_type;
	}

	public void setCancer_type(String cancer_type) {
		this.cancer_type = cancer_type;
	}
	
	//tostring
	
	@Override
	public String toString() {
		return "Cancer [id_cancer=" + id_cancer + ", cancer_type=" + cancer_type + "]";
	}
	
	//hashcode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancer_type == null) ? 0 : cancer_type.hashCode());
		result = prime * result + ((id_cancer == null) ? 0 : id_cancer.hashCode());
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
		Cancer other = (Cancer) obj;
		if (cancer_type == null) {
			if (other.cancer_type != null)
				return false;
		} else if (!cancer_type.equals(other.cancer_type))
			return false;
		if (id_cancer == null) {
			if (other.id_cancer != null)
				return false;
		} else if (!id_cancer.equals(other.id_cancer))
			return false;
		return true;
	}
	
}
