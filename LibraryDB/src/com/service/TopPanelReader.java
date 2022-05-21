package com.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.util.AdminSwingUtil;
import com.util.ReaderSwingUtil;

public class TopPanelReader extends JPanel {
	private JButton btnQuery;
	private JButton btnBorrow;
	private JButton btnReplace;
	
	public TopPanelReader(){
		this.setLayout(null);
		
		btnQuery=new JButton("查询图书");
		btnQuery.setBounds(0, 0, 187,100);
		btnQuery.setBackground(new Color(238,238,238));
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new QueryBookPanel(),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		
		btnBorrow=new JButton("借阅图书");
		btnBorrow.setBounds(187, 0, 187, 100);
		btnBorrow.setBackground(new Color(238,238,238));
		btnBorrow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowBookPanel(),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		
		btnReplace=new JButton("归还图书");
		btnReplace.setBounds(374, 0,187, 100);
		btnReplace.setBackground(new Color(238,238,238));
		btnReplace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new ReplaceBookPanel(),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		
		add(btnQuery);
		add(btnBorrow);
		add(btnReplace);
		
	}
	
}
