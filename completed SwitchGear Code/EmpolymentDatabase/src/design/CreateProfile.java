package design;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import background.*;

/**
 * Create the profile panel
 * @author ethender
 *
 */
public class CreateProfile extends JPanel implements ActionListener{
	
	/**
	 * this class for creating employeee
	 */
	private static final long serialVersionUID = 1;
	public CreateProfile(){
		createStructure();
		add(panel);
	}
	
	/**
	 * create structure and adds to frame
	 */
	private void createStructure(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(5,0));
		
		panel.add(createEmployeeName());
		panel.add(createJobDesignation());
		panel.add(createSalary());
		createIndustry();
		panel.add(industryName);
		panel.add(finalButtons());
	}
	
	/**
	 * create employee name with JLabel
	 * @return JPanel
	 */
	private JPanel createEmployeeName(){
	
				JPanel namePanel = new JPanel();
				namePanel.setLayout(new GridLayout(1,2));
				namePanel.add(new JLabel("Name: "));
				
				empName = new JTextField(30);
				namePanel.add(empName);
				
		return namePanel;
	}
	
	/**
	 * creates the jobdesignation
	 * @return JPanel
	 */
	private JPanel createJobDesignation(){
		JPanel jobPanel = new JPanel();
		jobPanel.setLayout(new GridLayout(1,2));
		jobPanel.add(new JLabel("JOB :"));
		
		jobName = new JTextField(30);
		jobPanel.add(jobName);
		return jobPanel;
	}
	
	/**
	 *  creates the salary
	 * @return JPanel
	 */
	private JPanel createSalary(){
		JPanel salaryPanel = new JPanel();
		salaryPanel.setLayout(new GridLayout(1,2));
		salaryPanel.add(new JLabel("Salary: "));
		
		salary = new JTextField(10);
		salaryPanel.add(salary);
		
		return salaryPanel;
	}
	
	/**
	 * creates industry
	 */
	private void createIndustry(){
		industryName = new JComboBox<String>();
		industryName.addItem("SwitchGear industry");
		industryName.addItem("Ashwini industry");
		industryName.setSelectedItem("SwitchGear industry");
	}
	

	/**
	 * Creates the control buttons
	 * @return JPanel
	 */
	private JPanel finalButtons(){
		JPanel finalise = new JPanel();
		finalise.setLayout(new GridLayout(1,2));
		
		create = new JButton("Create");
		create.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		finalise.add(create);
		finalise.add(cancel);
		
		return finalise;
		
	}
	
	/**
	 * performs the operations when one of the button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == create){
			name = empName.getText();
			jobDesignition = jobName.getText();
			industry = industryName.getSelectedItem().toString();
			empSalary = Double.parseDouble(salary.getText());
			
			oneDaySalary = empSalary/30; // divides by 30 days
			oneHourSalary = oneDaySalary/8; // divides by 8 hours
			
			//GetProfiles checkingProfile = new GetProfiles();
			SearchProfile search = new SearchProfile();
			
			
			boolean isProfileThere = search.checkName(name);
			
			if(!isProfileThere){
				ProfileTable profile = new ProfileTable(name,jobDesignition,industry,empSalary,oneDaySalary,oneHourSalary);
				JOptionPane.showMessageDialog(null, "profile created");
				System.out.println(name+" "+jobDesignition+" "+industry+" "+empSalary+" "+oneDaySalary+" "+oneHourSalary);
				System.out.println("inserted");
				
			}else{
				System.out.println("profile already there");
				
				JOptionPane.showMessageDialog(null, "profile already exist");
			}
			
			
		}else if(e.getSource() == cancel){
			empName.setText("");
			jobName.setText("");
			salary.setText("");
			System.out.println("Cancel");
			
		}
		
	}
	
	
	/**
	 * private instances
	 */
	
	private JPanel panel;
	private JTextField empName;
	private JTextField jobName;
	private JComboBox<String> industryName;
	private JTextField salary;
	private JButton create,cancel;
	
	//finalise getting
	
	private String name;
	private String jobDesignition;
	private String industry;
	private double empSalary;
	private double oneDaySalary;
	private double oneHourSalary;
	
	
}