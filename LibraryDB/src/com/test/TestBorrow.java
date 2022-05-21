package com.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beans.User;
import com.util.DBUtil_Library;

public class TestBorrow extends JFrame{
	public static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	public JTextField jtf;
	
	public TestBorrow(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,120);
		setTitle("Tset--用户借阅历史");
		setLocation(100,100);
		this.setLayout(null);
		
		JLabel jl=new JLabel("要查询的用户的ID:");
		jl.setBounds(20, 20,150, 30);
		add(jl);
		jtf=new JTextField();
		jtf.setBounds(140, 20, 100, 30);
		add(jtf);
		JButton btnQuery=new JButton("确定");
		btnQuery.setBounds(250, 20, 60, 30);
		add(btnQuery);
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setSize(500,430);
				JScrollPane jsp=new JScrollPane();
				jsp.setBounds(50, 100, 400, 250);
				add(jsp);
				jt=new JTable();
				jt.setEnabled(false);
				jt.setRowHeight(60);
				getTestData(jt);
				jsp.setViewportView(jt);
				
				getBorrowBookList(jtf.getText());
			}
		});
		JButton btnPrint=new JButton("统计数据");
		btnPrint.setBounds(345, 20, 100, 30);
		add(btnPrint);
		btnPrint.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<Test> list=getBorrowBookList(jtf.getText());
				BufferedWriter bw=null;
				try{
					bw=new BufferedWriter(new FileWriter("统计借阅数据.txt"));
					for(Test book:list){
						String str="借阅书籍名称："+book.getBookName()+",借阅时间："+book.getLendTime()+",应还时间："+book.getReturnTime();
						bw.write(str);
						bw.newLine();
						bw.flush();
					}
				}catch(Exception e1){
					e1.printStackTrace();
				}finally{
					try {
						bw.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "统计成功,请查看 “统计借阅数据.txt”");
			}
		});
		
		setVisible(true);
	}
	
	public  List<Test> getBorrowBookList(String userId) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Test> list=new ArrayList<Test>();
		Test book=null;
		try{
			conn=DBUtil_Library.getConnection();
			String sql="select books.bookName,test.lendTime,test.returnTime from books join test on test.bookId=books.bookId where userId=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, userId);
			rs=pstm.executeQuery();
			while(rs.next()){
				book=new Test();
				book.setBookName(rs.getString("bookName"));
				book.setLendTime(rs.getDate("lendTime"));
				book.setReturnTime(rs.getDate("returnTime"));
				list.add(book);
			}
		}catch(Exception e3){
			e3.printStackTrace();
		}finally{
			DBUtil_Library.close(conn, pstm, rs);
		}
		return list;
	}
	
	public static DefaultTableModel creatDefaultModel(){
		String [] trow=new String[3];
		trow[0]="图书名称";
		trow[1]="借阅时间";
		trow[2]="应还时间";
		DefaultTableModel dt=new DefaultTableModel(trow,0);
		return dt;
	}
	
	private void getTestData(JTable jt) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=creatDefaultModel();
		List<Test> bookList=getBorrowBookList(jtf.getText());
		for(Test book:bookList){
			String [] data=new String[3];
			data[0]=book.getBookName();
			data[1]=new SimpleDateFormat("yyyy-MM-dd").format(book.getLendTime());
			data[2]=new SimpleDateFormat("yyyy-MM-dd").format(book.getReturnTime());
			dtm.addRow(data);
		}
		jt.setModel(dtm);
	}
	
	public static void main(String[] args) {
		new TestBorrow();
	}

}
