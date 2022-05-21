package com.daoimpl;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.beans.Book;
import com.beans.Borrow;
import com.beans.User;
import com.dao.AdminDao;
import com.util.DBUtil_Library;

public class AdminDaoImpl implements AdminDao {
	
	//管理员借阅管理初始界面表格数据来源
	@Override
	public List userBorrowBook() {
		// TODO 自动生成的方法存根
		Borrow borrow=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List list=new ArrayList();
		try{
			conn=DBUtil_Library.getConnection();
			String sql="select * from borrow  ";
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				borrow=new Borrow();
				borrow.setUserId(rs.getString("userId"));
				borrow.setUserName(rs.getString("userName"));
				borrow.setBookId(rs.getString("bookId"));
				borrow.setBookName(rs.getString("bookName"));
				borrow.setLendTime(rs.getDate("lendTime"));
				borrow.setReplaceTime(rs.getDate("replaceTime"));
				list.add(borrow);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return list;
	}
	
	//用户借书成功时向borrow表中插入借书记录
	@Override
	public int insertBorrow(User user,Book book){
		// TODO 自动生成的方法存根
		int result=0;
		Borrow borrow=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="insert into borrow (userId,userName,bookId,bookName,lendTime,replaceTime) values(?,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,user.getUserId());
			pstm.setString(2,user.getUserName());
			pstm.setInt(3,book.getBookId());
			pstm.setString(4,book.getBookName());
			pstm.setDate(5,new java.sql.Date(new Date().getTime()));
			Calendar cc=Calendar.getInstance();
			cc.add(Calendar.DAY_OF_MONTH, 10);
			pstm.setDate(6,new java.sql.Date(cc.getTime().getTime()));
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//用户还书成功后删除该用户此次借书记录
	@Override
	public int deleteBorrow(User user) {
		// TODO 自动生成的方法存根
		int result=0;
		Borrow borrow=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="delete from borrow where userId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,user.getUserId());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//根据用户ID和图书ID获取borrow表中数据
	@Override
	public Borrow getBorrowByUserBook(User user, Book book) {
		// TODO Auto-generated method stub
		Borrow borrow=null;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="select * from borrow where userId=? and bookId=? ";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,user.getUserId());
			pstm.setInt(2, book.getBookId());
			rs=pstm.executeQuery();
			if(rs.next()){
				borrow=new Borrow();
				borrow.setUserId(rs.getString("userId"));
				borrow.setUserName(rs.getString("userName"));
				borrow.setBookId(rs.getString("bookId"));
				borrow.setBookName(rs.getString("bookName"));
				borrow.setLendTime(rs.getDate("lendTime"));
				borrow.setReplaceTime(rs.getDate("replaceTime"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return borrow;
	}
	
	//用户借书成功时向test表中插入借书记录
	@Override
	public int insertTest(User user, Book book) {
		// TODO 自动生成的方法存根
		int result=0;
		Borrow borrow=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="insert into test (userId,bookId,lendTime,returnTime) values(?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,user.getUserId());
			pstm.setInt(2,book.getBookId());
			pstm.setDate(3,new java.sql.Date(new Date().getTime()));
			Calendar cc=Calendar.getInstance();
			cc.add(Calendar.DAY_OF_MONTH, 10);
			pstm.setDate(4,new java.sql.Date(cc.getTime().getTime()));
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

}
