
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
}
