package com.test;

import java.util.Date;

import com.beans.Book;

public class Test extends Book{
	private int id;
	private Date lendTime;
	private Date returnTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getLendTime() {
		return lendTime;
	}
	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", lendTime=" + lendTime + ", returnTime="
				+ returnTime + "]";
	}
	
}
