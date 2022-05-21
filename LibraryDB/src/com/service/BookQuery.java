package com.service;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.daoimpl.BookDaoImpl;

public class BookQuery extends JFrame{
	public static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	static int a=0;//判断是否是手动查询
	
	static JTextField jt1;
	static JTextField jt2;
	static JTextField jt3;
	
	public BookQuery(){
		setSize(700,310);
		setTitle("查询图书");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//有无都可以
		setLayout(null);
		
		//设置带滚动条的面板
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(280, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getBookData(jt);
		jsp.setViewportView(jt);

		JLabel jl1=new JLabel("书名：");
		jl1.setBounds(30, 30, 50, 30);
		add(jl1);
		jt1=new JTextField();
		jt1.setBounds(100, 30, 150, 30);
		add(jt1);
		
		JLabel jl2=new JLabel("作者：");
		jl2.setBounds(30, 70, 50, 30);
		add(jl2);
		jt2=new JTextField();
		jt2.setBounds(100, 70, 150, 30);
		add(jt2);
		
		JLabel jl3=new JLabel("类别：");
		jl3.setBounds(30, 110, 50, 30);
		add(jl3);
		jt3=new JTextField();
		jt3.setBounds(100, 110, 150, 30);
		add(jt3);
		
		JButton submitBtn=new JButton("确定");
		submitBtn.setBackground(new Color(238,238,238));
		submitBtn.setBounds(30, 180, 80, 50);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a=1;//手动查询的依据
				getBookData(jt);
				a=0;
			}
		});
		add(submitBtn);
		
		JButton cancleBtn=new JButton("取消");
		cancleBtn.setBackground(new Color(238,238,238));
		cancleBtn.setBounds(170, 180, 80, 50);
		cancleBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		add(cancleBtn);
		
		setVisible(true);
	}
	
		//创建表格模型
		public static DefaultTableModel creatDefaultModel(){
			String [] trow=new String[5];
			trow[0]="图书编号";
			trow[1]="图书名称";
			trow[2]="图书作者";
			trow[3]="图书类别";
			trow[4]="图书状态";
			DefaultTableModel dt=new DefaultTableModel(trow,0);
			return dt;
		}
		
		//获得图书数据
		public static void getBookData(JTable jt) {
			// TODO Auto-generated method stub
			DefaultTableModel dtm=creatDefaultModel();
			List<Book> bookList=null;
			if(a==1){
				 String bookName=jt1.getText();
				 String bookAuther=jt2.getText();
				 String loca=jt3.getText();
				bookList=new BookDaoImpl().queryListBook(bookName,bookAuther,loca);//用户模糊查询图书
			}else{
				bookList=new BookDaoImpl().getListBook(0);//面板显示全部图书信息
			}
			for(Book book:bookList){
				String [] data=new String[5];
				data[0]=book.getBookId()+"";
				data[1]=book.getBookName();
				data[2]=book.getBookAuther();
				data[3]=book.getLoca();
				data[4]=book.getStatus();
				dtm.addRow(data);
			}
			jt.setModel(dtm);
		}
	
}
