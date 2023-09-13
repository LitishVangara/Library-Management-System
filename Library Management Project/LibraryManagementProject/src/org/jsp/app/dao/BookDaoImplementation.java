package org.jsp.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import org.jsp.app.dto.BookDto;
import org.jsp.app.services.SingletonClass;
import org.jsp.app.services.exception.BookNotFoundException;

public class BookDaoImplementation implements BookDao 
{
	private SingletonClass object = SingletonClass.getObject();
	private Connection connection = object.getDatabaseConnection();
	PreparedStatement ps = null;
	
	@Override
	public void addBook(BookDto dto) throws Exception    //1
	{
		String query = "insert into litishdatabase.bookdetails values(?,?,?,?,?)";
		ps = connection.prepareStatement(query);
		ps.setInt(1, dto.getBookId());
		ps.setString(2, dto.getBookName());
		ps.setString(3, dto.getAuthorName());
		ps.setInt(4, dto.getPages());
		ps.setDouble(5, dto.getPrice());
		ps.executeUpdate();
		System.out.println("Book Added successfully...");
	}

	@Override
	public ArrayList<BookDto> searchBookTitle(String title) throws Exception    //2
	{
		String query = "select * from litishdatabase.bookdetails where bookName = ?";
		ArrayList<BookDto> resultList = new ArrayList<BookDto>();
		ps = connection.prepareStatement(query);
		ps.setString(1, title);
		ResultSet executeQuery = ps.executeQuery();
		if (executeQuery != null) 
		{
			while (executeQuery.next()) 
			{
				BookDto dto = new BookDto();
				dto.setBookId(executeQuery.getInt("bookId"));
				dto.setBookName(executeQuery.getString("bookName"));
				dto.setAuthorName(executeQuery.getString("authorName"));
				dto.setPages(executeQuery.getInt("pages"));
				dto.setPrice(executeQuery.getDouble("price"));
				resultList.add(dto);
			}
			return resultList;
		} 
		else 
		{
			throw new BookNotFoundException();
		}
	}

	@Override
	public ArrayList<BookDto> searchBookAuthor(String authorName) throws Exception    //3
	{
		String query = "select * from litishdatabase.bookdetails where authorName = ?";
		ArrayList<BookDto> resultList = new ArrayList<BookDto>();
		ps = connection.prepareStatement(query);
		ps.setString(1, authorName);
		ResultSet executeQuery = ps.executeQuery();
		if (executeQuery != null) 
		{
			while (executeQuery.next()) 
			{
				BookDto dto = new BookDto();
				dto.setBookId(executeQuery.getInt("bookId"));
				dto.setBookName(executeQuery.getString("bookName"));
				dto.setAuthorName(executeQuery.getString("authorName"));
				dto.setPages(executeQuery.getInt("pages"));
				dto.setPrice(executeQuery.getDouble("price"));
				resultList.add(dto);
			}
			return resultList;
		} 
		else 
		{
			throw new BookNotFoundException();
		}
	}

	@Override
	public void updateBookPrice(int id, double price) throws Exception    //4
	{
		String query = "update litishdatabase.bookdetails set price = ? where bookid = ?";
		ps = connection.prepareStatement(query);
		ps.setDouble(1, price);
		ps.setInt(2, id);
		int executeUpdate = ps.executeUpdate();
		if (executeUpdate > 0) 
		{
			System.out.println("Book price update successfully...");
		} 
		else 
		{
			throw new BookNotFoundException();
		}

	}

	@Override
	public boolean removeBook(int id) throws Exception    //5
	{
		String query = "delete from litishdatabase.bookdetails where bookId = ?";
		ps = connection.prepareStatement(query);
		ps.setInt(1, id);
		int executeUpdate = ps.executeUpdate();
		if (executeUpdate > 0) 
		{
			return true;
		} 
		else 
		{
			throw new BookNotFoundException();
		}
	}

	@Override
	public ArrayList<Integer> getIds() throws Exception    //6
	{
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		String query = "select bookId from litishdatabase.bookdetails";
		Statement stmt = connection.createStatement();
		ResultSet executeQuery = stmt.executeQuery(query);
		if (executeQuery != null) 
		{
			while (executeQuery.next()) 
			{
				resultList.add(executeQuery.getInt("bookId"));
			}
			return resultList;
		} 
		else 
		{
			throw new BookNotFoundException();
		}

	}

