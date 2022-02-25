package admin;
import domain.User;
import java.util.List;

public class UserAdministration {
	private List<User> userList;
	
	public UserAdministration() {
		super();
	}
	
	public UserAdministration(List<User> userList) {
		this.userList= userList;
	}
	
	public List<User> getAllUsers(){
		return this.userList;
	}
	
	public boolean addUser(User user) {
		for(User u: userList) {
			if(u.getIme().equals(user.getIme())) {
				System.out.println("User with name "+user.getIme()+" already exists");
				return false;
			}
		}
		this.userList.add(user);
		System.out.println("User "+user.getIme()+" successfully added");
		return true;
	}
	
	
	public boolean updateUser(User user, User userForUpdate) {
		if(containsUser(user)) {
			int index= userList.indexOf(user);
			userList.set(index, userForUpdate);
			return true;
		}
		return false;
	}
	
	public boolean removeUser(User user) {
		if(containsUser(user)) {
			userList.remove(user);
			return true;
		}
		return false;
	}
	
	public User getUser(String username) {
		for(User u: userList) {
			if(u.getUsername().equals(name)) {
				return u;
			}
		}
		return null;
	}
	
	
	
	private boolean containsUser(User user) {
		return userList.contains(user);
	}
}
