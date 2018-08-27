package com.niit.socialmediabackend.model;

public class ErrorClazz 
{
	private int errorCode;
	private String errorMesg;
	public int getErrorcode() 
	{
		return errorCode;
	}
	public void setErrorCode(int errorCode) 
	{
		this.errorCode = errorCode;
	}
	public String getErrorMesg() 
	{
		return errorMesg;
	}
	public void setErrorMesg(String errorMesg) 
	{
		this.errorMesg = errorMesg;
	}
	public ErrorClazz(int errorCode, String errorMesg) 
	{
		super();
		this.errorCode = errorCode;
		this.errorMesg = errorMesg;
	}
	

}
