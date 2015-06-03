package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CatchMovieDAO;
import com.catchup.app.model.items.CatchMovie;
import com.catchup.app.model.items.User;

@Repository
public class CatchMovieDAOImp implements CatchMovieDAO {
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean catchMovieExists(String title, User user) {
		Session session = factory.getCurrentSession(); 
		List<CatchMovie> list = new ArrayList<CatchMovie>();
		 
		list = session.createQuery("from CatchMovie where title=:title and user_uid=:user")
			.setParameter("title", title)
			.setParameter("user", user.getUid() )
			.list();
 
		if (list.size() > 0) {
			return true;
		} 
		
		return false;
	}

	@Override
	public void addCatchMovie(CatchMovie catchMovie) {
		Session session = factory.getCurrentSession();
		session.persist(catchMovie);
		session.flush();
		
	}

	@Override
	public CatchMovie searchMovieByID(int mid) {
		Session session = factory.getCurrentSession();
		return (CatchMovie) session.get(CatchMovie.class, new Integer(mid) );
	}

	@Override
	public void updateMovie(CatchMovie catchMovie) {
		Session session = factory.getCurrentSession();
		session.update(catchMovie);
		
	}

	@Override
	public void deleteCatchMovie(int mid) {
		Session session = factory.getCurrentSession();
		CatchMovie catchMovie = (CatchMovie) session.get(CatchMovie.class, new Integer (mid) );
		
		if(catchMovie != null){
			session.delete(catchMovie);
		}
		
	}


	

}
