package com.catchup.app.model.service;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.book.CatchBook;
import com.catchup.app.model.dao.CatchBookDAO;
import com.catchup.app.model.user.User;

@Service
public class CatchBookServiceImp implements CatchBookService {
	private CatchBookDAO catchBookDAO;
	
	public void setCatchBookDAO(CatchBookDAO catchBookDAO) {
		this.catchBookDAO = catchBookDAO;
	}

	@Override
	@Transactional
	public boolean newCatchBook(User user, Date date, String title, String comment) {
		
		if(this.catchBookDAO.bookExists(title) ){
			return false;
		}
		
		CatchBook catchBook = new CatchBook(user, date, title, comment);
		this.catchBookDAO.addCatchBook(catchBook);
		return true;
		
	}

	
	
	
}
