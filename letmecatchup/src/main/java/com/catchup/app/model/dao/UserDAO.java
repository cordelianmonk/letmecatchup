package com.catchup.app.model.dao;

import com.catchup.app.model.user.User;

public interface UserDAO {
	public User validateUser(String email, String password);
}
