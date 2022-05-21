package com.service;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.test.About;
import com.test.About;
import com.test.Main_Frame_Admin;
import com.test.Main_Frame_Reader;
import com.util.AdminSwingUtil;
import com.util.ReaderSwingUtil;

public class MainFrameReader extends JFrame {
	private CenterPanel centerPanel;
	
	public MainFrameReader(){
		setSize(560,420);//420
		setTitle("图书管理系统--读者中心");
		
		//初始化菜单栏
		initMenuBar();
		//初始化导航容器
		initPanel();
		//初始化内容容器
		initCenterPanel();
		
		ReaderSwingUtil.setFrame(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//获得中间内容容器
	public CenterPanel getCenterPanel(){
		return centerPanel;
	}

	private void initCenterPanel() {
		// TODO Auto-generated method stub
		centerPanel=new CenterPanel();
		JLabel lable=new JLabel();
		ImageIcon image=new ImageIcon("./picture/main.jpg");
		lable.setIcon(image);
		centerPanel.add(lable);
		this.add(centerPanel,BorderLayout.CENTER);	
		
	}

	private void initPanel() {
		// TODO Auto-generated method stub
		TopPanelReader lp=new TopPanelReader();
		lp.setPreferredSize(new Dimension(300,100));
		lp.setVisible(true);
		this.add(lp,BorderLayout.NORTH);
	}

	private void initMenuBar() {
		// TODO Auto-generated method stub
		MenuBar menuBar=new MenuBar();
		Menu m1=new Menu("MENU");
		MenuItem i1=new MenuItem("index");
		MenuItem i2=new MenuItem("old");
		MenuItem i4=new MenuItem("about");
		MenuItem i5=new MenuItem("exit");
		i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//移除所有组件
				centerPanel.removeAll();
				//添加新的组件
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new IndexPanel(),BorderLayout.CENTER );
				//重新验证组件是否OK
				centerPanel.revalidate();
				//重绘
				centerPanel.repaint();
			}
		});
		i2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Main_Frame_Reader().setVisible(true);
			}
		});
		i4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new About().setVisible(true);
			}
		});
		i5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		m1.add(i1);
		m1.add(i2);
		m1.add(i4);
		m1.add(i5);
		menuBar.add(m1);
		setMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MainFrameReader();
	}
	
}
