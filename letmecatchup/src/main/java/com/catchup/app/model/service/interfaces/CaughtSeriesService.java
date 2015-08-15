package com.catchup.app.model.service.interfaces;

import java.sql.Date;

import com.catchup.app.model.items.CaughtSeries;
import com.catchup.app.model.items.User;

public interface CaughtSeriesService {
	
	boolean newCaughtSeries(User user, Date date, String title, String comment,
			String apiID, int rating);

	public CaughtSeries searchCaughtSeriesByID(int sid);

	public void updateCaughtSeries(CaughtSeries caughtSeries);
	
	public void deleteCaughtSeries(int sid);

}
