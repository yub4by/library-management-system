package com.util;

import java.sql.*;

public class DBUtil_Library {
	//��Ϊ˽�У���ֹ��������������ʵ��
		private DBUtil_Library(){}
		
		private static String driver="com.mysql.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/library";
		private static String user="root";
		private static String password="root";
		
		//����������ִֻ��һ�Σ�
		static{
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//��������
		public static Connection getConnection(){
			Connection conn=null;
			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		
		//�ر�����
		public static void close(Connection conn,Statement stm,ResultSet rs){
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stm!=null){
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
}
