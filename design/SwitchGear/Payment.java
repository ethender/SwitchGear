package com.SwitchGear;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JPanel implements ActionListener{

	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 3;
	
	public Payment(){
		setLayout(new GridLayout(2,0));
		
		designPanel1();
		add(panel1);
		
		designPanel2();
		add(panel2);
	}
	
	private void designPanel1(){
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(12,0));
		
		/**
		 * assigning emp name
		 */
		employee = new JComboBox<String>();
		employee.addItem("Employee Name");
		panel1.add(employee);
		
		/**
		 * assigning industry
		 */
		
		industry = new JComboBox<String>();
		panel1.add(industry);
		
		/**
		 * assigning dates Present
		 */
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new GridLayout(0,3));
		
		datePanel.add(new JLabel("Attended"));
		present = new JTextField(20);
		datePanel.add(present);
		
		JButton dateDetails = new JButton("Get Details");
		dateDetails.addActionListener(this);
		datePanel.add(dateDetails);
		
		panel1.add(datePanel);
		
		/**
		 * assigning present hours
		 */
		JPanel presentHourPanel = new JPanel();
		presentHourPanel.setLayout(new GridLayout(0,2));
		
		presentHourPanel.add(new JLabel("Total Duty Hours "));
		presentHours  = new JTextField(20);
		presentHourPanel.add(presentHours);
		
		panel1.add(presentHourPanel);
		
		/**
		 * assigning ot hours
		 */
		JPanel otPanel  = new JPanel();
		otPanel.setLayout(new GridLayout(0,2));
		
		otPanel.add(new JLabel("OT Hours "));
		
		ot = new JTextField(20);
		otPanel.add(ot);
		
		panel1.add(otPanel);
		
		/**
		 * assigning total hours
		 */
		
		JPanel totalPanel = new JPanel();
		totalPanel.setLayout(new GridLayout(0,2));
		
		totalPanel.add(new JLabel("Total Hours"));
		totalHours = new JTextField(20);
		totalPanel.add(totalHours);
		panel1.add(totalPanel);
		
		/**
		 * assigning total duty payment
		 */
		JPanel dutyAmountPayment = new JPanel();
		dutyAmountPayment.setLayout(new GridLayout(0,2));
		
		dutyAmountPayment.add(new JLabel("General Hours Payment "));
		generalAmount = new JTextField(20);
		dutyAmountPayment.add(generalAmount);
		panel1.add(dutyAmountPayment);
		
		/**
		 * assigning ot hours payment
		 */
		JPanel otAmountPayment =  new JPanel();
		otAmountPayment.setLayout(new GridLayout(0,2));
		
		otAmountPayment.add(new JLabel("OT Hours Payment"));
		otAmount = new JTextField(20);
		otAmountPayment.add(otAmount);
		panel1.add(otAmountPayment);
		
		/**
		 * Total amount payment before advance cut off
		 */
		JPanel totalPayPanel = new JPanel();
		totalPayPanel.setLayout(new GridLayout(0,2));
		
		totalPayPanel.add(new JLabel("Total Amount"));
		totalBAAmount = new JTextField(20);
		totalPayPanel.add(totalBAAmount);
		panel1.add(totalPayPanel);
		
		/**
		 * assigning Advance 
		 */
		JPanel advancePanel = new JPanel();
		advancePanel.setLayout(new GridLayout(0,2));
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new GridLayout(1,0));
		
		
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new GridLayout(0,2));
		
		
		subPanel1.add(new JLabel("Total Advance "));
		totalAdv = new JTextField(20);
		subPanel1.add(totalAdv);
		
		subPanel2.add(new JLabel("Cut / Month "));
		cutAdv  = new JTextField(20);
		subPanel2.add(cutAdv);
		
		subPanel2.add(new JLabel("Remaining Balance "));
		remainAdv = new JTextField(20);
		subPanel2.add(remainAdv);
		
		
		advancePanel.add(subPanel1);
		advancePanel.add(subPanel2);
		
		panel1.add(advancePanel);
		
		/**
		 * total after cut off
		 */
		
		JPanel finalPay = new JPanel();
		finalPay.setLayout(new GridLayout(0,2));
		
		finalPay.add(new JLabel("Total Payment "));
		totalFinalAmount = new JTextField(20);
		finalPay.add(totalFinalAmount);
		panel1.add(finalPay);
		
		/**
		 * assigning fianlise
		 */
		JPanel finalise = new JPanel();
		finalise.setLayout(new GridLayout(0,2));
		
		JButton ok  = new JButton("Ok");
		ok.addActionListener(this);
		finalise.add(ok);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		finalise.add(cancel);
		
		panel1.add(finalise);
		
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
	private JPanel panel1, panel2;
	private JComboBox<String> employee , industry;
	private JTextField present, presentHours, ot, totalHours, generalAmount, otAmount;
	private JTextField totalAdv, cutAdv , remainAdv;
	private JTextField totalBAAmount, totalFinalAmount; // totalBAAmount = total before advance amount
	private JTextArea err;
}
