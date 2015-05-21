package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.User;

public interface CaughtBookService {

	boolean newCaughtBook(User user, Date date, String title, String comment,
			String apiID, int rating);

}
