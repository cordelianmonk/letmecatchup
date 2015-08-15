package com.catchup.app.model.service.imps;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.CaughtBookDAO;
import com.catchup.app.model.items.CaughtBook;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CaughtBookService;

@Service
public class CaughtBookServiceImp implements CaughtBookService {
	private CaughtBookDAO caughtBookDAO;
	
	public void setCaughtBookDAO(CaughtBookDAO caughtBookDAO) {
		this.caughtBookDAO = caughtBookDAO;
	}

	@Override
	@Transactional
	public boolean newCaughtBook(User user, Date date, String title,
		String comment, String apiID, int rating) {
		
		if(this.caughtBookDAO.caughtBookExists(title, apiID, user)){
			return false;
		}
		
		CaughtBook caughtBook = new CaughtBook(user, date, title, comment, apiID, rating);
		
		this.caughtBookDAO.addCaughtBook(caughtBook);
		return true;
		
	}

	@Override
	@Transactional
	public CaughtBook searchCaughtBookByID(int bid) {
		return this.caughtBookDAO.searchCaughtBookByID(bid);
	}

	@Override
	@Transactional
	public void updateCaughtBook(CaughtBook caughtBook) {
		this.caughtBookDAO.updateCaughtBook(caughtBook);
	}
	
	@Override
	@Transactional
	public void deleteCaughtBook(int bid) {
		this.caughtBookDAO.deleteCaughtBook(bid);
	}

}
