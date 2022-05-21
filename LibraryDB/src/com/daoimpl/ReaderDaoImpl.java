package com.daoimpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.beans.Book;
import com.beans.User;
import com.dao.ReaderDao;
import com.util.DBUtil_Library;

public class ReaderDaoImpl implements ReaderDao {
	
	//��½
	@Override
	public User Login(String userName, String password) {
		User user=null;
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="select * from users where userName=? and password=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, userName);
			pstm.setString(2, password);
			rs=pstm.executeQuery();
				if(rs.next()){
					user=new User();
					user.setUserId(rs.getString("userId"));
					user.setUserName(rs.getString("userName"));
					user.setPassword(rs.getString("password"));
					user.setNote(rs.getInt("note"));
					user.setRole(rs.getString("role"));
					System.out.println(user);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return user;
	}
	
	//��ʾ�û���Ϣ��������û���ȫ����
	@Override
	public List<User> getListUser(int a) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		User user=null;
		List<User> list=new ArrayList<User>();
		try{
			conn=DBUtil_Library.getConnection();
			String sql="";
			if(a==1){
				sql="select * from users where note!='' ";
			}else{
				sql="select * from users";
			}
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setNote(rs.getInt("note"));
				user.setRole(rs.getString("role"));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return list;
	}
	
	//����û�
	@Override
	public int  addUser(User user) {
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="insert into users(userName,password,role) values(?,?,?) ";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getRole());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//ɾ���û�
	@Override
	public int deleteUser(User user) {
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="delete from users where userName=? and password=? and role=? ";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, user.getUserName());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getRole());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

	//�޸��û�
	@Override
	public int  updateUser(User user) {
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="update users set userName=?,password=?,role=? where userId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,user.getUserName());
			pstm.setString(2,user.getPassword());
			pstm.setString(3, user.getRole());
			pstm.setString(4,user.getUserId());
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm,null);
		}
		return result;
	}

	//ģ����ѯ�û���Ϣ
	@Override
	public List<User> queryListUser(String userName,String password,String role) {
		// TODO �Զ����ɵķ������
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		User user=null;
		List<User> list=new ArrayList<User>();
		try{  
			conn=DBUtil_Library.getConnection();
			String sql="select * from users where 1=1 ";
			if(userName!=null || "".equals(userName)){
				sql+=" and userName like '%"+userName+"%' ";
			}
			if(password!=null || "".equals(password)){
				sql+=" and password like '%"+password+"%' ";
			}
			if(role!=null || "".equals(role)){
				sql+=" and role like '%"+role+"%' ";
			}
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setNote(rs.getInt("note"));
				user.setRole(rs.getString("role"));
				list.add(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return list;
	}

	//��userID��ȡһ��user����
	@Override
	public User getUserById(String userId) {
		// TODO �Զ����ɵķ������
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		User user=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="select * from users where userId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1,userId);
			rs=pstm.executeQuery();
			while(rs.next()){
				user=new User();
				user.setUserId(rs.getString("userId"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setNote(rs.getInt("note"));
				user.setRole(rs.getString("role"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return user;
	}

	//����ɹ��ͻ���ɹ����޸�users���������Ϣ
	@Override
	public int updateBorrower(int a,Book book,User user){
		// TODO �Զ����ɵķ������
		int result=0;
		Connection conn=null;
		PreparedStatement pstm=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="";
			if(a==0){
				sql="update users set note=0 where userId=? ";
			}else{
				sql="update users set note=? where userId=? ";
			}
			pstm=conn.prepareStatement(sql);
			if(a==0){
				pstm.setString(1,user.getUserId());
			}else{
				pstm.setInt(1,book.getBookId());
				pstm.setString(2,user.getUserId());
			}
			result=pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, null);
		}
		return result;
	}

}
