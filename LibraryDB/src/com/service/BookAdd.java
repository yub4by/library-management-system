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
		setTitle("���ͼ��");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���޶�����
		setLayout(null);
		
		JLabel jl1=new JLabel("������");
		jl1.setBounds(30, 30, 50, 30);
		add(jl1);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 30, 150, 30);
		add(jt1);
		
		JLabel jl2=new JLabel("���ߣ�");
		jl2.setBounds(30, 70, 50, 30);
		add(jl2);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 70, 150, 30);
		add(jt2);
		
		JLabel jl3=new JLabel("���");
		jl3.setBounds(30, 110, 50, 30);
		add(jl3);
		final JTextField jt3=new JTextField();
		jt3.setBounds(100, 110, 150, 30);
		add(jt3);
		
		ButtonGroup btnGroup=new ButtonGroup();
		final JRadioButton radio1=new JRadioButton("�ɽ�");
		radio1.setBounds(50, 150, 70, 20);
		final JRadioButton radio3=new JRadioButton("ά��");
		radio3.setBounds(180, 150, 70, 20);
		btnGroup.add(radio1);
		btnGroup.add(radio3);
		add(radio1);
		add(radio3);
		
		JButton submitBtn=new JButton("ȷ��");
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
					JOptionPane.showMessageDialog(null, "��Ϣ��д��������");
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
						status="�ɽ�";
					}
					book.setStatus(status);
					int result=daoImpl.addBook(book);//���ͼ��
					if(result>0){
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
						JTable jt=BookManagerPanel.getTable();
						BookManagerPanel.getBookData(jt);//����ȥ��.getInstence()����ΪgetBookData(jt)�Ǿ�̬�ģ�
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
					}
				}
			}
		});
		add(submitBtn);
		
		JButton cancleBtn=new JButton("ȡ��");
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
