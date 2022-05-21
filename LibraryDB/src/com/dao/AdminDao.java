package com.dao;

import java.util.List;

import com.beans.Book;
import com.beans.Borrow;
import com.beans.User;

public interface AdminDao {
	
	public List userBorrowBook();
	public int insertBorrow(User user,Book book);
	public int deleteBorrow(User user);
	public Borrow getBorrowByUserBook(User user, Book book);
	public int insertTest(User user,Book book);
	
}
