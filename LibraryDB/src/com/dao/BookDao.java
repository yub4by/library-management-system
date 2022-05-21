package com.dao;

import java.util.List;

import com.beans.Book;
import com.beans.User;

public interface BookDao {
	
	public List<Book> getListBook(int a);
	public int addBook(Book book);
	public int deleteBook(Book book);
	public int delBook(String strId);
	public int updateBook(Book book);
	public int borrowBook(int b,Book book,User user);
	public Book getBookById(int bookId);
	public List<Book> queryListBook(String bookName,String bookAuther,String loca);
	
}
