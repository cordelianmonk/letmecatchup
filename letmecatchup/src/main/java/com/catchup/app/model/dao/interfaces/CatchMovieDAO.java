package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CatchMovie;

public interface CatchMovieDAO {

	boolean bookExists(String title);

	void addCatchBook(CatchMovie catchMovie);

}
