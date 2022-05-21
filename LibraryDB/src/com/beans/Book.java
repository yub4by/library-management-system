package com.beans;

public class Book {
	
	private int bookId;
	private String bookName;
	private String bookAuther;
	private String loca;//分类
	private String status;//状态（借出/可借/维护）
	private int borrowerId;//借阅者ID
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuther() {
		return bookAuther;
	}
	public void setBookAuther(String bookAuther) {
		this.bookAuther = bookAuther;
	}
	public String getLoca() {
		return loca;
	}
	public void setLoca(String loca) {
		this.loca = loca;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getBorrowerId() {
		return borrowerId;
	}
	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookAuther=" + bookAuther + ", loca=" + loca + ", status="
				+ status + ", borrowerId=" + borrowerId + "]";
	}
	
}
