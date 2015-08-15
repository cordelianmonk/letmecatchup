package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CaughtBookDAO;
import com.catchup.app.model.items.CaughtBook;
import com.catchup.app.model.items.User;

@Repository
public class CaughtBookDAOImp implements CaughtBookDAO {
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addCaughtBook(CaughtBook caughtBook) {
		Session session = factory.getCurrentSession();
		session.persist(caughtBook);
		
	}

	@Override
	public CaughtBook searchCaughtBookByID(int bid) {
		Session session = factory.getCurrentSession();
		return (CaughtBook) session.get(CaughtBook.class, new Integer (bid) );
	}

	@Override
	public void updateCaughtBook(CaughtBook caughtBook) {
		Session session = factory.getCurrentSession();
		session.update(caughtBook);
	}

	@Override
	public void deleteCaughtBook(int bid) {
		Session session = factory.getCurrentSession();
		CaughtBook caughtBook = (CaughtBook) session.get(CaughtBook.class, new Integer(bid));
		
		if(caughtBook != null){
			session.delete(caughtBook);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean caughtBookExists(String title, String apiID, User user) {
		Session session = factory.getCurrentSession(); 
		List<CaughtBook> books = new ArrayList<CaughtBook>();
		 
		if(apiID.length() > 0){
			books = session.createQuery("from CaughtBook where apiID=:apiID and user_uid=:user")
					.setParameter("apiID", apiID)
					.setParameter("user", user.getUid() )
					.list();
		} else {
			books = session.createQuery("from CaughtBook where title=:title and user_uid=:user")
					.setParameter("title", title)
					.setParameter("user", user.getUid() )
					.list();
		}
		
		
 
		if (books.size() > 0) {
			return true;
		} 
		
		return false;
	}

}
