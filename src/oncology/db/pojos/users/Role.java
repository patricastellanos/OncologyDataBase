package oncology.db.pojos.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="roles")

public class Role implements Serializable  {
	
	@Id
	@GeneratedValue(generator = "roles")
	@TableGenerator(name = "roles", table="sqlite_sequence", pkColumnName= "name", valueColumnName="seq", pkColumnValue="roles")
	private Integer id;
	private String name;
	@OneToMany(mappedBy="role")
	private List<User> user;
	
	
	
	public Role() {
		super();
	}
	public Role(String string) {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Roles [id=" + id + ", name=" + name + "]";
	}
	

}
