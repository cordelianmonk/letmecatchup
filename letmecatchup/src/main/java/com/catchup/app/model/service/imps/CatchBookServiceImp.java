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
		
		//if(this.catchBookDAO.bookExists(title) ){
		//	return false;		TODO Needs to be more sophisticated
		//}
		
		CatchBook catchBook = new CatchBook(user, date, title, comment, apiID);
		this.catchBookDAO.addCatchBook(catchBook);
		return true;
		
	}

	
	
	
}
