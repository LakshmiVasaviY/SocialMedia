package com.niit.socialmediabackend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.socialmediabackend.dao.JobDAO;
import com.niit.socialmediabackend.model.Job;

@Repository
@Transactional

public class JobDAOImpl implements JobDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public void saveJob(Job job) 
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(job);
	}

}
