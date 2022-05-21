package com.service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.daoimpl.BookDaoImpl;
import com.util.AdminSwingUtil;

public class BookManagerPanel extends JPanel {
	public static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	/*private static BookManagerPanel bookManagerPanel=new BookManagerPanel();
	public static BookManagerPanel getInstence(){//����ģʽ
		return bookManagerPanel;
	}*/
	
	private Book book;
	private BookDaoImpl daoImpl=new BookDaoImpl();
	
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton queryBtn;
	
	public BookManagerPanel(){//����Ϊprivate˽�з�ֹ������������ʵ��
		this.setLayout(null);
		
		//���ô������������
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getBookData(jt);
		jsp.setViewportView(jt);

		addBtn=new JButton("���ͼ��");
		addBtn.setBackground(new Color(238,238,238));
		addBtn.setBounds(10, 10, 100, 50);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BookAdd();
			}
		});
		deleteBtn=new JButton("ɾ��ͼ��");
		deleteBtn.setBackground(new Color(238,238,238));
		deleteBtn.setBounds(10, 70, 100, 50);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����鼮");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "��ѡ��һ������ɾ��");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					int bookId=Integer.parseInt(strId);
					book=daoImpl.getBookById(bookId);
					String status=book.getStatus();
					if(status==null || "".equals(status) || "ά��".equals(status) || "���".equals(status)){
						JOptionPane.showMessageDialog(null, "���鴦��ά������״̬������ɾ����");
					}else{
						new BookDelete(bookId);
					}
				}
				
				/*else{//�ɶ�ѡ��������һ��ɾ�������ܱ�֤ά������״̬���鲻��ɾ��
					String strId="";
					for(int i=0;i<index.length;i++){
						if(i==index.length-1){
							strId+=(String)jt.getValueAt(index[i], 0);
						}else{
							strId+=(String)jt.getValueAt(index[i], 0)+",";
						}
					}
					int result=daoImpl.delBook(strId);
					if(result>0){
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
						JTable jt=BookManagerPanel.getTable();
						BookManagerPanel.getBookData(jt);
					}else{
						JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
					}
				}*/
				
			}	
		});
		updateBtn=new JButton("�޸�ͼ��");
		updateBtn.setBackground(new Color(238,238,238));
		updateBtn.setBounds(10, 130, 100, 50);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ��鼮");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "��ѡ��һ�������޸�");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					int bookId=Integer.parseInt(strId);
					new BookUpdate(bookId);
				}
				
			}
		});
		queryBtn=new JButton("����ͼ��");
		queryBtn.setBackground(new Color(238,238,238));
		queryBtn.setBounds(10, 200, 100, 50);
		queryBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BookQuery();
			}
		});
		
		add(addBtn);
		add(deleteBtn);
		add(updateBtn);
		add(queryBtn);
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
			DefaultTableModel dtm=creatDefaultModel();
			List<Book> bookList=null;
			bookList=new BookDaoImpl().getListBook(0);
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
