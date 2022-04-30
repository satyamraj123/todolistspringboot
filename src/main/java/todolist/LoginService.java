package todolist;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean isValidUser(String name) {
		if(name.compareTo("Satyam Raj")==0) {
			return true;
		}else {
			return false;
		}
	}
}
