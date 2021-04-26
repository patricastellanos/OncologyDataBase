package oncology.db.pojos.users;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="roles")

public class Roles implements Serializable  {
	
	private Integer id;
	private String name;
	private List<User> user;
	

}
