package com.service;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.beans.Book;
import com.daoimpl.BookDaoImpl;

public class BookAdd extends JFrame {
	private Book book;
	private BookDaoImpl daoImpl=new BookDaoImpl();
	
	public BookAdd(){
		setSize(300,300);
		setTitle("添加图书");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//有无都可以
		setLayout(null);
		
		JLabel jl1=new JLabel("书名：");
		jl1.setBounds(30, 30, 50, 30);
		add(jl1);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 30, 150, 30);
		add(jt1);
		
		JLabel jl2=new JLabel("作者：");
		jl2.setBounds(30, 70, 50, 30);
		add(jl2);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 70, 150, 30);
		add(jt2);
		
		JLabel jl3=new JLabel("类别：");
		jl3.setBounds(30, 110, 50, 30);
		add(jl3);
		final JTextField jt3=new JTextField();
		jt3.setBounds(100, 110, 150, 30);
		add(jt3);
		
		ButtonGroup btnGroup=new ButtonGroup();
		final JRadioButton radio1=new JRadioButton("可借");
		radio1.setBounds(50, 150, 70, 20);
		final JRadioButton radio3=new JRadioButton("维护");
		radio3.setBounds(180, 150, 70, 20);
		btnGroup.add(radio1);
		btnGroup.add(radio3);
		add(radio1);
		add(radio3);
		
		JButton submitBtn=new JButton("确定");
		submitBtn.setBackground(new Color(238,238,238));
		submitBtn.setBounds(30, 180, 80, 50);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				book=new Book();
				String bookName=jt1.getText();
				String bookAuther=jt2.getText();
				String loca=jt3.getText();
				if( (bookName==null||"".equals(bookName))||(bookAuther==null||"".equals(bookAuther))||(loca==null||"".equals(loca))){
					JOptionPane.showMessageDialog(null, "信息填写不完整！");
				}else{
					book.setBookName(bookName);
					book.setBookAuther(bookAuther);
					book.setLoca(loca);
					String status="";
					if(radio1.isSelected()){
						status=radio1.getText();
					}else if(radio3.isSelected()){
						status=radio3.getText();
					}else{
						status="可借";
					}
					book.setStatus(status);
					int result=daoImpl.addBook(book);//添加图书
					if(result>0){
						JOptionPane.showMessageDialog(null, "添加成功！");
						JTable jt=BookManagerPanel.getTable();
						BookManagerPanel.getBookData(jt);//可以去掉.getInstence()（因为getBookData(jt)是静态的）
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "添加失败！");
					}
				}
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
	
}
