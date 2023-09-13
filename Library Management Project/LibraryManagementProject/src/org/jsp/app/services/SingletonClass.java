package org.jsp.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonClass 
{
	private static final SingletonClass ONLY_ONE_OBJECT  = new SingletonClass();
	private Connection connection = null;
	private SingletonClass()
	{
		try 
		{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Litish17@");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public static SingletonClass getObject()
	{
		return ONLY_ONE_OBJECT;
	}
	public Connection getDatabaseConnection()
	{
		return connection;
	}

	@Override
	protected void finalize() throws Throwable 
	{
		 if (connection != null) 
		 {
			connection.close();
		 }
	}
}
