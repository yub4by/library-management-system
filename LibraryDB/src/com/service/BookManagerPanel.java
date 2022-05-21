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
	public static BookManagerPanel getInstence(){//单例模式
		return bookManagerPanel;
	}*/
	
	private Book book;
	private BookDaoImpl daoImpl=new BookDaoImpl();
	
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton queryBtn;
	
	public BookManagerPanel(){//可设为private私有防止其他创建本类实例
		this.setLayout(null);
		
		//设置带滚动条的面板
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getBookData(jt);
		jsp.setViewportView(jt);

		addBtn=new JButton("添加图书");
		addBtn.setBackground(new Color(238,238,238));
		addBtn.setBounds(10, 10, 100, 50);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new BookAdd();
			}
		});
		deleteBtn=new JButton("删除图书");
		deleteBtn.setBackground(new Color(238,238,238));
		deleteBtn.setBounds(10, 70, 100, 50);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "请选择要删除的书籍");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "请选择一条数据删除");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					int bookId=Integer.parseInt(strId);
					book=daoImpl.getBookById(bookId);
					String status=book.getStatus();
					if(status==null || "".equals(status) || "维护".equals(status) || "借出".equals(status)){
						JOptionPane.showMessageDialog(null, "该书处于维护或借出状态，不可删除！");
					}else{
						new BookDelete(bookId);
					}
				}
				
				/*else{//可多选多条数据一起删除但不能保证维护或借出状态的书不被删除
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
						JOptionPane.showMessageDialog(null, "删除成功！");
						JTable jt=BookManagerPanel.getTable();
						BookManagerPanel.getBookData(jt);
					}else{
						JOptionPane.showMessageDialog(null, "删除失败！");
					}
				}*/
				
			}	
		});
		updateBtn=new JButton("修改图书");
		updateBtn.setBackground(new Color(238,238,238));
		updateBtn.setBounds(10, 130, 100, 50);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "请选择要修改的书籍");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "请选择一条数据修改");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					int bookId=Integer.parseInt(strId);
					new BookUpdate(bookId);
				}
				
			}
		});
		queryBtn=new JButton("查找图书");
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
	
		//创建表格模型
		public static DefaultTableModel creatDefaultModel(){
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
