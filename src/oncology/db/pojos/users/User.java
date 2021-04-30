package oncology.db.pojos.users;

import java.io.Serializable;
import java.util.Arrays;

import javax.management.relation.Role;
import javax.persistence.*;

@Entity
@Table(name="users")

public class User implements Serializable{
	@Id
	private Integer id;
	String email;
	@Lob
	private byte[] password;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role; //1(user) to many(role) relationship
	public Integer getId() {
		return id;
	}
	

	public User() {
		super();
	}


	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + Arrays.toString(password) + ", role=" + role
				+ "]";
	}

	
	
	

}