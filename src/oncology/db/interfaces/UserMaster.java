package oncology.db.interfaces;

import java.util.List;

import oncology.db.pojos.users.*;

public interface UserMaster {
	public void connect();
	public void disconnect();
	public void newUser(User u);
	public void newRole(Role r);
	public Role getRole(int id);
	public boolean userNameTaken(String userName);
	public List<Role> getRolesList();
	public User checkPassword(String email, String password);
}
