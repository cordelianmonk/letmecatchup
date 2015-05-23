package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CatchBookDAO;
import com.catchup.app.model.items.CatchBook;
import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.User;

@Repository
public class CatchBookDAOImp implements CatchBookDAO{
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//TODO I think this needs to be revised. 
	@SuppressWarnings("unchecked")
	@Override
	public boolean bookExists(String title) {
		Session session = factory.getCurrentSession(); 
		List<CatchBook> books = new ArrayList<CatchBook>();
		 
		books = session.createQuery("from CatchBook where title=:title")
			.setParameter("title", title)
			.list();
 
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
	public CatchBook searchBookByID(int bid) {
		Session session = factory.getCurrentSession();
		return (CatchBook) session.get(CatchBook.class, new Integer (bid) );
		
	}

	@Override
	public void updateBook(CatchBook catchBook) {
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
