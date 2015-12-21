package com.SwitchGear;

import javax.swing.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class CreateEmployee extends JPanel implements ActionListener {

	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 2;

	public CreateEmployee(){
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
		JPanel panelName = new JPanel();
		panelName.setLayout(new GridLayout(1,2));
		panelName.add(new JLabel("Name :"));
		name = new JTextField(30);
		panelName.add(name);
		panel1.add(panelName);
		
		/**
		 * assigning salary
		 */
		
		JPanel panelSalary = new JPanel();
		panelSalary.setLayout(new GridLayout(1,2));
		panelSalary.add(new JLabel("Salary : "));
		salary = new JTextField(10);
		panelSalary.add(salary);
		panel1.add(panelSalary);
		
		JPanel panelOT = new JPanel();
		panelOT.setLayout(new GridLayout(1,2));
		panelOT.add(new JLabel("OT Per Hour : "));
		ot = new JTextField(10);
		panelOT.add(ot);
		panel1.add(panelOT);
		
		industry = new JComboBox<String>();
		industry.addItem("SwitchGear industry");
		industry.addItem("Ashwini industry");
		industry.setSelectedItem("SwitchGear industry");
		panel1.add(industry);
		
		JPanel finalise = new JPanel();
		finalise.setLayout(new GridLayout(1,2));
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		finalise.add(ok);
		finalise.add(cancel);
		panel1.add(finalise);
	}
	
	private void designPanel2(){
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0,1));
		err = new JTextArea();
		err.setBackground(Color.WHITE);
		err.setVisible(true);
		panel2.add(err);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == ok){
			err.setText("Hello");
		}else if(e.getActionCommand().equals("Cancel")){
			err.setText("bye");
		}
	}
	
	/**
	 * private insatnces
	 */
	private JPanel panel1, panel2;
	private JTextField name, salary, ot;
	private JButton ok, cancel;
	private JTextArea err;
	private JComboBox<String> industry;
}
