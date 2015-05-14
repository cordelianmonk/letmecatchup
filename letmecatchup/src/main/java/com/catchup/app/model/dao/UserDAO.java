package com.catchup.app.model.dao;

import com.catchup.app.model.user.User;

public interface UserDAO {
	public User validateUser(String email, String password);

	public boolean userExists(String email);

	public void addUser(User user);
	
}
