package org.jsp.app.services;

import org.jsp.app.dao.BookDao;
import org.jsp.app.dao.BookDaoImplementation;

public class BookManager 
{
	public static BookDao getBookDao()
	{
		BookDao dao = new BookDaoImplementation();
		return dao;
	}
}
