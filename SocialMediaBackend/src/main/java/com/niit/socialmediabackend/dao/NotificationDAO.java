package com.niit.socialmediabackend.dao;

import java.util.List;

import com.niit.socialmediabackend.model.Notification;

public interface NotificationDAO 
{
	void addNotification(Notification notification);
	List<Notification> getNotificationNotViewed(String email);
	Notification  getNotification(int id);
	void  updateNotification(int id);
}
