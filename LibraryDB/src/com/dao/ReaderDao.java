package com.dao;

import java.util.List;

import com.beans.Book;
import com.beans.User;

public interface ReaderDao {
	
	public User Login(String userName,String password);
	public List<User> getListUser(int a);
	public int addUser(User user);
	public int deleteUser(User user);
	public int updateUser(User user);
	public List<User> queryListUser(String userName,String password,String role);
	public User getUserById(String userId);
	public int updateBorrower(int a,Book book,User user);
	
}
