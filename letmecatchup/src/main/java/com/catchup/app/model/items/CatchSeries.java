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
@Table(name = "CATCHSERIES", uniqueConstraints = { @UniqueConstraint(columnNames = { "SID" }) })
public class CatchSeries {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catchseries_sid_seq")
	@SequenceGenerator(name = "catchseries_sid_seq", sequenceName = "catchseries_sid_seq", allocationSize = 1)
	private int sid;

	@Column
	private String apiID;

	@Column
	private String title;

	@Column
	private String comment;

	@Column
	private Date dateAdded;

	@ManyToOne
	private User user;

	public CatchSeries() {

	}

	public CatchSeries(String apiID, String title, String comment,
			Date dateAdded, User user) {
		this.apiID = apiID;
		this.title = title;
		this.comment = comment;
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
