package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CaughtBook;

public interface CaughtBookDAO {

	public void addCaughtBook(CaughtBook caughtBook);

	public CaughtBook searchCaughtBookByID(int bid);

	public void updateCaughtBook(CaughtBook caughtBook);

	public void deleteCaughtBook(int bid);

}
