package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CaughtBook;
import com.catchup.app.model.items.User;

public interface CaughtBookDAO {

	public void addCaughtBook(CaughtBook caughtBook);

	public CaughtBook searchCaughtBookByID(int bid);

	public void updateCaughtBook(CaughtBook caughtBook);

	public void deleteCaughtBook(int bid);

	public boolean caughtBookExists(String title, String apiID, User user);

}
