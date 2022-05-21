package com.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.util.AdminSwingUtil;

public class TopPanelAdmin extends JPanel {
	private JButton btnBookManager;
	private JButton btnUserManager;
	private JButton btnBorrowManager;
	
	public TopPanelAdmin(){
		this.setLayout(null);
		
		btnBookManager=new JButton("图书管理");
		btnBookManager.setBounds(0, 0, 187,100);
		btnBookManager.setBackground(new Color(238,238,238));
		btnBookManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BookManagerPanel(),BorderLayout.CENTER );//BookManagerPanel.getInstence()
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		
		btnUserManager=new JButton("用户管理");
		btnUserManager.setBounds(187, 0, 187, 100);
		btnUserManager.setBackground(new Color(238,238,238));
		btnUserManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new UserManagerPanel(),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		
		btnBorrowManager=new JButton("借阅管理");
		btnBorrowManager.setBounds(374, 0,187, 100);
		btnBorrowManager.setBackground(new Color(238,238,238));
		btnBorrowManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowManagerPanel(1),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		
		add(btnBookManager);
		add(btnUserManager);
		add(btnBorrowManager);
		
	}
	
}
