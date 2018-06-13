package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.User;

public interface UserService {
	
	// Authentication related methods
	User authenticate(String uname, String pwd);
	User findUserByUserName(String username);
	User findUserByEmail(String email);
	
	User createUser(User user);
	
	ArrayList<User> findAllUsers(); 
}
