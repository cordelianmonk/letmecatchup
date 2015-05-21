package com.catchup.app.model.dao.imps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CaughtMovieDAO;
import com.catchup.app.model.items.CaughtMovie;

@Repository
public class CaughtMovieDAOImp implements CaughtMovieDAO {
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addCaughtMovie(CaughtMovie caughtMovie) {
		Session session = factory.getCurrentSession();
		session.persist(caughtMovie);		
	}
	
}
