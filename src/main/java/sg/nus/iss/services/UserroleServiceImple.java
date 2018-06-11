package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.model.Userrole;
import sg.nus.iss.repo.UserroleRepository;

@Service
public class UserroleServiceImple implements UserroleService {
	
	
	@Resource
	private UserroleRepository usrrepos;

	@Override
	public Userrole createUser(Userrole user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Userrole> findAllRoles() {
		ArrayList<Userrole> ul = (ArrayList<Userrole>) usrrepos.findAll();
		return ul;
	}

}
