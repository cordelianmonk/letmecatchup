package com.catchup.app.model.service;

import java.sql.Date;

import com.catchup.app.model.user.User;

public interface CatchBookService {

	public boolean newCatchBook(User user, Date date, String title, String comment, String apiID);

}