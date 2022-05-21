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
import com.beans.User;
import com.daoimpl.ReaderDaoImpl;

public class UserAdd extends JFrame{
	private User user;
	private ReaderDaoImpl daoImpl=new ReaderDaoImpl();
	
	public UserAdd(){
		setSize(300,300);
		setTitle("添加用户");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//有无都可以
		setLayout(null);
		
		JLabel jl1=new JLabel("用户名：");
		jl1.setBounds(20, 30, 60, 30);
		add(jl1);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 30, 150, 30);
		add(jt1);
		
		JLabel jl2=new JLabel("密    码：");
		jl2.setBounds(20, 70, 60, 30);
		add(jl2);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 70, 150, 30);
		add(jt2);
		
		ButtonGroup btnGroup=new ButtonGroup();
		final JRadioButton radio1=new JRadioButton("读者");
		radio1.setBounds(50, 130, 70, 20);
		final JRadioButton radio3=new JRadioButton("管理员");
		radio3.setBounds(180, 130, 70, 20);
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
				user=new User();
				String userName=jt1.getText();
				String password=jt2.getText();
				String role="";
				if(radio1.isSelected()){
					role=radio1.getText();
				}
				if(radio3.isSelected()){
					role=radio3.getText();
				}
				if( (userName==null||"".equals(userName))||(password==null||"".equals(password))||(role==null||"".equals(role))){
					JOptionPane.showMessageDialog(null, "信息填写不完整！");
				}else{
					user.setUserName(userName);
					user.setPassword(password);
					user.setRole(role);
					
					int result=daoImpl.addUser(user);//添加用户
					if(result>0){
						JOptionPane.showMessageDialog(null, "添加成功！");
						JTable jt=UserManagerPanel.getTable();
						UserManagerPanel.getUserData(jt);
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
