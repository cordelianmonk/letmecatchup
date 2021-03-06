package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.CatchSeries;
import com.catchup.app.model.items.User;

public interface CatchSeriesService {
	
	public boolean newCatchSeries(User user, Date date, String title, String comment, String apiID);

	public CatchSeries searchCatchSeriesByID(int sid);

	public void updateCatchSeries(CatchSeries catchSeries);
	
	public void deleteCatchSeries(int sid);
	
}
