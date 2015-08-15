package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CatchBookDAO;
import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.User;

@Repository
public class CatchBookDAOImp implements CatchBookDAO{
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean catchBookExists(String title, String apiID, User user) {
		Session session = factory.getCurrentSession(); 
		List<CatchBook> books = new ArrayList<CatchBook>();
		
		if( apiID.length()>0 ){
			books = session.createQuery("from CatchBook where apiID=:apiID and user_uid=:user")
					.setParameter("apiID", apiID)
					.setParameter("user", user.getUid() )
					.list();
		} else {
			books = session.createQuery("from CatchBook where title=:title and user_uid=:user")
					.setParameter("title", title)
					.setParameter("user", user.getUid() )
					.list();
		}
		
		if (books.size() > 0) {
			return true;
		} 
		
		return false;
	}

	@Override
	public void addCatchBook(CatchBook catchBook) {
		Session session = factory.getCurrentSession();
		session.persist(catchBook);
	}

	@Override
	public CatchBook searchCatchBookByID(int bid) {
		Session session = factory.getCurrentSession();
		return (CatchBook) session.get(CatchBook.class, new Integer (bid) );
		
	}

	@Override
	public void updateCatchBook(CatchBook catchBook) {
		Session session = factory.getCurrentSession();
		session.update(catchBook);
		
	}

	@Override
	public void deleteCatchBook(int bid) {
		Session session = factory.getCurrentSession();
		CatchBook catchBook = (CatchBook) session.load(CatchBook.class, bid);
		if(catchBook != null){
			session.delete(catchBook);
		}
	}

}
