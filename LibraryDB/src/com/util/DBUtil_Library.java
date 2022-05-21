package com.util;

import java.sql.*;

public class DBUtil_Library {
	//设为私有，防止被其他创建本类实例
		private DBUtil_Library(){}
		
		private static String driver="com.mysql.jdbc.Driver";
		private static String url="jdbc:mysql://localhost:3306/library";
		private static String user="root";
		private static String password="root";
		
		//加载驱动（只执行一次）
		static{
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//创建连接
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
		
		//关闭连接
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
