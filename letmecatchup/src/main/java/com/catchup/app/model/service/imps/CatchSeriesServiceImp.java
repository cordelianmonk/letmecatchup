package com.catchup.app.model.service.imps;

import java.sql.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catchup.app.model.dao.interfaces.CatchSeriesDAO;
import com.catchup.app.model.items.CatchSeries;
import com.catchup.app.model.items.User;
import com.catchup.app.model.service.interfaces.CatchSeriesService;

@Service
public class CatchSeriesServiceImp implements CatchSeriesService {
	private CatchSeriesDAO catchSeriesDAO;

	public void setCatchSeriesDAO(CatchSeriesDAO catchSeriesDAO) {
		this.catchSeriesDAO = catchSeriesDAO;
	}

	@Override
	@Transactional
	public boolean newCatchSeries(User user, Date date, String title,
			String comment, String apiID) {
		
		if(this.catchSeriesDAO.catchSeriesExists(title, apiID, user)){
			return false;
		}
		
		CatchSeries catchSeries = new CatchSeries(apiID, title, comment, date, user);
		this.catchSeriesDAO.addCatchSeries(catchSeries);
		return true;
	}

	@Override
	@Transactional
	public CatchSeries searchCatchSeriesByID(int sid) {
		return this.catchSeriesDAO.searchSeriesByID(sid);
	}

	@Override
	@Transactional
	public void updateCatchSeries(CatchSeries catchSeries) {
		this.catchSeriesDAO.updateSeries(catchSeries);

	}

	@Override
	@Transactional
	public void deleteCatchSeries(int sid) {
		this.catchSeriesDAO.deleteCatchSeries(sid);
	}

}
