package com.niit.socialmediabackend.dao;

import com.niit.socialmediabackend.model.User;

public interface UserDAO 
{
	void registration(User user);
	boolean isEmailUnique(String email);

}
