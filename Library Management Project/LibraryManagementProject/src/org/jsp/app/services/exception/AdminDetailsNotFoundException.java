package org.jsp.app.services.exception;

public class AdminDetailsNotFoundException extends RuntimeException
{
	@Override
	public String toString() 
	{
		return "Admin Details are Invalid...";
	} 
}
