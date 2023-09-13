package org.jsp.app.services.exception;

public class BookNotFoundException extends RuntimeException
{
	@Override
	public String toString() 
	{
		return "No Book Record Found...";
	}
}
