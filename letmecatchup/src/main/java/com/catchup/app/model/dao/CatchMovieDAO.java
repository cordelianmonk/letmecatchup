package com.catchup.app.model.dao;

import com.catchup.app.model.movie.CatchMovie;

public interface CatchMovieDAO {

	boolean bookExists(String title);

	void addCatchBook(CatchMovie catchMovie);

}
