package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.CaughtMovie;
import com.catchup.app.model.items.User;

public interface CaughtMovieService {

	boolean newCaughtMovie(User user, Date date, String title, String comment,
			String apiID, int rating);

	public CaughtMovie searchCaughtMovieByID(int mid);

	public void updateCaughtMovie(CaughtMovie caughtMovie);

	public void deleteCaughtMovie(int mid);

}
