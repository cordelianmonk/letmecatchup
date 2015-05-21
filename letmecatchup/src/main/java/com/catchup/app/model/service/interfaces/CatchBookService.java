package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.User;

public interface CatchBookService {

	public boolean newCatchBook(User user, Date date, String title, String comment, String apiID);

}