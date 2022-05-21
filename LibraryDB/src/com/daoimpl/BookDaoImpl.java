package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.beans.User;
import com.dao.BookDao;
import com.test.Login;
import com.util.DBUtil_Library;

public class BookDaoImpl implements BookDao {
	
	//�����ʾͼ����Ϣ�����飬���飬ȫ����
	@Override
	public List<Book> getListBook(int a) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Book book=null;
		List<Book> list=new ArrayList<Book>();
		try{
			conn=DBUtil_Library.getConnection();
			String sql="";
			if(a==1){
				sql="select * from books where status='�ɽ�' ";
			}else if(a==2){
				sql="select * from books where status='���' ";
			}else{
				sql="select * from books";
			}
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuther(rs.getString("bookAuther"));
				book.setLoca(rs.getString("loca"));
				book.setStatus(rs.getString("status"));
				list.add(book);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return list;
	}
	
	//���ͼ��
	@Override
	public int addBook(Book book) {
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="insert into books(bookName,bookAuther,loca,status) values(?,?,?,?) ";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, book.getBookName());
			pstm.setString(2, book.getBookAuther());
			pstm.setString(3, book.getLoca());
			pstm.setString(4, book.getStatus());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//����Աɾ��ͼ���¼
	@Override
	public int deleteBook(Book book) {
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="delete from books where bookName=? and bookAuther=? and loca=? ";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, book.getBookName());
			pstm.setString(2, book.getBookAuther());
			pstm.setString(3, book.getLoca());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//���߽��黹���޸�books��ͼ����Ϣ
	@Override
	public int borrowBook(int b,Book book,User user) {
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="";
			if(b==1){
				sql="update books set status='���' , borrowerId=?  where status='�ɽ�' and bookId=? ";
			}
			else{
				sql="update books set status='�ɽ�' , borrowerId=?  where status='���' and bookId=? ";
			}
			pstm=conn.prepareStatement(sql);
			if(b==1){
				pstm.setString(1,user.getUserId());
				pstm.setInt(2, book.getBookId());
			}else{
				pstm.setString(1,"");
				pstm.setInt(2, book.getBookId());
			}
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//�û�ģ����ѯͼ��
	@Override
	public List<Book> queryListBook(String bookName,String bookAuther,String loca) {
		// TODO �Զ����ɵķ������
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Book book=null;
		List<Book> list=new ArrayList<Book>();
		try{  
			conn=DBUtil_Library.getConnection();
			String sql="select * from books where 1=1 ";
			if(bookName!=null || "".equals(bookName)){
				sql+=" and bookName like '%"+bookName+"%' ";
			}
			if(bookAuther!=null || "".equals(bookAuther)){
				sql+=" and bookAuther like '%"+bookAuther+"%' ";
			}
			if(loca!=null || "".equals(loca)){
				sql+=" and loca like '%"+loca+"%' ";
			}
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuther(rs.getString("bookAuther"));
				book.setLoca(rs.getString("loca"));
				book.setStatus(rs.getString("status"));
				list.add(book);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return list;
	}

	//����Ա�޸�ͼ����Ϣ
	@Override
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		int result=0;
		
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="update books set bookName=?,bookAuther=?,loca=?,status=? where bookId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,book.getBookName());
			pstm.setString(2,book.getBookAuther());
			pstm.setString(3, book.getLoca());
			pstm.setString(4,book.getStatus());
			pstm.setInt(5,book.getBookId());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm,null);
		}
		return result;
	}

	//��bookID��ȡһ��book����
	@Override
	public Book getBookById(int bookId) {
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		Book book=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="select * from books where bookId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1,bookId);
			rs=pstm.executeQuery();
			while(rs.next()){
				book=new Book();
				book.setBookId(rs.getInt("bookId"));
				book.setBookName(rs.getString("bookName"));
				book.setBookAuther(rs.getString("bookAuther"));
				book.setLoca(rs.getString("loca"));
				book.setStatus(rs.getString("status"));
				book.setBorrowerId(rs.getInt("borrowerId"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return book;
	}
	
	//��ѡɾ��ͼ��ģʽ������ԭ���޷�ȷ�����н����ά�����鼮��
	@Override
	public int delBook(String strId) {
		// TODO Auto-generated method stub
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="delete from books where bookId in ("+strId+") ";
			pstm=conn.prepareStatement(sql);
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

}
