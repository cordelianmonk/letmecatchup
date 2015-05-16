package com.catchup.app.model.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.catchup.app.model.book.CatchBook;
import com.catchup.app.model.book.CaughtBook;
import com.catchup.app.model.movie.CatchMovie;
import com.catchup.app.model.movie.CaughtMovie;

@Entity
@Table(name="USERS", uniqueConstraints={@UniqueConstraint(columnNames={"UID"})})
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_uid")
	private List<CatchBook> catchBookList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_uid")
	private List<CaughtBook> caughtBookList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_uid")
	private List<CatchMovie> catchMovieList;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_uid")
	private List<CaughtMovie> caughtMovieList;
	
	public User() {
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CatchBook> getCatchBookList() {
		return catchBookList;
	}

	public void setCatchBookList(List<CatchBook> catchBookList) {
		this.catchBookList = catchBookList;
	}

	public List<CaughtBook> getCaughtBookList() {
		return caughtBookList;
	}

	public void setCaughtBookList(List<CaughtBook> caughtBookList) {
		this.caughtBookList = caughtBookList;
	}

	public List<CatchMovie> getCatchMovieList() {
		return catchMovieList;
	}

	public void setCatchMovieList(List<CatchMovie> catchMovieList) {
		this.catchMovieList = catchMovieList;
	}

	public List<CaughtMovie> getCaughtMovieList() {
		return caughtMovieList;
	}

	public void setCaughtMovieList(List<CaughtMovie> caughtMovieList) {
		this.caughtMovieList = caughtMovieList;
	}

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
}
