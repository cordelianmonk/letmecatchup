package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.User;

public interface CatchBookDAO {

	public boolean catchBookExists(String title, User user);

	public void addCatchBook(CatchBook catchBook);

	public CatchBook searchCatchBookByID(int bid);

	public void updateCatchBook(CatchBook catchBook);

	public void deleteCatchBook(int bid);
}
