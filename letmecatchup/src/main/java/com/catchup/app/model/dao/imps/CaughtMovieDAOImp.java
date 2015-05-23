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

	@Override
	public CaughtMovie searchCaughtMovieByID(int mid) {
		Session session = factory.getCurrentSession();
		return (CaughtMovie) session.get(CaughtMovie.class, new Integer(mid) );
	}

	@Override
	public void updateCaughtMovie(CaughtMovie caughtMovie) {
		Session session = factory.getCurrentSession();
		session.update(caughtMovie);
	}

	@Override
	public void deleteCaughtMovie(int mid) {
		Session session = factory.getCurrentSession();
		CaughtMovie caughtMovie = (CaughtMovie) session.get(CaughtMovie.class, new Integer (mid));
		
		if(caughtMovie!=null){
			session.delete(caughtMovie);
		}
		
	}
	
}
