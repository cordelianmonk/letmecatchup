package com.catchup.app.model.dao;

import com.catchup.app.model.book.CatchBook;
public interface CatchBookDAO {

	public boolean bookExists(String title);

	public void addCatchBook(CatchBook catchBook);
}
