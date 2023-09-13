package org.jsp.app.dao;

import java.sql.SQLException;

import java.util.ArrayList;

import org.jsp.app.dto.BookDto;

public interface BookDao 
{
	void addBook(BookDto dto) throws Exception;  //1
	ArrayList<BookDto> searchBookTitle(String title) throws Exception;   //2
	ArrayList<BookDto> searchBookAuthor(String authorName) throws Exception;   //3
	void updateBookPrice(int id, double price) throws Exception;   //4
	boolean removeBook(int id) throws Exception;   //5
	ArrayList<Integer> getIds() throws Exception;   //6
	ArrayList<BookDto> getAllBooks() throws Exception;   //7
	ArrayList<BookDto> sortBooks(int ch) throws Exception;   //8
}
