package com.service;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.beans.Book;
import com.beans.User;
import com.daoimpl.BookDaoImpl;
import com.daoimpl.ReaderDaoImpl;

public class UserQuery extends JFrame{
	public static JTable jt;
	public static JTable getTable(){
		return jt;
	}
	
	static int a=0;//�ж��Ƿ����ֶ���ѯ
	
	static JTextField jt1;
	static JTextField jt2;
	static JTextField jt3;
	
	public UserQuery(){
		setSize(700,310);
		setTitle("��ѯ�û�");
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//���޶�����
		setLayout(null);
		
		//���ô������������
		JScrollPane jsp=new JScrollPane();
		jsp.setBounds(280, 10, 400, 250);
		this.add(jsp);
		jt=new JTable();
		jt.setRowHeight(60);
		getUserData(jt);
		jsp.setViewportView(jt);
		
		JLabel jl1=new JLabel("�û�����");
		jl1.setBounds(30, 30, 70, 30);
		add(jl1);
		jt1=new JTextField();
		jt1.setBounds(100, 30, 150, 30);
		add(jt1);
		
		JLabel jl2=new JLabel("��     �룺");
		jl2.setBounds(30, 70, 70, 30);
		add(jl2);
		jt2=new JTextField();
		jt2.setBounds(100, 70, 150, 30);
		add(jt2);
		
		JLabel jl3=new JLabel("��     ɫ��");
		jl3.setBounds(30, 110, 70, 30);
		add(jl3);
		jt3=new JTextField();
		jt3.setBounds(100, 110, 150, 30);
		add(jt3);
		
		JButton submitBtn=new JButton("ȷ��");
		submitBtn.setBackground(new Color(238,238,238));
		submitBtn.setBounds(30, 180, 80, 50);
		submitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				a=1;//�ֶ���ѯ������
				getUserData(jt);
				a=0;
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
	
		//�������ģ��
		public static DefaultTableModel creatDefaultModel(){
			String [] trow=new String[5];
			trow[0]="�û����";
			trow[1]="�û�����";
			trow[2]="�û�����";
			trow[3]="�û���ע";
			trow[4]="�û���ɫ";
			DefaultTableModel dt=new DefaultTableModel(trow,0);
			return dt;
		}
		
		//����û�����
		public static void getUserData(JTable jt) {
			// TODO Auto-generated method stub
			DefaultTableModel dtm=creatDefaultModel();
			List<User> userList=null;
			if(a==1){
				 String userName=jt1.getText();
				 String password=jt2.getText();
				 String role=jt3.getText();
				 userList=new ReaderDaoImpl().queryListUser(userName,password,role);//ģ����ѯ�û���Ϣ
				
			}else{
				userList=new ReaderDaoImpl().getListUser(0);//��ʾȫ���û���Ϣ
			}
			for(User user:userList){
				String [] data=new String[5];
				data[0]=user.getUserId();
				data[1]=user.getUserName();
				data[2]=user.getPassword();
				data[3]=user.getNote()+"";
				data[4]=user.getRole();
				dtm.addRow(data);
			}
			jt.setModel(dtm);
		}
		
}
