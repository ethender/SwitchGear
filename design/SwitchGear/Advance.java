package com.SwitchGear;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Advance extends JPanel implements ActionListener{
	
	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 3;


	public Advance(){
		setLayout(new GridLayout(2,0));
		
		designPanel1();
		add(panel1);
		
		designPanel2();
		add(panel2);
	}
	
	private void designPanel1(){
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(5,0));
		
		/**
		 * assigning employee name
		 */
		empName = new JComboBox<String>();
		empName.addItem("Employee Name");
		panel1.add(empName);
		
		/**
		 * Advance amount
		 */
		JPanel advancePanel = new JPanel();
		advancePanel.setLayout(new GridLayout(0,2));
		
		advancePanel.add(new JLabel("Advance:  "));
		adv = new JTextField(20);
		advancePanel.add(adv);
		panel1.add(advancePanel);
		
		/**
		 * assigning cut/month
		 */
		
		JPanel cutPanel = new JPanel();
		cutPanel.setLayout(new GridLayout(0,2));
		
		cutPanel.add(new JLabel("Cut Per Month: "));
		cut = new JTextField(20);
		cutPanel.add(cut);
		panel1.add(cutPanel);
		
		/**
		 * assigning details of advance
		 */
		
		JButton details = new JButton("Details");
		details.addActionListener(this);
		panel1.add(details);
		
		/**
		 * assigning finalise
		 */
		JPanel finalise = new JPanel();
		finalise.setLayout(new GridLayout(0,2));
		
		
		JButton ok = new JButton("Ok");
		ok.addActionListener(this);
		finalise.add(ok);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		finalise.add(cancel);
		panel1.add(finalise);
		
	}

	/**
	 * assigning error panel
	 */
	private void designPanel2(){
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,0));
		err = new JTextArea();
		panel2.add(err);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Ok")){
			err.setText("hello");
		}else if(e.getActionCommand().equals("Cancel")){
			err.setText("bye");
		}	
	}
	
	
	/**
	 * private instances
	 */
	private JPanel panel1, panel2;
	private JComboBox<String> empName;
	private JTextField adv, cut;
	private JTextArea err;
}
