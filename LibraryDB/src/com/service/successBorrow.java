package com.service;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.beans.Book;
import com.beans.Borrow;
import com.beans.User;
import com.daoimpl.AdminDaoImpl;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.ReaderDaoImpl;

public class successBorrow extends JFrame{
	
	public successBorrow(Borrow borrow){
		setSize(300,400);
		setTitle("借阅信息");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//有无都可以
		setLayout(null);
		
		JLabel jl1=new JLabel("用户ID：");
		jl1.setBounds(30, 30, 50, 30);
		add(jl1);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 30, 150, 30);
		jt1.setEditable(false);
		jt1.setText(borrow.getUserId());
		add(jt1);
		
		JLabel jl2=new JLabel("用户名：");
		jl2.setBounds(30, 70, 70, 30);
		add(jl2);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 70, 150, 30);
		jt2.setEditable(false);
		jt2.setText(borrow.getUserName());
		add(jt2);
		
		JLabel jl3=new JLabel("图书ID：");
		jl3.setBounds(30, 110, 70, 30);
		add(jl3);
		final JTextField jt3=new JTextField();
		jt3.setBounds(100, 110, 150, 30);
		jt3.setEditable(false);
		jt3.setText(borrow.getBookId());
		add(jt3);
		
		JLabel jl4=new JLabel("图书名：");
		jl4.setBounds(30, 150, 70, 30);
		add(jl4);
		final JTextField jt4=new JTextField();
		jt4.setBounds(100, 150, 150, 30);
		jt4.setEditable(false);
		jt4.setText(borrow.getBookName());
		add(jt4);
		
		JLabel jl5=new JLabel("借阅时间：");
		jl5.setBounds(30, 190, 70, 30);
		add(jl5);
		final JTextField jt5=new JTextField();
		jt5.setBounds(100, 190, 150, 30);
		jt5.setEditable(false);
		String lendTime=new SimpleDateFormat("yyyy-MM-dd").format(borrow.getLendTime());
		jt5.setText(lendTime);
		add(jt5);
		
		JLabel jl6=new JLabel("归还时间：");
		jl6.setBounds(30, 230, 70, 30);
		add(jl6);
		final JTextField jt6=new JTextField();
		jt6.setBounds(100, 230, 150, 30);
		jt6.setEditable(false);
		String replaceTime=new SimpleDateFormat("yyyy-MM-dd").format(borrow.getReplaceTime());
		jt6.setText(replaceTime);
		add(jt6);
		
		JButton submitBtn=new JButton("确定");
		submitBtn.setBackground(new Color(238,238,238));
		submitBtn.setBounds(110, 300, 80, 50);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		add(submitBtn);
		
		setVisible(true);
	}
	
}
