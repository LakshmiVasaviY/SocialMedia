package com.niit.socialmediabackend.daoimpl;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.socialmediabackend.dao.UserDAO;
import com.niit.socialmediabackend.model.User;
@Repository
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDAOImpl()
	{
		System.out.println("UserDAOImpl bean is created");
	}
	public void registration(User user) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		
	}

	public boolean isEmailUnique(String email) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from user where email=?");
		query.setString(0, email);
		User user=(User)query.uniqueResult();
		if(user!=null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}

}
