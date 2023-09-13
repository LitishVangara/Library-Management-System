package org.jsp.app.controller.utility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.jsp.app.dao.BookDao;
import org.jsp.app.dto.BookDto;

import org.jsp.app.services.BookManager;
import org.jsp.app.services.exception.BookNotFoundException;

public class Librarian extends Thread 
{
	Scanner scan = new Scanner(System.in);
	public void performOperation() throws Exception 
	{
		System.out.println("Enter 1 to Add a Book....");
		System.out.println("Enter 2 to Search  Book based on Title...");
		System.out.println("Enter 3 to Search Book based on Author...");
		System.out.println("Enter 4 to UpdatePrice of a Book...");
		System.out.println("Enter 5 to Delete a Book...");
		System.out.println("Enter 6 to Get all Id's of Book...");
		System.out.println("Enter 7 to Get all the Books Information present in the Library...");
		System.out.println("Enter 8 to Sort the Books...");
		System.out.println("Enter your Choice ....");
		int choice = scan.nextInt();
		BookDao dao = BookManager.getBookDao();
		BookDto dto = null;
		switch (choice) 
		{
		case 1: 
		{
			dto = new BookDto();
			System.out.println("Enter Book Id...");
			dto.setBookId(scan.nextInt());
			System.out.println("Enter Book Title...");
			scan.nextLine();
			dto.setBookName(scan.nextLine());
			System.out.println("Enter Book Author name...");
			dto.setAuthorName(scan.nextLine());
			System.out.println("Enter Book Pages...");
			dto.setPages(scan.nextInt());
			System.out.println("Enter Book Price...");
			dto.setPrice(scan.nextDouble());
			dao.addBook(dto);
			break;
		}
		case 2: 
		{
			System.out.println("Enter Book Title : ");
			scan.nextLine();
			String title = scan.nextLine();
			ArrayList<BookDto> bookDetails = dao.searchBookTitle(title);
			Iterator<BookDto> details = bookDetails.iterator();
			while (details.hasNext()) 
			{
				dto = (BookDto) details.next();
				System.out.println("****************************");
				System.out.println("BookId : " + dto.getBookId());
				System.out.println("Book Name : " + dto.getBookName());
				System.out.println("Book Pages : " + dto.getPages());
				System.out.println("Book Price : " + dto.getPrice());
				System.out.println("Author Name : " + dto.getAuthorName());
				System.out.println("****************************");
			}
			break;
		}
		case 3: 
		{
			System.out.println("Enter Book Author Name : ");
			scan.nextLine();
			ArrayList<BookDto> bookDetails = dao.searchBookAuthor(scan.nextLine());
			Iterator<BookDto> details = bookDetails.iterator();
			while (details.hasNext()) 
			{
				dto = (BookDto) details.next();
				System.out.println("****************************");
				System.out.println("BookId : " + dto.getBookId());
				System.out.println("Book Name : " + dto.getBookName());
				System.out.println("Book Pages : " + dto.getPages());
				System.out.println("Book Price : " + dto.getPrice());
				System.out.println("Author Name : " + dto.getAuthorName());
				System.out.println("****************************");
			}
			break;
		}
		case 4: 
		{
			System.out.println("Enter Book Id : ");
			int id = scan.nextInt();
			System.out.println("Enter Book Price : ");
			double price = scan.nextDouble();
			dao.updateBookPrice(id, price);
			break;
		}
		case 5: 
		{
			System.out.println("Enter Book Id : ");
			boolean status = dao.removeBook(scan.nextInt());
			if (status) 
			{
				System.out.println("Book Deleted successfully...");
			}
			break;
		}
		case 6: 
		{
			ArrayList<Integer> bookDetails = dao.getIds();
			Iterator<Integer> details = bookDetails.iterator();
			while (details.hasNext()) 
			{
				int id = (Integer) details.next();
				System.out.println("BookId : " + id);
				System.out.println("****************************");
			}
			break;
		}
		case 7: 
		{
			ArrayList<BookDto> bookDetails = dao.getAllBooks();
			Iterator<BookDto> details = bookDetails.iterator();
			while (details.hasNext()) 
			{
				dto = (BookDto) details.next();
				System.out.println("****************************");
				System.out.println("BookId : " + dto.getBookId());
				System.out.println("Book Name : " + dto.getBookName());
				System.out.println("Book Pages : " + dto.getPages());
				System.out.println("Book Price : " + dto.getPrice());
				System.out.println("Author Name : " + dto.getAuthorName());
				System.out.println("****************************");
			}
			break;
		}
		case 8: 
		{
			System.out.println("Sort Book By your Choice...");
			System.out.println("1. By using Book Id");
			System.out.println("2. By using Book Title");
			System.out.println("3. By using Author Name");
			System.out.println("4. By using Price");
			System.out.println("Enter your choice : ");
			ArrayList<BookDto> bookDetails = dao.sortBooks(scan.nextInt());
			if (bookDetails != null) 
			{
				Iterator<BookDto> details = bookDetails.iterator();
				while (details.hasNext()) 
				{
					dto = (BookDto) details.next();
					System.out.println("****************************");
					System.out.println("BookId : " + dto.getBookId());
					System.out.println("Book Name : " + dto.getBookName());
					System.out.println("Book Pages : " + dto.getPages());
					System.out.println("Book Price : " + dto.getPrice());
					System.out.println("Author Name : " + dto.getAuthorName());
					System.out.println("****************************");
				}
			}
			break;
		}
		default:
			System.err.println("Sorry Invalid Choice.");
			break;
		}
	}
	public void continueOrStop() 
	{
		System.out.println("************ Welcome to Library ***************");
		String status = "no";
		do 
		{
			try 
			{
				performOperation();
				System.out.println();
				System.out.println("Enter (Yes / Y) to Continue... ");
				System.out.println("Enter ( No / N ) to Stop...");
				status = scan.next();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				System.out.println();
				System.out.println("Enter (Yes / Y) to Continue... ");
				System.out.println("Enter ( No / N ) to Stop...");
				status = scan.next();
			}
		} 
		while (status.equalsIgnoreCase("Yes") || status.equalsIgnoreCase("Y"));
		System.out.println("*********** Thankyou, Vist again ************");
		System.out.println("**************** By Litish ******************");
	}

	@Override
	public void run() 
	{
		continueOrStop();
	}
}
