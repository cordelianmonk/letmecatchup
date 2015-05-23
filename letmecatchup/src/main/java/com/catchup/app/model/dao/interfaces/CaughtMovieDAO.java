package com.catchup.app.model.dao.interfaces;

import com.catchup.app.model.items.CaughtMovie;

public interface CaughtMovieDAO {

public void addCaughtMovie(CaughtMovie caughtMovie);

public CaughtMovie searchCaughtMovieByID(int mid);

public void updateCaughtMovie(CaughtMovie caughtMovie);

public void deleteCaughtMovie(int mid);

}
