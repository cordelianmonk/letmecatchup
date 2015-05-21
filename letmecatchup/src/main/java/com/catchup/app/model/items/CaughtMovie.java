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
@Table(name="CAUGHTMOVIES",uniqueConstraints = {
		@UniqueConstraint(columnNames = "MID")})
public class CaughtMovie {
	
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="caughtmovies_mid_seq")
    @SequenceGenerator(name="caughtmovies_mid_seq",  
    	sequenceName="caughtmovies_mid_seq", allocationSize=1)
	private int mid;
	
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
	
	public CaughtMovie() {
	}

	public CaughtMovie(User user, Date date, String title, String comment,
			String apiID, int rating) {
		this.user = user;
		this.dateAdded = date;
		this.title = title;
		this.comment = comment;
		this.apiID = apiID;
		this.rating = rating;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
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
	
	
}
