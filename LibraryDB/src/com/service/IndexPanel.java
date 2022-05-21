package com.service;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IndexPanel extends JPanel{
	
	public IndexPanel(){
		JLabel lable=new JLabel();
		ImageIcon image=new ImageIcon("./picture/main.jpg");
		lable.setIcon(image);
		this.add(lable);
	}
	
}
