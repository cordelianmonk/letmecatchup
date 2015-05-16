package com.catchup.app.model.movie;

import com.catchup.app.model.user.User;

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
@Table(name="CATCHMOVIES",uniqueConstraints = {
		@UniqueConstraint(columnNames = "MID")})
public class CatchMovie {
	
	@Id
	@Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="catchbooks_bid_seq")
    @SequenceGenerator(name="catchbooks_bid_seq",  sequenceName="catchbooks_bid_seq", allocationSize=1)
	private int mid;
	
	@Column
	private String apiID;
	
	@Column
	private String title;
	
	@Column
	private String comment;
	
	@Column
	private String dateAdded; //TODO Should this be Data object?
	
	@ManyToOne
	private User user;
	
	public CatchMovie() {
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
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
