package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CaughtSeries;
import com.catchup.app.model.items.User;

public interface CaughtSeriesDAO {
	
	public void addCaughtSeries(CaughtSeries caughtSeries);
	
	public CaughtSeries searchCaughtSeriesByID(int sid);
	
	public void updateCaughtSeries(CaughtSeries caughtSeries);
	
	public void deleteCaughtSeries(int sid);
	
	public boolean caughtSeriesExists(String title, String apiID, User user);

}
