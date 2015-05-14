package com.catchup.app.model.service;

import com.catchup.app.model.user.User;

public interface UserService {
	public User validateUser(String email, String password);
}
