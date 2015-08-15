package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.User;

public interface CatchMovieDAO {

	public boolean catchMovieExists(String title, String apiID, User user);

	public void addCatchMovie(CatchMovie catchMovie);

	public CatchMovie searchMovieByID(int mid);

	public void updateMovie(CatchMovie catchMovie);

	public void deleteCatchMovie(int mid);
	
}
