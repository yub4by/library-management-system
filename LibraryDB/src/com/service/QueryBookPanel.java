package com.service;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.daoimpl.BookDaoImpl;

public class QueryBookPanel extends JPanel {
	static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	static int a=0;//�ж��Ƿ����ֶ�ģ����ѯ

	private JLabel jl2;
	private JLabel jl3;
	private JLabel jl4;
	private static JTextField jt1;
	private static JTextField jt2;
	private static JTextField jt3;
	private static JTextField jt4;
	private JButton submit;
	
	public QueryBookPanel(){
		this.setLayout(null);
		
		//���ô������������
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setEnabled(false);
		jt.setRowHeight(60);
		getBookData(jt);
		jsp.setViewportView(jt);
		
		jl2=new JLabel("������");
		jl2.setBounds(0,40, 60, 50);
		jt2=new JTextField();
		jt2.setBounds(40, 40,100,30);
		jl3=new JLabel("���ߣ�");
		jl3.setBounds(0,80, 60, 50);
		jt3=new JTextField();
		jt3.setBounds(40, 80,100,30);
		jl4=new JLabel("���");
		jl4.setBounds(0,120, 60, 50);
		jt4=new JTextField();
		jt4.setBounds(40, 120,100,30);
		
		submit=new JButton("ȷ��");
		submit.setBackground(new Color(238,238,238));
		submit.setBounds(30, 180, 80, 50);
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				a=1;//�ֶ���ѯ������
				getBookData(jt);
				
			}
		});
		add(jl2);
		add(jt2);
		add(jl3);
		add(jt3);
		add(jl4);
		add(jt4);
		add(submit);
	}
	
	//�������ģ��
	public static DefaultTableModel creatDefaultModel(){
		String [] trow=new String[5];
		trow[0]="ͼ����";
		trow[1]="ͼ������";
		trow[2]="ͼ������";
		trow[3]="ͼ�����";
		trow[4]="ͼ��״̬";
		DefaultTableModel dt=new DefaultTableModel(trow,0);
		return dt;
	}
	
	//���ͼ������
	public static void getBookData(JTable jt) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=creatDefaultModel();
		List<Book> bookList=null;
		if(a==1){//�ֶ�ѡ��ģ��
			 String bookName=jt2.getText();
			 String bookAuther=jt3.getText();
			 String loca=jt4.getText();
			bookList=new BookDaoImpl().queryListBook(bookName,bookAuther,loca);
			
		}else{//Ĭ����ʾȫ��
			bookList=new BookDaoImpl().getListBook(0);
		}
		for(Book book:bookList){
			String [] data=new String[5];
			data[0]=book.getBookId()+"";
			data[1]=book.getBookName();
			data[2]=book.getBookAuther();
			data[3]=book.getLoca();
			data[4]=book.getStatus();
			dtm.addRow(data);
		}
		jt.setModel(dtm);
	}
	
}
