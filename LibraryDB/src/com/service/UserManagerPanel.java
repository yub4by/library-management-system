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
		
		//���ô������������
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(140, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getUserData(jt);
		jsp.setViewportView(jt);
		
		addBtn=new JButton("����û�");
		addBtn.setBackground(new Color(238,238,238));
		addBtn.setBounds(10, 10, 100, 50);
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				new UserAdd();
			}
		});
		deleteBtn=new JButton("ɾ���û�");
		deleteBtn.setBackground(new Color(238,238,238));
		deleteBtn.setBounds(10, 70, 100, 50);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫɾ�����û�");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "��ѡ��һ������ɾ��");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					//int userId=Integer.parseInt(strId);
					user=daoImpl.getUserById(strId);
					String role=user.getRole();
					if(role==null || "".equals(role) || "����Ա".equals(role) ){
						JOptionPane.showMessageDialog(null, "����Ա����ɾ����");
					}else{
						new UserDelete(strId);
					}
				}
			}
		});
		updateBtn=new JButton("�޸��û�");
		updateBtn.setBackground(new Color(238,238,238));
		updateBtn.setBounds(10, 130, 100, 50);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				int [] index=jt.getSelectedRows();
				if(index.length==0){
					JOptionPane.showMessageDialog(null, "��ѡ��Ҫ�޸ĵ��û�");
				}else if(index.length>1){
					JOptionPane.showMessageDialog(null, "��ѡ��һ�������޸�");
				}else{
					String strId=(String)jt.getValueAt(index[0], 0);
					//int userId=Integer.parseInt(strId);
					new UserUpdate(strId);
				}
			}
		});
		queryBtn=new JButton("�����û�");
		queryBtn.setBackground(new Color(238,238,238));
		queryBtn.setBounds(10, 200, 100, 50);
		queryBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				new UserQuery(); 
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
				trow[0]="�û����";
				trow[1]="��¼����";
				trow[2]="��¼����";
				trow[3]="��ע��Ϣ";
				trow[4]="��ɫ״̬";
				DefaultTableModel dt=new DefaultTableModel(trow,0);
				return dt;
			}
			
			//���ȫ���û�����
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
