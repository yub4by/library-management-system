package com.service;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.beans.User;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.ReaderDaoImpl;

public class UserManagerPanel extends JPanel {
	private static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	private User user;
	private ReaderDaoImpl daoImpl=new ReaderDaoImpl();
	
	private JButton addBtn;
	private JButton deleteBtn;
	private JButton updateBtn;
	private JButton queryBtn;
	
	public UserManagerPanel(){
		this.setLayout(null);
		
		//设置带滚动条的面板
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getUserData(jt);
		jsp.setViewportView(jt);
		
		addBtn=new JButton("添加用户");
		addBtn.setBackground(new Color(238,238,238));
		addBtn.setBounds(10, 10, 100, 50);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new UserAdd();
			}
		});
		deleteBtn=new JButton("删除用户");
		deleteBtn.setBackground(new Color(238,238,238));
		deleteBtn.setBounds(10, 70, 100, 50);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "请选择要删除的用户");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "请选择一条数据删除");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					//int userId=Integer.parseInt(strId);
					user=daoImpl.getUserById(strId);
					String role=user.getRole();
					if(role==null || "".equals(role) || "管理员".equals(role) ){
						JOptionPane.showMessageDialog(null, "管理员不可删除！");
					}else{
						new UserDelete(strId);
					}
				}
			}
		});
		updateBtn=new JButton("修改用户");
		updateBtn.setBackground(new Color(238,238,238));
		updateBtn.setBounds(10, 130, 100, 50);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "请选择要修改的用户");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "请选择一条数据修改");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					//int userId=Integer.parseInt(strId);
					new UserUpdate(strId);
				}
			}
		});
		queryBtn=new JButton("查找用户");
		queryBtn.setBackground(new Color(238,238,238));
		queryBtn.setBounds(10, 200, 100, 50);
		queryBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				new UserQuery(); 
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
				trow[0]="用户编号";
				trow[1]="登录名称";
				trow[2]="登录密码";
				trow[3]="备注信息";
				trow[4]="角色状态";
				DefaultTableModel dt=new DefaultTableModel(trow,0);
				return dt;
			}
			
			//获得全部用户数据
			public static void getUserData(JTable jt) {
				// TODO Auto-generated method stub
				DefaultTableModel dtm=creatDefaultModel();
				List<User> userList=null;
				userList=new ReaderDaoImpl().getListUser(0);
				for(User user:userList){
					String [] data=new String[5];
					data[0]=user.getUserId()+"";
					data[1]=user.getUserName();
					data[2]=user.getPassword();
					data[3]=user.getNote()+"";
					data[4]=user.getRole();
					dtm.addRow(data);
				}
				jt.setModel(dtm);
			}
	
}
