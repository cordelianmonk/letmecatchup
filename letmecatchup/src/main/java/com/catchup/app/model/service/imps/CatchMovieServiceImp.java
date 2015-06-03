package com.catchup.app.model.service.imps;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.CatchMovieDAO;
import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchMovieService;

@Service
public class CatchMovieServiceImp implements CatchMovieService {
	private CatchMovieDAO catchMovieDAO;

	public void setCatchMovieDAO(CatchMovieDAO catchMovieDAO) {
		this.catchMovieDAO = catchMovieDAO;
	}

	@Override
	@Transactional
	public boolean newCatchMovie(User user, Date date, String title,
			String comment, String apiID) {
		
		if (this.catchMovieDAO.catchMovieExists(title, user) ){
			return false;
		}
		
		CatchMovie catchMovie = new CatchMovie(user, date, title, comment, apiID);
		this.catchMovieDAO.addCatchMovie(catchMovie);
		return true;
		
	}

	@Override
	@Transactional
	public CatchMovie searchMovieByID(int mid) {
		return this.catchMovieDAO.searchMovieByID(mid);
	}

	@Override
	@Transactional
	public void updateMovie(CatchMovie catchMovie) {
		this.catchMovieDAO.updateMovie(catchMovie);
		
	}

	@Override
	@Transactional
	public void deleteCatchMovie(int mid) {
		this.catchMovieDAO.deleteCatchMovie(mid);
		
	}

}
