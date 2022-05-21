package com.service;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.beans.Borrow;
import com.beans.User;
import com.daoimpl.AdminDaoImpl;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.ReaderDaoImpl;

public class BorrowBookPanel extends JPanel {
	private static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	private Book book;
	private BookDaoImpl daoImpl=new BookDaoImpl();
	private User user;
	private ReaderDaoImpl daoImpll=new ReaderDaoImpl();
	private AdminDaoImpl daoImplll=new AdminDaoImpl();
	private Borrow borrow;
	
	private JLabel jl;
	private JTextField jtf;
	private JLabel jl1;
	private JTextField jtf1;
	private JTextArea jta;
	private JButton submit;
	
	public BorrowBookPanel(){
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
				
				jl=new JLabel("������������ı��");
				jl.setBounds(10, 0, 200, 30);
				jtf=new JTextField();
				jtf.setBounds(10,30,120,50);
				
				jl1=new JLabel("����������û�ID");
				jl1.setBounds(10, 80, 200, 50);
				add(jl1);
				jtf1=new JTextField(); 
				jtf1.setBounds(10,120,120,50);
				add(jtf1);
				
				jta=new JTextArea();
				jta.setBounds(10, 170, 120, 20);
				jta.setEditable(false);
				jta.setBackground(new Color(238,238,238));
				submit=new JButton("ȷ��");
				submit.setBackground(new Color(238,238,238));
				submit.setBounds(40, 220, 60, 40);
				submit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						book=new Book();
						user=new User();
						String bd=jtf.getText();
						String ud=jtf1.getText();
						if(bd==null||"".equals(bd)||ud==null||"".equals(ud)){
							jta.setBackground(Color.LIGHT_GRAY);
							jta.setText("������������Ϣ��");
						}else{
							int bookId=Integer.parseInt(bd);
							book.setBookId(bookId);
							user.setUserId(ud);
							book=daoImpl.getBookById(book.getBookId());
							user=daoImpll.getUserById(user.getUserId());
							
							if(book==null){
								jta.setBackground(Color.LIGHT_GRAY);
								jta.setText("û���Ȿ�飡");
							}else if(user==null){
								jta.setBackground(Color.LIGHT_GRAY);
								jta.setText("û������û���");
							}else{
								if("�ɽ�".equals(book.getStatus())){
									if(user.getNote()!=0){
										jta.setBackground(Color.LIGHT_GRAY);
										jta.setText("�û�һ��ֻ�ܽ�һ���飡");
									}else{
										int result=daoImpl.borrowBook(1,book,user);//�޸�book����Ϣ
										if(result>0){
											jta.setBackground(Color.LIGHT_GRAY);
											jta.setText("����ɹ���");
											JTable jt=getTable();
											getBookData(jt);
											
											daoImplll.insertBorrow(user,book);//���ĳɹ���borrow���в�������
											daoImplll.insertTest(user,book);//���ĳɹ���test���в�������
											daoImpll.updateBorrower(1,book,user);//���ĳɹ��޸�users����Ϣ
											
											
											borrow=daoImplll.getBorrowByUserBook(user,book);
											new successBorrow(borrow);//���ĳɹ���������ʾborrow��ı��ν�����Ϣ
										}else{
											jta.setBackground(Color.LIGHT_GRAY);
											jta.setText("����ʧ�ܣ�");
										}
									}
								}else{
									jta.setBackground(Color.LIGHT_GRAY);
									jta.setText("�����ѱ������");
								}
							}
						}	
					}
				});
				add(jl);
				add(jtf);
				add(jta);
				add(submit);
	}
	
		//�������ģ��
		public DefaultTableModel creatDefaultModel(){
			String [] trow=new String[5];
			trow[0]="ͼ����";
			trow[1]="ͼ������";
			trow[2]="ͼ������";
			trow[3]="ͼ�����";
			trow[4]="ͼ��״̬";
			DefaultTableModel dt=new DefaultTableModel(trow,0);
			return dt;
		}
		
		//��ÿɽ�ͼ������
		public void getBookData(JTable jt) {
			// TODO Auto-generated method stub
			DefaultTableModel dtm=creatDefaultModel();
			List<Book> bookList=new BookDaoImpl().getListBook(1);
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
