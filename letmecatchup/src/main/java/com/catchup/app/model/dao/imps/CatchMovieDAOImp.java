package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CatchMovieDAO;
import com.catchup.app.model.items.CatchMovie;

@Repository
public class CatchMovieDAOImp implements CatchMovieDAO {
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean bookExists(String title) {
		Session session = factory.getCurrentSession(); 
		List<CatchMovie> list = new ArrayList<CatchMovie>();
		 
		list = session.createQuery("from CatchMovie where title=:title")
			.setParameter("title", title)
			.list();
 
		if (list.size() > 0) {
			return true;
		} 
		
		return false;
	}

	@Override
	public void addCatchBook(CatchMovie catchMovie) {
		Session session = factory.getCurrentSession();
		session.persist(catchMovie);
		session.flush();
		
	}


	

}
