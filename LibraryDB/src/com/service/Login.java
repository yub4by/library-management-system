/*
 * Login.java
 *
 * Created on __DATE__, __TIME__
 */

package com.service;

import javax.swing.JOptionPane;

import com.beans.User;
import com.daoimpl.ReaderDaoImpl;
import com.service.MainFrameAdmin;
import com.service.MainFrameReader;

/**
 *
 * @author  __USER__
 */
public class Login extends javax.swing.JFrame {
	/*public static User user=new User();//
	static ReaderDaoImpl rdi = new ReaderDaoImpl();//
*/	
	//GEN-BEGIN:variables
		// Variables declaration - do not modify
		private javax.swing.JButton jButton1;
		private javax.swing.JButton jButton2;
		private javax.swing.JCheckBox jCheckBox1;
		private javax.swing.JCheckBox jCheckBox2;
		public javax.swing.JLabel jLabel1;
		private javax.swing.JLabel jLabel2;
		private javax.swing.JLabel jLabel3;
		private javax.swing.JPanel jPanel1;
		public static javax.swing.JTextField jTextField1;//= new javax.swing.JTextField();
		public static javax.swing.JTextField jTextField2;//= new javax.swing.JTextField();
		// End of variables declaration//GEN-END:variables
		
		public static User user;//
		public static ReaderDaoImpl rdi = new ReaderDaoImpl();//
		
	/** Creates new form Login */
	public Login() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jCheckBox1 = new javax.swing.JCheckBox();
		jCheckBox2 = new javax.swing.JCheckBox();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("��������������ӭʹ��ͼ�����ϵͳ������������");//\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf

		jPanel1.setBackground(new java.awt.Color(153, 153, 153));

		jLabel1.setFont(new java.awt.Font("����", 0, 24));
		jLabel1.setForeground(new java.awt.Color(102, 0, 204));
		jLabel1.setIcon(new javax.swing.ImageIcon(
				"./picture/login.jpg")); // NOI18N

		jLabel2.setFont(new java.awt.Font("������ͤ��ϸ�ڼ���", 1, 14));
		jLabel2.setText("\u8d26\u53f7\uff1a");

		jLabel3.setFont(new java.awt.Font("������ͤ��ϸ�ڼ���", 1, 14));
		jLabel3.setText("\u5bc6\u7801\uff1a");

		jTextField1.setBackground(new java.awt.Color(255, 255, 204));

		jTextField2.setBackground(new java.awt.Color(255, 255, 204));

		jCheckBox1.setBackground(new java.awt.Color(255, 255, 0));
		jCheckBox1.setText("\u8bb0\u4f4f\u5bc6\u7801");
		jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox1ActionPerformed(evt);
			}
		});

		jCheckBox2.setBackground(new java.awt.Color(255, 255, 0));
		jCheckBox2.setText("\u81ea\u52a8\u767b\u5f55");
		jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBox2ActionPerformed(evt);
			}
		});

		jButton1.setIcon(new javax.swing.ImageIcon(
				"./picture/login.gif")); // NOI18N
		jButton1.setText("\u767b\u9646");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setIcon(new javax.swing.ImageIcon(
				"./picture/reset.gif")); // NOI18N
		jButton2.setText("\u91cd\u7f6e");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(50,
																				50,
																				50)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jCheckBox1)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel3)
																						.addComponent(
																								jButton1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								58,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGap(3,
																				3,
																				3)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								jPanel1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												jTextField2,
																												javax.swing.GroupLayout.Alignment.LEADING)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.Alignment.LEADING,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												182,
																												Short.MAX_VALUE)
																										.addComponent(
																												jCheckBox2))
																						.addComponent(
																								jButton2,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								57,
																								javax.swing.GroupLayout.PREFERRED_SIZE)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(41,
																				41,
																				41)
																		.addComponent(
																				jLabel1)))
										.addGap(45, 45, 45)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGap(27, 27, 27)
										.addComponent(jLabel1)
										.addGap(18, 18, 18)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(30, 30, 30)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(jLabel3)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(36, 36, 36)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jCheckBox1)
														.addComponent(
																jCheckBox2))
										.addGap(27, 27, 27)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jButton2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																24,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jButton1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																24,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(29, 29, 29)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	//����
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
		jTextField1.setText("");
		jTextField2.setText("");
		
	}
	
	//��ȡǰ̨����
	/*public static String userName = jTextField1.getText();
	public static String password = jTextField2.getText();
	public static User user = rdi.Login(userName, password);*/
	
	
	//��¼
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
				
				//��ȡǰ̨����
				String userName = jTextField1.getText();
				String password = jTextField2.getText();
				//ȥ���ݿ���֤
				user = rdi.Login(userName, password);
				System.out.println(userName+password);
				if (user != null) {
					System.out.println("��½�ɹ�");
					//��ȡ��ɫ
					String role = user.getRole();
					if ("����Ա".equals(role)) {
						setVisible(false);
						//��ת������Ա��ҳ��
						/*new Main_Frame_Admin().setVisible(true);*/
						new MainFrameAdmin().setVisible(true);
					} else if ("����".equals(role)) {
						setVisible(false);
						//��ת��������ҳ��
						/*new Main_Frame_Reader().setVisible(true);*/
						new MainFrameReader().setVisible(true);
					} else {
						System.out.println("role����!");
					}
				} else {
					System.out.println("��½ʧ��");
					JOptionPane.showMessageDialog(null, "�û������������");
				}
				
	}
	
	//��¼ҳ�����û��������뷵�ر��û�����Ϣ������get��ȡ��
	public static User getID(){//String name,String pass
		//user = rdi.Login(userName, password);
		//String id=user.getUserId();
		return user;
	}
	
	//��ס����
	private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	//�Զ���¼
	private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	

}