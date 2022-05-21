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
		
		btnBookManager=new JButton("ͼ�����");
		btnBookManager.setBounds(0, 0, 187,100);
		btnBookManager.setBackground(new Color(238,238,238));
		btnBookManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BookManagerPanel(),BorderLayout.CENTER );//BookManagerPanel.getInstence()
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		
		btnUserManager=new JButton("�û�����");
		btnUserManager.setBounds(187, 0, 187, 100);
		btnUserManager.setBackground(new Color(238,238,238));
		btnUserManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new UserManagerPanel(),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		
		btnBorrowManager=new JButton("���Ĺ���");
		btnBorrowManager.setBounds(374, 0,187, 100);
		btnBorrowManager.setBackground(new Color(238,238,238));
		btnBorrowManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowManagerPanel(1),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		
		add(btnBookManager);
		add(btnUserManager);
		add(btnBorrowManager);
		
	}
	
}
