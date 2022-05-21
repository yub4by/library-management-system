package com.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.beans.Borrow;
import com.beans.User;
import com.daoimpl.AdminDaoImpl;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.ReaderDaoImpl;
import com.util.AdminSwingUtil;

public class BorrowManagerPanel extends JPanel {
	private static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	public int a=0;
	
	private JButton borrowedBookBtn;
	private JButton borrowedReaderBtn;
	
	public BorrowManagerPanel(int a){
		this.setLayout(null);
		this.a=a;
		
		//���ô������������
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getUserData(jt);
		jsp.setViewportView(jt);
		
		borrowedBookBtn=new JButton("��������");
		borrowedBookBtn.setBackground(new Color(238,238,238));
		borrowedBookBtn.setBounds(10, 50, 100, 50);
		borrowedBookBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowManagerPanel(2),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		borrowedReaderBtn=new JButton("���������");
		borrowedReaderBtn.setBackground(new Color(238,238,238));
		borrowedReaderBtn.setBounds(10, 150, 100, 50);
		borrowedReaderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				MainFrameAdmin main=AdminSwingUtil.getFrame();
				CenterPanel centerPanel=main.getCenterPanel();
				//�Ƴ��������
				centerPanel.removeAll();
				//����µ����
				centerPanel.setLayout(new BorderLayout());
				centerPanel.add(new BorrowManagerPanel(3),BorderLayout.CENTER );
				//������֤����Ƿ�OK
				centerPanel.revalidate();
				//�ػ�
				centerPanel.repaint();
			}
		});
		add(borrowedBookBtn);
		add(borrowedReaderBtn);
	}
	
	public DefaultTableModel creatDefaultModel(){
		String [] trow={};
		if(a==2){
			trow=new String[5];
			//���������û����ģ��
			trow[0]="�û����";
			trow[1]="��¼����";
			trow[2]="��¼����";
			trow[3]="��ע��Ϣ";
			trow[4]="��ɫ״̬";
		}else if(a==3){
			trow=new String[5];
			//�������������ģ��
			trow[0]="ͼ����";
			trow[1]="ͼ������";
			trow[2]="ͼ������";
			trow[3]="ͼ�����";
			trow[4]="ͼ��״̬";
		}else{
			trow=new String[6];
			//��������˱��ģ��
			trow[0]="�û����";
			trow[1]="��¼����";
			trow[2]="��������";
			trow[3]="ͼ����";
			trow[4]="ͼ������";
			trow[5]="�黹����";
		}
		DefaultTableModel dt=new DefaultTableModel(trow,0);
		return dt;
	}
	public void getUserData(JTable jt) {
		// TODO Auto-generated method stub
		DefaultTableModel dtm=creatDefaultModel();
		if(a==2){
			//��ý����û�����
			List<User> userList=new ReaderDaoImpl().getListUser(1);
			for(User user:userList){
				String [] data=new String[5];
				data[0]=user.getUserId()+"";
				data[1]=user.getUserName();
				data[2]=user.getPassword();
				data[3]=user.getNote()+"";
				data[4]=user.getRole();
				dtm.addRow(data);
			}
		}else if(a==3){
			//��ñ���ͼ������
			List<Book> bookList=new BookDaoImpl().getListBook(2);
			for(Book book:bookList){
				String [] data=new String[5];
				data[0]=book.getBookId()+"";
				data[1]=book.getBookName();
				data[2]=book.getBookAuther();
				data[3]=book.getLoca();
				data[4]=book.getStatus();
				dtm.addRow(data);
			}
		}else{
			//������������
			List<Borrow> bookAndReaderList=new AdminDaoImpl().userBorrowBook();
			for(Borrow borrow:bookAndReaderList){
				String [] data=new String[6];
				data[0]=borrow.getUserId();
				data[1]=borrow.getUserName();
				data[2]=borrow.getLendTime()+"";
				data[3]=borrow.getBookId();
				data[4]=borrow.getBookName();
				data[5]=borrow.getReplaceTime()+"";
				dtm.addRow(data);
			}
		}
		jt.setModel(dtm);
	}

}
