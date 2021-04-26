package oncology.db.pojos.users;

import java.io.Serializable;

import javax.management.relation.Role;

public class User implements Serializable{
	
	private Integer id;
	String email;
	private byte[] password;
	private Role role; //1(user) to many(role) relationship
	
	
	
	

}
