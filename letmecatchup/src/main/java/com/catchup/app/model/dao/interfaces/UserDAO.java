package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.User;

public interface UserDAO {
	public User validateUser(String email, String password);

	public boolean userExists(String email);

	public void addUser(User user);

	public User getUserById(int uid);

	public void updateUser(User user);
	
}
