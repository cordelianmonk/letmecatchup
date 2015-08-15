package com.catchup.app.model.service.imps;

import java.sql.Date;

import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.CaughtSeriesDAO;
import com.catchup.app.model.items.CaughtSeries;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CaughtSeriesService;

public class CaughtSeriesServiceImp implements CaughtSeriesService {
	CaughtSeriesDAO caughtSeriesDAO;
	
	public void setCaughtSeriesDAO(CaughtSeriesDAO caughtSeriesDAO) {
		this.caughtSeriesDAO = caughtSeriesDAO;
	}

	@Override
	@Transactional
	public boolean newCaughtSeries(User user, Date date, String title,
			String comment, String apiID, int rating) {
		
		if( this.caughtSeriesDAO.caughtSeriesExists(title, apiID, user) ){
			return false;
		}
		
		CaughtSeries caughtSeries = new CaughtSeries(apiID, title, comment,rating,date,user);
		this.caughtSeriesDAO.addCaughtSeries(caughtSeries);
		
		return true;
	}

	@Override
	@Transactional
	public CaughtSeries searchCaughtSeriesByID(int sid) {
		return this.caughtSeriesDAO.searchCaughtSeriesByID(sid);
	}

	@Override
	@Transactional
	public void updateCaughtSeries(CaughtSeries caughtSeries) {
		this.caughtSeriesDAO.updateCaughtSeries(caughtSeries);
	}

	@Override
	@Transactional
	public void deleteCaughtSeries(int sid) {
		this.caughtSeriesDAO.deleteCaughtSeries(sid);

	}

}
