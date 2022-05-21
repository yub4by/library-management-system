package com.beans;

import java.util.Date;

public class Borrow {
	
	private int ID;
	private String userId;
	private String userName;
	private String bookId;
	private String bookName;
	private Date lendTime;
	private Date replaceTime;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Date getLendTime() {
		return lendTime;
	}
	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}
	public Date getReplaceTime() {
		return replaceTime;
	}
	public void setReplaceTime(Date replaceTime) {
		this.replaceTime = replaceTime;
	}
	@Override
	public String toString() {
		return "Borrow [ID=" + ID + ", userId=" + userId + ", userName="
				+ userName + ", bookId=" + bookId + ", bookName=" + bookName
				+ ", lendTime=" + lendTime + ", replaceTime=" + replaceTime
				+ "]";
	}
	
}
