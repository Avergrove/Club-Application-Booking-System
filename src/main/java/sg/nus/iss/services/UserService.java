package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.User;

public interface UserService {
	
	User authenticate(String uname, String pwd);
	
	User createUser(User user);
	
	ArrayList<User> findAllUsers(); 
}
