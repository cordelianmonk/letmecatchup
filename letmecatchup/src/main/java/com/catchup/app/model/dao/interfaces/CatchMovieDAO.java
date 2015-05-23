package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CatchMovie;

public interface CatchMovieDAO {

	public boolean catchMovieExists(String title);

	public void addCatchMovie(CatchMovie catchMovie);

	public CatchMovie searchMovieByID(int mid);

	public void updateMovie(CatchMovie catchMovie);

	public void deleteCatchMovie(int mid);

}
