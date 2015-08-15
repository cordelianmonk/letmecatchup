package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CatchSeries;
import com.catchup.app.model.items.User;

public interface CatchSeriesDAO {
	public boolean catchSeriesExists(String title, String apiID, User user);

	public void addCatchSeries(CatchSeries catchSeries);

	public CatchSeries searchSeriesByID(int sid);

	public void updateSeries(CatchSeries catchSeries);

	public void deleteCatchSeries(int sid);
}
