package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.CatchSeriesDAO;
import com.catchup.app.model.items.CatchSeries;
import com.catchup.app.model.items.User;

@Repository
public class CatchSeriesDAOImp implements CatchSeriesDAO {
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean catchSeriesExists(String title, String apiID, User user) {
		Session session = factory.getCurrentSession();

		List<CatchSeries> list = new ArrayList<CatchSeries>();

		if (apiID.length() > 0) {
			list = session
					.createQuery(
							"from CatchSeries where apiID=:apiID and user_uid=:user")
					.setParameter("apiID", apiID)
					.setParameter("user", user.getUid())
					.list();
		} else {
			list = session
					.createQuery(
							"from CatchSeries where title=:title and user_uid=:user")
					.setParameter("title", title)
					.setParameter("user", user.getUid())
					.list();
		}

		if (list.size() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public void addCatchSeries(CatchSeries catchSeries) {
		Session session = factory.getCurrentSession();
		session.persist(catchSeries);
		session.flush();
	}

	@Override
	public CatchSeries searchSeriesByID(int sid) {
		Session session = factory.getCurrentSession();
		return (CatchSeries) session.get(CatchSeries.class, new Integer(sid));
	}

	@Override
	public void updateSeries(CatchSeries catchSeries) {
		Session session = factory.getCurrentSession();
		session.update(catchSeries);
	}

	@Override
	public void deleteCatchSeries(int sid) {
		Session session = factory.getCurrentSession();

		CatchSeries catchSeries = (CatchSeries) session.get(CatchSeries.class,
				new Integer(sid));

		if (catchSeries != null) {
			session.delete(catchSeries);
		}

	}

}
