package sg.nus.iss.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.repo.UserroleRepository;

@Service
public class UserroleServiceImple implements UserroleService {
	
	
	@Resource
	private UserroleRepository usrrepos;

}
