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
		
		btnQuery=new JButton("��ѯͼ��");
		btnQuery.setBounds(0, 0, 187,100);
		btnQuery.setBackground(new Color(238,238,238));
		btnQuery.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new QueryBookPanel(),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		
		btnBorrow=new JButton("����ͼ��");
		btnBorrow.setBounds(187, 0, 187, 100);
		btnBorrow.setBackground(new Color(238,238,238));
		btnBorrow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowBookPanel(),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		
		btnReplace=new JButton("�黹ͼ��");
		btnReplace.setBounds(374, 0,187, 100);
		btnReplace.setBackground(new Color(238,238,238));
		btnReplace.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainFrameReader main=ReaderSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new ReplaceBookPanel(),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		
		add(btnQuery);
		add(btnBorrow);
		add(btnReplace);
		
	}
	
}
