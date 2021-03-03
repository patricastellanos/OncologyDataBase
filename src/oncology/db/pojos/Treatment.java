package oncology.db.pojos;

import java.io.Serializable;
import java.util.Date;

public class Treatment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id_treat;
	private String treat_type;
	private Date start_date;
	private Date end_date;
	
	//Constructor
	public Treatment(Integer id_treat, String treat_type, Date start_date, Date end_date) {
		super();
		this.id_treat = id_treat;
		this.treat_type = treat_type;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	//Gets and sets
	public Integer getId_treat() {
		return id_treat;
	}
	public String getTreat_type() {
		return treat_type;
	}
	public void setTreat_type(String treat_type) {
		this.treat_type = treat_type;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	//toString
	@Override
	public String toString() {
		return "Treatment [id_treat=" + id_treat + ", treat_type=" + treat_type + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}
	//hasCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end_date == null) ? 0 : end_date.hashCode());
		result = prime * result + ((id_treat == null) ? 0 : id_treat.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
		result = prime * result + ((treat_type == null) ? 0 : treat_type.hashCode());
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
		Treatment other = (Treatment) obj;
		if (end_date == null) {
			if (other.end_date != null)
				return false;
		} else if (!end_date.equals(other.end_date))
			return false;
		if (id_treat == null) {
			if (other.id_treat != null)
				return false;
		} else if (!id_treat.equals(other.id_treat))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		if (treat_type == null) {
			if (other.treat_type != null)
				return false;
		} else if (!treat_type.equals(other.treat_type))
			return false;
		return true;
	}
	
	
	
	
	
}
