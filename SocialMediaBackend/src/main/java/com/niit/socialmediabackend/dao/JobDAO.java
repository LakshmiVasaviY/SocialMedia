package com.niit.socialmediabackend.dao;

import java.util.List;

import com.niit.socialmediabackend.model.Job;

public interface JobDAO 
{
	void saveJob(Job job);

	List<Job> getAllJobs();
	

}
