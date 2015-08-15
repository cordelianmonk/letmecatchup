package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CaughtSeriesDAO;
import com.catchup.app.model.items.CaughtSeries;
import com.catchup.app.model.items.User;

@Repository
public class CaughtSeriesDAOImp implements CaughtSeriesDAO {
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addCaughtSeries(CaughtSeries caughtSeries) {
		Session session = factory.getCurrentSession();
		session.persist(caughtSeries);

	}

	@Override
	public CaughtSeries searchCaughtSeriesByID(int sid) {
		Session session = factory.getCurrentSession();
		return (CaughtSeries)session.get(CaughtSeries.class, new Integer(sid));
	}

	@Override
	public void updateCaughtSeries(CaughtSeries caughtSeries) {
		Session session = factory.getCurrentSession();
		session.update(caughtSeries);
	}

	@Override
	public void deleteCaughtSeries(int sid) {
		Session session = factory.getCurrentSession();
		CaughtSeries caughtSeries = (CaughtSeries)session.get(CaughtSeries.class, new Integer(sid));
		
		if(caughtSeries != null){
			session.delete(caughtSeries);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean caughtSeriesExists(String title, String apiID, User user) {
		Session session = factory.getCurrentSession();
		List<CaughtSeries> list = new ArrayList<CaughtSeries>();

		if(apiID.length() > 0){
			list = session
					.createQuery(
							"from CaughtSeries where apiID=:apiID and user_uid=:user")
					.setParameter("apiID", apiID)
					.setParameter("user", user.getUid())
					.list();
		} else {
			list = session
					.createQuery(
							"from CaughtSeries where title=:title and user_uid=:user")
					.setParameter("title", title)
					.setParameter("user", user.getUid())
					.list();
		}
		

		if (list.size() > 0) {
			return true;
		}

		return false;
	}

}
