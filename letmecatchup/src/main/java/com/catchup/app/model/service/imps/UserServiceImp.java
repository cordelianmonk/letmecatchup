package com.catchup.app.model.service.imps;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.UserDAO;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.UserService;
import com.catchup.app.util.HashGeneratorUtils;

@Service
public class UserServiceImp implements UserService {
	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public User validateUser(String email, String password) {
		User user = this.userDAO.validateUser(email, password);
		return user;
	}

	@Override
	@Transactional
	public boolean newUser(String firstName, String lastName, String email,
			String password) {
		
		if( this.userDAO.userExists(email) ){
			return false;
		}
		password=HashGeneratorUtils.generateSHA256(password);
		User user = new User (firstName, lastName, email, password);
		this.userDAO.addUser(user);
		return true;
	}

	@Override
	@Transactional
	public User getUserById(int uid) {
		return this.userDAO.getUserById(uid);
	}

}
