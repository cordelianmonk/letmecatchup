package com.catchup.app.model.service.imps;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.CatchBookDAO;
import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchBookService;

@Service
public class CatchBookServiceImp implements CatchBookService {
	private CatchBookDAO catchBookDAO;
	
	public void setCatchBookDAO(CatchBookDAO catchBookDAO) {
		this.catchBookDAO = catchBookDAO;
	}

	@Override
	@Transactional
	public boolean newCatchBook(User user, Date date, String title, String comment, String apiID) {
				
		CatchBook catchBook = new CatchBook(user, date, title, comment, apiID);
		this.catchBookDAO.addCatchBook(catchBook);
		return true;
		
	}

	@Override
	@Transactional
	public CatchBook searchBookByID(int bid) {
		return this.catchBookDAO.searchCatchBookByID(bid);
	}

	@Override
	@Transactional
	public void updateBook(CatchBook catchBook) {
		this.catchBookDAO.updateCatchBook(catchBook);
	}

	@Override
	@Transactional
	public void deleteCatchBook(int bid) {
		this.catchBookDAO.deleteCatchBook(bid);
	}

	
	
	
}
