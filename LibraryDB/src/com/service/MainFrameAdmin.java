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
import com.test.Main_Frame_Admin;
import com.test.Main_Frame_Reader;
import com.util.AdminSwingUtil;

public class MainFrameAdmin extends JFrame {
	private CenterPanel centerPanel;

	public MainFrameAdmin(){
		setSize(560,420);
		setTitle("ͼ�����ϵͳ--����Ա����");
		
		//��ʼ���˵���
		initMenuBar();
		//��ʼ����������
		initPanel();
		//��ʼ����������
		initCenterPanel();
		
		AdminSwingUtil.setFrame(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//����м���������
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
		TopPanelAdmin lp=new TopPanelAdmin();
		lp.setPreferredSize(new Dimension(187,99));
		lp.setVisible(true);
		this.add(lp,BorderLayout.NORTH);
	}

	private void initMenuBar() {
		// TODO Auto-generated method stub
		MenuBar menuBar=new MenuBar();
		Menu m1=new Menu("MENU");
		MenuItem i1=new MenuItem("index");
		MenuItem i2=new MenuItem("old");
		MenuItem i5=new MenuItem("exit");
		i1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new IndexPanel(),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		i2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Main_Frame_Admin().setVisible(true);
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
		m1.add(i5);
		menuBar.add(m1);
		setMenuBar(menuBar);
	}
	
	public static void main(String[] args) {
		new MainFrameAdmin();
	}
	
}
