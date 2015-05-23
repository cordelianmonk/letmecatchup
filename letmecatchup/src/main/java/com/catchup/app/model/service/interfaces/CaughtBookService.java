package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.CaughtBook;
import com.catchup.app.model.items.User;

public interface CaughtBookService {

	boolean newCaughtBook(User user, Date date, String title, String comment,
			String apiID, int rating);

	public CaughtBook searchCaughtBookByID(int bid);

	public void updateCaughtBook(CaughtBook caughtBook);

	public void deleteCaughtBook(int bid);
	

}
