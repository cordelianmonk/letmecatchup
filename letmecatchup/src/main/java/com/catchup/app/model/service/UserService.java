package com.catchup.app.model.service;

import com.catchup.app.model.user.User;

public interface UserService {
	public User validateUser(String email, String password);
	public boolean newUser(String firstName, String lastName, String email, String password);
	public User getUserById(int uid);
}
