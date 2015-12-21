package com.SwitchGear;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Attendence extends JPanel implements ActionListener{

	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 2;
	
	public Attendence(){
		setLayout(new GridLayout(2,0));
		designPanel1();
		add(panel1);
		designPanel2();
		add(panel2);
	}
	
	private void designPanel1(){
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,0));
		
		/**
		 * assigning employee name
		 */
		empName = new JComboBox<String>();
		empName.addItem("Employee Name ");
		panel1.add(empName);
		
		/**
		 * date
		 */
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new GridLayout(0,3));
		
		// date
		date = new JComboBox<String>();
		for(int i = 1; i <= 31; i++){
			date.addItem(""+i);
		}
		datePanel.add(date);
		
		// month
		month = new JComboBox<String>();
		for(int i = 1; i <= 12; i++){
			month.addItem(getMonth(i));
		}
		datePanel.add(month);
		
		// year
		year = new JComboBox<String>();
		for(int i = 2000; i <= 2050; i++){
			year.addItem(""+i);
		}
		datePanel.add(year);
		panel1.add(datePanel);
		
		/**
		 * OT hours
		 */
		
		JPanel otPanel = new JPanel();
		otPanel.setLayout(new GridLayout(0,2));
		
		otPanel.add(new JLabel("OT hours: "));
		
		ot = new JTextField(20);
		otPanel.add(ot);
		panel1.add(otPanel);
		
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

	
	private String getMonth(int month){
		String result;
		switch(month){
		case 1:
			result = "January";
			break;
		case 2:
			result = "February";
			break;
		case 3:
			result = "March";
			break;
		case 4:
			result = "April";
			break;
		case 5:
			result = "May";
			break;
		case 6:
			result = "June";
			break;
		case 7:
			result = "July";
			break;
		case 8:
			result = "August";
			break;
		case 9:
			result = "September";
			break;
		case 10:
			result = "October";
			break;
		case 11:
			result = "November";
			break;
		case 12:
			result = "December";
			break;
		default:
			result = "Invalid";
			break;
		}
		return result;
	}
	
	
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
	
	private JPanel panel1 , panel2;
	private JComboBox<String> empName, date, month, year;
	private JTextField ot;
	private JTextArea err;
}
