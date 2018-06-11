package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Userrole;

public interface UserroleService {

	Userrole createUser(Userrole user);
	
	ArrayList<Userrole> findAllRoles(); 
	
}
