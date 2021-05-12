package oncology.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Treatment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id_treat;
	//Cambiar stardate y enddate por duracion
	private String treat_type;
	private Date start_date;
	private Integer duration;
	private List<Cancer> cancer_list=new ArrayList<>();//initialize
	
	
	
	public Treatment() {
		super();
	}

	//Constructor
	public Treatment(Integer id_treat, String treat_type, Date start_date, Integer duration) {
		super();
		this.id_treat = id_treat;
		this.treat_type = treat_type;
		this.start_date = start_date;
		this.duration = duration;
	}
	
	public Treatment(String treat_type, Date start_date, Integer duration) {
		super();
		this.id_treat = id_treat;
		this.treat_type = treat_type;
		this.start_date = start_date;
		this.duration = duration;
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

	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	//toString
	@Override
	public String toString() {
		return "Treatment [id_treat=" + id_treat + ", treat_type=" + treat_type + ", start_date=" + start_date
				+ ", duration=" + duration + "]";
	}
	//hasCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
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
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
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
