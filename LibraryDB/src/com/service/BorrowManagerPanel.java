package com.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.beans.Borrow;
import com.beans.User;
import com.daoimpl.AdminDaoImpl;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.ReaderDaoImpl;
import com.util.AdminSwingUtil;

public class BorrowManagerPanel extends JPanel {
	private static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	public int a=0;
	
	private JButton borrowedBookBtn;
	private JButton borrowedReaderBtn;
	
	public BorrowManagerPanel(int a){
		this.setLayout(null);
		this.a=a;
		
		//设置带滚动条的面板
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getUserData(jt);
		jsp.setViewportView(jt);
		
		borrowedBookBtn=new JButton("借过书的人");
		borrowedBookBtn.setBackground(new Color(238,238,238));
		borrowedBookBtn.setBounds(10, 50, 100, 50);
		borrowedBookBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowManagerPanel(2),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		borrowedReaderBtn=new JButton("被借出的书");
		borrowedReaderBtn.setBackground(new Color(238,238,238));
		borrowedReaderBtn.setBounds(10, 150, 100, 50);
		borrowedReaderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowManagerPanel(3),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		add(borrowedBookBtn);
		add(borrowedReaderBtn);
	}
	
	public DefaultTableModel creatDefaultModel(){
		String [] trow={};
		if(a==2){
			trow=new String[5];
			//创建借书用户表格模型
			trow[0]="用户编号";
			trow[1]="登录名称";
			trow[2]="登录密码";
			trow[3]="备注信息";
			trow[4]="角色状态";
		}else if(a==3){
			trow=new String[5];
			//创建被借的书表格模型
			trow[0]="图书编号";
			trow[1]="图书名称";
			trow[2]="图书作者";
			trow[3]="图书类别";
			trow[4]="图书状态";
		}else{
			trow=new String[6];
			//创建书和人表格模型
			trow[0]="用户编号";
			trow[1]="登录名称";
			trow[2]="借阅日期";
			trow[3]="图书编号";
			trow[4]="图书名称";
			trow[5]="归还日期";
		}
		DefaultTableModel dt=new DefaultTableModel(trow,0);
		return dt;
	}
	public void getUserData(JTable jt) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=creatDefaultModel();
		if(a==2){
			//获得借书用户数据
			List<User> userList=new ReaderDaoImpl().getListUser(1);
			for(User user:userList){
				String [] data=new String[5];
				data[0]=user.getUserId()+"";
				data[1]=user.getUserName();
				data[2]=user.getPassword();
				data[3]=user.getNote()+"";
				data[4]=user.getRole();
				dtm.addRow(data);
			}
		}else if(a==3){
			//获得被借图书数据
			List<Book> bookList=new BookDaoImpl().getListBook(2);
			for(Book book:bookList){
				String [] data=new String[5];
				data[0]=book.getBookId()+"";
				data[1]=book.getBookName();
				data[2]=book.getBookAuther();
				data[3]=book.getLoca();
				data[4]=book.getStatus();
				dtm.addRow(data);
			}
		}else{
			//获得书和人数据
			List<Borrow> bookAndReaderList=new AdminDaoImpl().userBorrowBook();
			for(Borrow borrow:bookAndReaderList){
				String [] data=new String[6];
				data[0]=borrow.getUserId();
				data[1]=borrow.getUserName();
				data[2]=borrow.getLendTime()+"";
				data[3]=borrow.getBookId();
				data[4]=borrow.getBookName();
				data[5]=borrow.getReplaceTime()+"";
				dtm.addRow(data);
			}
		}
		jt.setModel(dtm);
	}

}
