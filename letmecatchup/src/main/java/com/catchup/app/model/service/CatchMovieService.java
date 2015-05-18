package com.catchup.app.model.service;

import java.sql.Date;

import com.catchup.app.model.user.User;

public interface CatchMovieService {

	boolean newCatchMovie(User user, Date date, String title, String comment);

}
