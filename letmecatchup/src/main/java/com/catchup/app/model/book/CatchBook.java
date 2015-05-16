package com.catchup.app.model.book;

import java.sql.Date;

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
@Table(name="CATCHBOOKS", uniqueConstraints={@UniqueConstraint(columnNames={"BID"})})
public class CatchBook { 
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="catchmovies_mid_seq")
    @SequenceGenerator(name="catchmovies_mid_seq",  sequenceName="catchmovies_mid_seq", allocationSize=1)
	private int bid;
	
	@Column
	private String apiID;
	
	@Column
	private String title;
	
	@Column
	private String comment;
	
	@Column
	private Date dateAdded; //TODO Should this be Data object?
	
	@ManyToOne
	private User user;
	
	public CatchBook() {
		// TODO Auto-generated constructor stub
	}

	public CatchBook(User	user, Date date, String title, String comment) {
		this.user = user;
		this.dateAdded = date;
		this.title = title;
		this.comment=comment;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
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
