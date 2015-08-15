package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CaughtMovie;
import com.catchup.app.model.items.User;

public interface CaughtMovieDAO {

	public void addCaughtMovie(CaughtMovie caughtMovie);

	public CaughtMovie searchCaughtMovieByID(int mid);

	public void updateCaughtMovie(CaughtMovie caughtMovie);

	public void deleteCaughtMovie(int mid);

	public boolean caughtMovieExists(String title, String apiID, User user);

}
