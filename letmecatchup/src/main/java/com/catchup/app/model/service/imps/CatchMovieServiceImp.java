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
		
		//if(this.catchMovieDAO.bookExists(title) ){
		//	return false; TODO Needs to be more sophisticated
		//}
		
		CatchMovie catchMovie = new CatchMovie(user, date, title, comment, apiID);
		this.catchMovieDAO.addCatchBook(catchMovie);
		return true;
		
	}

}
