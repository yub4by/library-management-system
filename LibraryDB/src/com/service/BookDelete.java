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

import com.beans.Book;
import com.daoimpl.BookDaoImpl;

public class BookDelete extends JFrame{
	private Book book;
	private BookDaoImpl daoImpl=new BookDaoImpl();
	
	public BookDelete(int bookId){
		book=daoImpl.getBookById(bookId);
		
		setSize(300,300);
		setTitle("ɾ��ͼ��");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���޶�����
		setLayout(null);
		
		JLabel jl=new JLabel("Ҫɾ����ͼ����Ϣ����");
		jl.setBounds(40, 10, 220, 30);
		jl.setFont(new Font("����",Font.BOLD,20));
		add(jl);
		JLabel jl1=new JLabel("������");
		jl1.setBounds(30, 50, 50, 30);
		add(jl1);
		final JTextField jt1=new JTextField();
		jt1.setBounds(100, 50, 150, 30);
		jt1.setEditable(false);
		jt1.setText(book.getBookName());
		add(jt1);
		
		JLabel jl2=new JLabel("���ߣ�");
		jl2.setBounds(30, 90, 50, 30);
		add(jl2);
		final JTextField jt2=new JTextField();
		jt2.setBounds(100, 90, 150, 30);
		jt2.setEditable(false);
		jt2.setText(book.getBookAuther());
		add(jt2);
		
		JLabel jl3=new JLabel("���");
		jl3.setBounds(30, 130, 50, 30);
		add(jl3);
		final JTextField jt3=new JTextField();
		jt3.setBounds(100, 130, 150, 30);
		jt3.setEditable(false);
		jt3.setText(book.getLoca());
		add(jt3);
		
		JButton submitBtn=new JButton("ȷ��");
		submitBtn.setBackground(new Color(238,238,238));
		submitBtn.setBounds(30, 180, 80, 50);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					book.setBookName(jt1.getText());
					book.setBookAuther(jt2.getText());
					book.setLoca(jt3.getText());
					
						int result=daoImpl.deleteBook(book);//����Աɾ��ͼ���¼
						if(result>0){
							JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
							JTable jt=BookManagerPanel.getTable();
							BookManagerPanel.getBookData(jt);
							dispose();
						}else{
							JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
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
