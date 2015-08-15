package com.catchup.app.model.items;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CAUGHTSERIES", uniqueConstraints = { @UniqueConstraint(columnNames = "SID") })
public class CaughtSeries implements Comparable<CaughtSeries>{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caughtseries_sid_seq")
	@SequenceGenerator(name = "caughtseries_sid_seq", sequenceName = "caughtseries_sid_seq", allocationSize = 1)
	private int sid;

	@Column
	private String apiID;

	@Column
	private String title;

	@Column
	private String comment;

	@Column
	private int rating;

	@Column
	private Date dateAdded;

	@ManyToOne
	private User user;
	
	public CaughtSeries(){};

	public CaughtSeries(String apiID, String title, String comment, int rating,
			Date dateAdded, User user) {
		this.apiID = apiID;
		this.title = title;
		this.comment = comment;
		this.rating = rating;
		this.dateAdded = dateAdded;
		this.user = user;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getApiID() {
		return apiID;
	}

	public void setApiID(String apiID) {
		this.apiID = apiID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int compareTo(CaughtSeries caughtSeries) {
		int compareRating = ( (CaughtSeries) caughtSeries).getRating() ;
		
		return compareRating-this.rating;
	}

}
