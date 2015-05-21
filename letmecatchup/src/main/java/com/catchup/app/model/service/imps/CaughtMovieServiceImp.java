package com.catchup.app.model.service.imps;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.CaughtMovieDAO;
import com.catchup.app.model.items.CaughtMovie;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CaughtMovieService;

@Service
public class CaughtMovieServiceImp implements CaughtMovieService {
	private CaughtMovieDAO caughtMovieDAO;
	
	public void setCaughtMovieDAO(CaughtMovieDAO caughtMovieDAO) {
		this.caughtMovieDAO = caughtMovieDAO;
	}

	@Override
	@Transactional
	public boolean newCaughtMovie(User user, Date date, String title,
			String comment, String apiID, int rating) {
		
		CaughtMovie caughtMovie = new CaughtMovie(user, date, title, comment, apiID, rating);
		this.caughtMovieDAO.addCaughtMovie(caughtMovie);
		return true;
		
	}

}
