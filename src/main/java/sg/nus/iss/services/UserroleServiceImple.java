package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.model.Userrole;
import sg.nus.iss.repo.UserroleRepository;

@Service
public class UserroleServiceImple implements UserroleService {
	

	@Resource
	private UserroleRepository usrrepos;

	@Override
	@Transactional
	public Userrole createUser(Userrole user) {
		return usrrepos.saveAndFlush(user);
	}

	@Override
	@Transactional
	public ArrayList<Userrole> findAllRoles() {
		ArrayList<Userrole> ul = (ArrayList<Userrole>) usrrepos.findAll();
		return ul;
	}

	@Override
	@Transactional
	public Userrole findUserRole(int userroleid) {
		
		Userrole u = usrrepos.findOne(userroleid);
		
		return u;
	}

	@Override
	@Transactional
	public Userrole updateUserRole(Userrole userrole) {

	
		return usrrepos.saveAndFlush(userrole);
	}

	@Override
	@Transactional
	public void removeUserRole(Userrole user) {

			usrrepos.delete(user);
	}

}
