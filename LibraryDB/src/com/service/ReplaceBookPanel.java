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

public class ReplaceBookPanel extends JPanel{
	private static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	private Book book;
	private BookDaoImpl daoImpl=new BookDaoImpl();
	private User user;
	private ReaderDaoImpl daoImpll=new ReaderDaoImpl();
	private AdminDaoImpl daoImplll=new AdminDaoImpl();
	
	private JLabel jl;
	private JTextField jtf;
	private JLabel jl1;
	private JTextField jtf1;
	private JTextArea jta;
	private JButton submit;
	
	public ReplaceBookPanel(){
		this.setLayout(null);
		
				//设置带滚动条的面板
				JScrollPane jsp=new JScrollPane();
				jsp.setBounds(140, 10, 400, 250);
				this.add(jsp);
				jt=new JTable();
				jt.setEnabled(false);
				jt.setRowHeight(60);
				getBookData(jt);
				jsp.setViewportView(jt);
				jl=new JLabel("请输入所还书的编号");
				jl.setBounds(10, 0, 200, 30);
				jtf=new JTextField();
				jtf.setBounds(10,30,120,50);
				
				jl1=new JLabel("请输入你的用户ID");
				jl1.setBounds(10, 80, 200, 50);
				add(jl1);
				jtf1=new JTextField(); 
				jtf1.setBounds(10,120,120,50);
				add(jtf1);
				
				jta=new JTextArea();
				jta.setBounds(10, 170, 120, 20);
				jta.setEditable(false);
				jta.setBackground(new Color(238,238,238));
				submit=new JButton("确定");
				submit.setBackground(new Color(238,238,238));
				submit.setBounds(40, 220, 60, 40);
				submit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						book=new Book();
						user=new User();
						String bd=jtf.getText();
						String ud=jtf1.getText();
						if(bd==null||"".equals(bd)||ud==null||"".equals(ud)){
							jta.setBackground(Color.LIGHT_GRAY);
							jta.setText("请输入完整信息！");
						}else{
							int bookId=Integer.parseInt(bd);
							book.setBookId(bookId);
							user.setUserId(ud);
							book=daoImpl.getBookById(book.getBookId());
							user=daoImpll.getUserById(user.getUserId());
							
							if(book==null){
								jta.setBackground(Color.LIGHT_GRAY);
								jta.setText("没有这本书！");
							}else if(user==null){
								jta.setBackground(Color.LIGHT_GRAY);
								jta.setText("没有这个用户！");
							}else{
								if("借出".equals(book.getStatus())){ 
									if(user.getNote()!=0){   
										int bookID=book.getBookId();
										int userNote=user.getNote();
										if(bookID==userNote){
											int result=daoImpl.borrowBook(0,book,user);//修改books表信息
											if(result>0){
												jta.setBackground(Color.LIGHT_GRAY);
												jta.setText("还书成功！");
												JTable jt=getTable();
												getBookData(jt);
												
												daoImplll.deleteBorrow(user);//还书成功后删除borrow表中该用户此次借书记录
												daoImpll.updateBorrower(0,book,user);//还书成功后修改users表借书者信息
												
											}else{
												jta.setBackground(Color.LIGHT_GRAY);
												jta.setText("还书失败！");
											}
										}else{
											jta.setBackground(Color.LIGHT_GRAY);
											jta.setText("这不是你借的书！");
										}
									}else{
										jta.setBackground(Color.LIGHT_GRAY);
										jta.setText("请输入正确用户ID！");//该用户未借书
									}
								}else{
									jta.setBackground(Color.LIGHT_GRAY);
									jta.setText("请输入正确图书ID！");//该图书未借出
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
	
		//创建表格模型
		public DefaultTableModel creatDefaultModel(){
			String [] trow=new String[5];
			trow[0]="图书编号";
			trow[1]="图书名称";
			trow[2]="图书作者";
			trow[3]="图书类别";
			trow[4]="图书状态";
			DefaultTableModel dt=new DefaultTableModel(trow,0);
			return dt;
		}
		
		//获得图书数据
		private void getBookData(JTable jt) {
			// TODO Auto-generated method stub
			DefaultTableModel dtm=creatDefaultModel();
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
			jt.setModel(dtm);
		}
		
}
