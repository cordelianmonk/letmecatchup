package com.catchup.app.model.dao.imps;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.catchup.app.model.dao.interfaces.UserDAO;
import com.catchup.app.model.items.User;

@Repository
public class UserDaoImp implements UserDAO {
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User validateUser(String email, String password) {
		Session session = factory.getCurrentSession(); 
		List<User> users = new ArrayList<User>();
		 
		users = session.createQuery("from User where email=:email and password=:password")
			.setParameter("email", email)
			.setParameter("password", password)
			.list();
 
		if (users.size() > 0) {
			
			User user = users.get(0);
			Hibernate.initialize( user.getCatchBookList() );
			Hibernate.initialize( user.getCatchMovieList() );
			Hibernate.initialize( user.getCaughtBookList() );
			Hibernate.initialize( user.getCaughtMovieList() );
			
			return user;
			
		} else {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean userExists(String email) {
		Session session = factory.getCurrentSession(); 
		List<User> users = new ArrayList<User>();
		 
		users = session.createQuery("from User where email=:email")
			.setParameter("email", email)
			.list();
 
		if (users.size() > 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public void addUser(User user) {
		Session session = factory.getCurrentSession();
		session.persist(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public User getUserById(int uid) {
		Session session = factory.getCurrentSession(); 
		List<User> users = new ArrayList<User>();
		
		users = session.createQuery("from User where uid=:uid")
				.setParameter("uid",uid).list();
		
		User user = users.get(0);
		Hibernate.initialize( user.getCatchBookList() );
		Hibernate.initialize( user.getCatchMovieList() );
		Hibernate.initialize( user.getCaughtBookList() );
		Hibernate.initialize( user.getCaughtMovieList() );
		
		return user;
	}

	@Override
	public void updateUser(User user) {
		Session session = factory.getCurrentSession();
		session.update(user);
	}
	

}
