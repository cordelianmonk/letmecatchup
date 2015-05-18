package com.catchup.app.model.service;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.book.CatchBook;
import com.catchup.app.model.dao.CatchMovieDAO;
import com.catchup.app.model.movie.CatchMovie;
import com.catchup.app.model.user.User;

@Service
public class CatchMovieServiceImp implements CatchMovieService {
	private CatchMovieDAO catchMovieDAO;

	public void setCatchMovieDAO(CatchMovieDAO catchMovieDAO) {
		this.catchMovieDAO = catchMovieDAO;
	}

	@Override
	@Transactional
	public boolean newCatchMovie(User user, Date date, String title,
			String comment) {
		
		if(this.catchMovieDAO.bookExists(title) ){
			return false;
		}
		
		CatchMovie catchMovie = new CatchMovie(user, date, title, comment);
		this.catchMovieDAO.addCatchBook(catchMovie);
		return true;
		
	}

}
