package com.niit.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.socialmediabackend.dao.UserDAO;
import com.niit.socialmediabackend.model.ErrorClazz;
import com.niit.socialmediabackend.model.User;

@Controller
public class UserController 
{
	@Autowired
	public UserDAO userDAO;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<?> registration(@RequestBody User user)
	{
		try
		{
			userDAO.registration(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			ErrorClazz errorClazz=new ErrorClazz(1,"Something went wrong" +e.getMessage());
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//middleware get user object from angular js client in JSON fmt
  	//eg. input= {'email':'adam.e@abc.com','password':'qwerst'} 
    
	@RequestMapping(value="/login",method=RequestMethod.PUT)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session){
	User validUser=userDAO.login(user);
	if(validUser==null){//Invalid credentials, Email/pwd is incorrect
		ErrorClazz errorClazz=new ErrorClazz(4,"Invalid email/password...");
		return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
	}
	else{//valid credentials,valid email and password
		//update online status to true
		validUser.setOnline(true);
		userDAO.updateUser(validUser);
		session.setAttribute("loggedInUser", validUser.getEmail());
		System.out.println("Session Id" + session.getId());
		System.out.println("Session Attribute " + session.getAttribute("loggedInUser"));
		System.out.println("Created On " + session.getCreationTime());
		return new ResponseEntity<User>(validUser,HttpStatus.OK);
	}
	}
    @RequestMapping(value="/getalljobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
    	System.out.println("Session Id" + session.getId());
		System.out.println("Session Attribute " + session.getAttribute("loggedInUser"));
		System.out.println("Created On " + session.getCreationTime());
		String email=(String)session.getAttribute("loggedInUser");
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(4,"Unauthorized access... please login..");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
    public ResponseEntity<?> logout(HttpSession session){
		String email=(String)session.getAttribute("loggedInUser");
		if(email==null){
			ErrorClazz errorClazz=new ErrorClazz(4,"Unauthorized access... please login..");
			return new ResponseEntity<ErrorClazz>(errorClazz,HttpStatus.UNAUTHORIZED);
		}
		User user=userDAO.getUser(email);
		user.setOnline(false);
		userDAO.updateUser(user);
		session.removeAttribute("loggedInUser");
		session.invalidate();
    	return new ResponseEntity<Void>(HttpStatus.OK);
    }
    

    

}