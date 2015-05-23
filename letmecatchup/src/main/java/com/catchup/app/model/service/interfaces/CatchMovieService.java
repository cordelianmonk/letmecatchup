package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.User;

public interface CatchMovieService {

	public boolean newCatchMovie(User user, Date date, String title, String comment, String apiID);

	public CatchMovie searchMovieByID(int mid);

	public void updateMovie(CatchMovie catchMovie);

	public void deleteCatchMovie(int mid);

}
