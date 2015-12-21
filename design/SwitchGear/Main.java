package com.SwitchGear;


import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;


public class Main implements ActionListener{
	
	public static void main(String[] args){
		Main m = new Main();
	}
	
	public Main(){
		design();
	}
	
	private void design(){
		frame = new JFrame("SwitchGear");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(850,750);
		
		frame.setLayout(new BorderLayout());
		
		designPanel1();
		
		frame.add(panel1, BorderLayout.LINE_START);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,0));
		frame.add(panel2, BorderLayout.CENTER);
		
		
	}
	
	
	private void designPanel1(){
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,0));
		JButton create = new JButton("Create Employee");
		create.addActionListener(this);
		panel1.add(create);
		
		JButton att = new JButton("Attendence");
		att.addActionListener(this);
		panel1.add(att);
		
		JButton advance = new JButton("Advance");
		advance.addActionListener(this);
		panel1.add(advance);
		
		JButton payment = new JButton("Payment");
		payment.addActionListener(this);
		panel1.add(payment);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Create Employee")){
			
				panel2.removeAll();
				CreateEmployee emp = new CreateEmployee();
				panel2.add(emp);
				panel2.repaint();
			
		}else if(e.getActionCommand().equals("Attendence")){
			panel2.removeAll();
			Attendence att = new Attendence();
			panel2.add(att);
			panel2.repaint();
		}else if(e.getActionCommand().equals("Advance")){
			panel2.removeAll();
			Advance ad = new Advance();
			panel2.add(ad);
			panel2.repaint();
		}else if(e.getActionCommand().equals("Payment")){
			panel2.removeAll();
			Payment pay = new Payment();
			panel2.add(pay);
			panel2.repaint();
		}
	}
	
	/**
	 * private instances
	 */
	private JPanel panel1, panel2;
	private JFrame frame;
	//private JTextArea area;
	
}