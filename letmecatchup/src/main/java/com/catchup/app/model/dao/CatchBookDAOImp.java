package com.catchup.app.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.book.CatchBook;
import com.catchup.app.model.movie.CatchMovie;
import com.catchup.app.model.user.User;

@Repository
public class CatchBookDAOImp implements CatchBookDAO{
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

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
		session.flush();
	}

}
