package org.jsp.app.dto;

public class BookDto 
{
	private int bookId;
	private String bookName;
	private String authorName;
	private int pages;
	private double price;
	public int getBookId() 
	{
		return bookId;
	}
	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}
	public String getBookName() 
	{
		return bookName;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	public String getAuthorName() 
	{
		return authorName;
	}
	public void setAuthorName(String authorName) 
	{
		this.authorName = authorName;
	}
	public int getPages() 
	{
		return pages;
	}
	public void setPages(int pages) 
	{
		this.pages = pages;
	}
	public double getPrice() 
	{
		return price;
	}
	public void setPrice(double price) 
	{
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		return " -------- BookInfo : --------- \n"
				+ " Book Title  : " + this.bookName 
				+ "\n Book Author : " + this.authorName  
				+ "\n Book Id     : " + this.bookId 
				+ "\n Book Price  : " + this.price +" \n ";
	}
}
