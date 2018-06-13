package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.repo.UserRepository;

import sg.nus.iss.model.User;



@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository repos;
	
	@Override
	@Transactional
	public User authenticate(String uname, String pwd) {
		User u = repos.findUserByNamePwd(uname, pwd);
		return u;
	}
	
	@Override
	@Transactional
	public ArrayList<User> findAllUsers() {
		ArrayList<User> ul = (ArrayList<User>) repos.findAll();
		return ul;
	}

	@Override
	@Transactional
	public User createUser(User user) {
		return repos.saveAndFlush(user);
	}

	@Override
	public User findUserByUserName(String username) {
		return repos.findUserByUsername(username);
	}

	@Override
	public User findUserByEmail(String email) {
		return repos.findUserByEmail(email);
	}

}
