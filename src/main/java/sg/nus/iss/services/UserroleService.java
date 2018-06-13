package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Userrole;

public interface UserroleService {

	Userrole createUser(Userrole user);
	
	ArrayList<Userrole> findAllRoles(); 
	
	Userrole findUserRole(int  userroleid);
	
	Userrole updateUserRole(Userrole user);
	
	void removeUserRole(Userrole user);
	
}
