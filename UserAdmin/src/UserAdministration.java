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
			if(u.getName().equals(user.getName())) {
				System.out.println("User with name "+user.getName()+" already exists");
				return false;
			}
		}
		this.userList.add(user);
		System.out.println("User "+user.getName()+" successfully added");
		return true;
	}
	
	public boolean updateUser(User user) {
		if(containsUser(user)) {
			//User userToChange= userList.get(userList.indexOf(user));
		}
		return false;
	}
	
	
	
	private boolean containsUser(User user) {
		return userList.contains(user);
	}
}
