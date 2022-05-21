package com.service;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.beans.User;
import com.daoimpl.ReaderDaoImpl;

public class UserDelete extends JFrame{
	private User user;
	private ReaderDaoImpl daoImpl=new ReaderDaoImpl();
	
	public UserDelete(String userId){
		user=daoImpl.getUserById(userId);
		
		setSize(300,300);
		setTitle("删除用户");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//有无都可以
		setLayout(null);
		
		JLabel jl=new JLabel("要删除的用户信息如下");
		jl.setBounds(40, 10, 220, 30);
		jl.setFont(new Font("宋体",Font.BOLD,20));
		add(jl);
		JLabel jl1=new JLabel("用户名：");
		jl1.setBounds(30, 50, 70, 30);
		add(jl1);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 50, 150, 30);
		jt1.setEditable(false);
		jt1.setText(user.getUserName());
		add(jt1);
		
		JLabel jl2=new JLabel("密     码：");
		jl2.setBounds(30, 90, 70, 30);
		add(jl2);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 90, 150, 30);
		jt2.setEditable(false);
		jt2.setText(user.getPassword());
		add(jt2);
		
		JLabel jl3=new JLabel("角     色：");
		jl3.setBounds(30, 130, 70, 30);
		add(jl3);
		final JTextField jt3=new JTextField();
		jt3.setBounds(100, 130, 150, 30);
		jt3.setEditable(false);
		jt3.setText(user.getRole());
		add(jt3);
		
		JButton submitBtn=new JButton("确定");
		submitBtn.setBackground(new Color(238,238,238));
		submitBtn.setBounds(30, 180, 80, 50);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					user.setUserName(jt1.getText());
					user.setPassword(jt2.getText());
					user.setRole(jt3.getText());
					
						int result=daoImpl.deleteUser(user);//删除用户
						if(result>0){
							JOptionPane.showMessageDialog(null, "删除成功！");
							JTable jt=UserManagerPanel.getTable();
							UserManagerPanel.getUserData(jt);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "删除失败！");
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
