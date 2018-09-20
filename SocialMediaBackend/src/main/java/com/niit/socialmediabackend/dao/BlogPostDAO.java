package com.niit.socialmediabackend.dao;

import java.util.List;

import com.niit.socialmediabackend.model.BlogPost;

public interface BlogPostDAO 
{
	void addBlogPost(BlogPost blogPost);
	List<BlogPost> getApprovedBlogs();
	List<BlogPost> getBlogsWaitingForApproval();
	BlogPost getBlogPost(int id);
	void updateBlogPost(BlogPost blogPost);
	//updating approval status from false to true
	//can also be used for updating content of the blogpost
	void deleteBlogPost(BlogPost blogPost);

}