	@Override
	public ArrayList<BookDto> getAllBooks() throws Exception    //7
	{
		ArrayList<BookDto> resultList = new ArrayList<BookDto>();
		String query = "select * from litishdatabase.bookdetails";
		Statement stmt = connection.createStatement();
		ResultSet executeQuery = stmt.executeQuery(query);
		if (executeQuery != null) 
		{
			while (executeQuery.next()) 
			{
				BookDto dto = new BookDto();
				dto.setBookId(executeQuery.getInt("bookId"));
				dto.setBookName(executeQuery.getString("bookName"));
				dto.setAuthorName(executeQuery.getString("authorName"));
				dto.setPages(executeQuery.getInt("pages"));
				dto.setPrice(executeQuery.getDouble("price"));
				resultList.add(dto);
			}
			return resultList;
		} 
		else 
		{
			throw new BookNotFoundException();
		}
	}

	@Override
	public ArrayList<BookDto> sortBooks(int ch) throws Exception    //8
	{
		switch (ch) 
		{
			case 1: 
			{
				ArrayList<BookDto> resultList = new ArrayList<BookDto>();
				String query = "select * from litishdatabase.bookdetails order by bookId";
				Statement stmt = connection.createStatement();
				ResultSet executeQuery = stmt.executeQuery(query);
				if (executeQuery != null) 
				{
					while (executeQuery.next()) 
					{
						BookDto dto = new BookDto();
						dto.setBookId(executeQuery.getInt("bookId"));
						dto.setBookName(executeQuery.getString("bookName"));
						dto.setAuthorName(executeQuery.getString("authorName"));
						dto.setPages(executeQuery.getInt("pages"));
						dto.setPrice(executeQuery.getDouble("price"));
						resultList.add(dto);
					}
					return resultList;
				} 
				else 
				{
					throw new BookNotFoundException();
				}
			}
			case 2: 
			{
				ArrayList<BookDto> resultList = new ArrayList<BookDto>();
				String query = "select * from litishdatabase.bookdetails order by bookName";
				Statement stmt = connection.createStatement();
				ResultSet executeQuery = stmt.executeQuery(query);
				if (executeQuery != null) 
				{
					while (executeQuery.next()) 
					{
						BookDto dto = new BookDto();
						dto.setBookId(executeQuery.getInt("bookId"));
						dto.setBookName(executeQuery.getString("bookName"));
						dto.setAuthorName(executeQuery.getString("authorName"));
						dto.setPages(executeQuery.getInt("pages"));
						dto.setPrice(executeQuery.getDouble("price"));
						resultList.add(dto);
					}
					return resultList;
				} 
				else 
				{
					throw new BookNotFoundException();
				}
			}
			case 3: 
			{
				ArrayList<BookDto> resultList = new ArrayList<BookDto>();
				String query = "select * from litishdatabase.bookdetails order by authorName";
				Statement stmt = connection.createStatement();
				ResultSet executeQuery = stmt.executeQuery(query);
				if (executeQuery != null) 
				{
					while (executeQuery.next()) 
					{
						BookDto dto = new BookDto();
						dto.setBookId(executeQuery.getInt("bookId"));
						dto.setBookName(executeQuery.getString("bookName"));
						dto.setAuthorName(executeQuery.getString("authorName"));
						dto.setPages(executeQuery.getInt("pages"));
						dto.setPrice(executeQuery.getDouble("price"));
						resultList.add(dto);
					}
					return resultList;
				} 
				else 
				{
					throw new BookNotFoundException();
				}
			}
			case 4: 
			{
				ArrayList<BookDto> resultList = new ArrayList<BookDto>();
				String query = "select * from litishdatabase.bookdetails order by price";
				Statement stmt = connection.createStatement();
				ResultSet executeQuery = stmt.executeQuery(query);
				if (executeQuery != null) 
				{
					while (executeQuery.next()) 
					{
						BookDto dto = new BookDto();
						dto.setBookId(executeQuery.getInt("bookId"));
						dto.setBookName(executeQuery.getString("bookName"));
						dto.setAuthorName(executeQuery.getString("authorName"));
						dto.setPages(executeQuery.getInt("pages"));
						dto.setPrice(executeQuery.getDouble("price"));
						resultList.add(dto);
					}
					return resultList;
				} 
				else 
				{
					throw new BookNotFoundException();
				}
			}
		default:
				System.err.println("Please Enter Valid Choice...");
			break;
		}
		return null;
	}
}
