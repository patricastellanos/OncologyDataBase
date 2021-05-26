
package oncology.db.jpa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.*;

import oncology.db.interfaces.UserMaster;
import oncology.db.pojos.users.*;

public class JPAUserMaster implements UserMaster {

	private EntityManager em;

	public JPAUserMaster() {
		super();
		this.connect();
	}
	@Override
	public void connect() {
		em = Persistence.createEntityManagerFactory("user-provider").createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
		List<Role> existingRoles = this.getRolesList();
	
		if (existingRoles.size()<3) {
			this.newRole(new Role("patient"));
			this.newRole(new Role("doctor"));
			this.newRole(new Role("nurse"));
		}
	}

	@Override
	public void disconnect() {
		em.close();
	}

	@Override
	public void newUser(User u) {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
	}

	@Override
	public void newRole(Role r) {
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}

	@Override
	public Role getRole(int id) {
		Query q = em.createNativeQuery("SELECT * FROM roles WHERE id = ?", Role.class);
		q.setParameter(1, id);
		return (Role) q.getSingleResult();

	}
	
	public User getUser(String email) {
		Query q = em.createNativeQuery("SELECT * FROM users WHERE email = ?", User.class);
		q.setParameter(1, email);
		return (User) q.getSingleResult();

	}
	
	@Override
	public boolean userNameTaken(String username) {
		Query q = em.createNativeQuery("SELECT * FROM users WHERE email = ?", User.class);
		q.setParameter(1, username);
		List<User> userList= (List) q.getResultList();
		if(userList.isEmpty()) {
			return false;
		}
		else {
			return true;
		}
		
	}

	@Override
	public List<Role> getRolesList() {
		Query q = em.createNativeQuery("SELECT * FROM roles", Role.class);
		return (List<Role>) q.getResultList();
	}

	@Override
	public User checkPassword(String email, String password) {
		
		Query q=null;
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] hash = md.digest();
			 q = em.createNativeQuery("SELECT * FROM users WHERE email = ? AND password = ?", User.class);
			q.setParameter(1, email);
			q.setParameter(2, hash);
			
			return (User) q.getSingleResult();
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoResultException nre) {
			return null;
		}
		
		return (User) q.getSingleResult();
	}
	
	
	
	@Transient
	public void changePassword(String email, String newPass) {
		
	try {
		em.getTransaction().begin();
		User u=getUser(email);
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(newPass.getBytes());
		byte[] hash = md.digest();
		
		u.setPassword(hash);
		em.persist(u);
		em.getTransaction().commit();
		
	}catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
	}
	}
	
	
	public void removeUser(String email, String password) {
		
		em.getTransaction().begin();
		User u=this.checkPassword(email, password);
		em.remove(u);
		em.getTransaction().commit();

	}
	


}
