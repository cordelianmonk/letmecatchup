package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CatchBook;
public interface CatchBookDAO {

	public boolean bookExists(String title);

	public void addCatchBook(CatchBook catchBook);
}
