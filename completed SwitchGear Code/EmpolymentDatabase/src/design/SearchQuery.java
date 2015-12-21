package design;

import background.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;

/**
 * searches and gives employee attendance database
 * @author ethender
 *
 */
public class SearchQuery extends JPanel{
	
	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 4;
	
	/**
	 * intialise
	 */
	public SearchQuery(){
		getProfiles();
		getMonths();
		getYear();
		createStructure();
		add(panel);
	}
	
	/**
	 * gets the profiles
	 */
	private void getProfiles(){
		GetProfiles pro = new GetProfiles();
		profiles = pro.getResults();
	}
	
	/**
	 * gets the months
	 * @return ArrayList<String>
	 */
	private ArrayList<String> getMonths(){
	
		ArrayList<String> months = new ArrayList<String>();
		
		months.add("JANUARY");
		months.add("FEBRUARY");
		months.add("MARCH");
		months.add("APRIL");
		months.add("MAY");
		months.add("JUNE");
		months.add("JULY");
		months.add("AUGUST");
		months.add("SEPTEMBER");
		months.add("OCTOBER");
		months.add("NOVEMBER");
		months.add("DECEMBER");
		
		return months;
	}
	
	/**
	 * gets the year starts from 1990 - 2045
	 * @return ArrayList<Intger>
	 */
	private ArrayList<Integer> getYear(){
		ArrayList<Integer> year = new ArrayList<Integer>();
		
		for(int i = 1990;i <= 2045; i++){
			year.add(new Integer(i));
		}
		
		return year;
	}
	
	/**
	 * if we give the name it return the profile of employee
	 * @param name
	 * @return Profile
	 */
	private Profile getSelectedProfile(String name){
		Profile result = null;
		Iterator<Profile> it = profiles.iterator();
		while(it.hasNext()){
			Profile temp = (Profile)it.next();
			if(temp.getEmployeeName().equals(name)){
				result = temp;
			}
		}
		
		return result;
	}
	
	/**
	 * creates the main structure
	 */
	private void createStructure(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,0));
		
		panel.add(nameSearchDesign());
		panel.add(searchByNameAndYear());
		panel.add(searchByMonthAndYear());
		panel.add(searchByYear());
	}
	
	/**
	 * if we pass attendance it frames and shows the attendance of the employee
	 * @param attends
	 */
	private void getAttendanceTable(ArrayList<Attendence> attends){
		JFrame frame = new JFrame("Employee Attendance");
		frame.setSize(1000, 1000);
		frame.setVisible(true);
		frame.setBackground(Color.gray);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());
		frame.getContentPane().add(tablePanel);
		
		
		Iterator<Attendence> it = attends.iterator();
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		
		
		model.addColumn("employee id");
		model.addColumn("employee name");
		model.addColumn("date");
		model.addColumn("month");
		model.addColumn("year");
		model.addColumn("Regular working hours");
		model.addColumn("ot hours");
		model.addColumn("regular hours amount");
		model.addColumn("ot hours amount");
		model.addColumn("total Amount");
		
		
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			model.addRow(new Object[]{
					new Integer(temp.getEmployeeId()),
					temp.getEmployeeName(),
					new Integer(temp.getDate()),
					temp.getMonth(),
					new Integer(temp.getYear()),
					new Integer(temp.getWorkingHours()),
					new Integer(temp.getOtHours()),
					new Double(temp.getWorkingHoursAmount()),
					new Double(temp.getOtHoursAmount()),
					new Double(temp.getTotalAmountOfTheDay())
			});
		}
		JScrollPane scroll = new JScrollPane(table);
		tablePanel.add(scroll, BorderLayout.CENTER);
	}
	
	
	/**
	 * Search by name
	 * @return JPanel
	 */
	private JPanel nameSearchDesign(){
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new GridLayout(0,2));
		
		JComboBox<String>employees = new JComboBox<String>();
		employees.addItem("Select Name");
		employees.setSelectedItem("Select Name");
		Iterator<Profile> it = profiles.iterator();
		
		while(it.hasNext()){
			Profile temp = (Profile)it.next();
			employees.addItem(temp.getEmployeeName());
		}
		
		namePanel.add(employees);
		 JButton searchByName = new JButton("Search");
		searchByName.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent e) {
				Profile profile = getSelectedProfile(employees.getSelectedItem().toString());
				if(profile != null){
					GetAttendence att = new GetAttendence();
					ArrayList<Attendence> attends = att.getAttendenceByName(profile.getEmployeeName());
					getAttendanceTable(attends);
				}else{
					JOptionPane.showMessageDialog(null, "You have not selected any name");
				}
			}
			
		});
		namePanel.add(searchByName);
		
		return namePanel;
	}
	
	
	

	

	
	
	
	
	/**
	 * searches by name and year
	 * @return JPanel
	 */
	private JPanel searchByNameAndYear(){
		JPanel nay = new JPanel();
		nay.setLayout(new GridLayout(0,3));
	
		JComboBox<String>employees = new JComboBox<String>();
		employees.addItem("Select Name");
		employees.setSelectedItem("Select Name");
		Iterator<Profile> nameIt = profiles.iterator();
		
		while(nameIt.hasNext()){
			Profile temp = (Profile)nameIt.next();
			employees.addItem(temp.getEmployeeName());
		}
		
		nay.add(employees);
		
		
		JComboBox<Integer> year = new JComboBox<Integer>();
		ArrayList<Integer> temps = getYear();
		Iterator<Integer> yearIt = temps.iterator();
		while(yearIt.hasNext()){
			year.addItem(yearIt.next());
		}
		
		year.setSelectedItem(2015);
		nay.add(year);
		
		JButton search = new JButton("search");
		search.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent e) {
				String selectName = employees.getSelectedItem().toString();
				int selectYear = (int)year.getSelectedItem();
				
				GetAttendence get = new GetAttendence();
				ArrayList<Attendence> attends = get.getAttendenceByNameAndYear(selectName, selectYear);
				if(!attends.isEmpty()){
					getAttendanceTable(attends);
				}else{
					JOptionPane.showMessageDialog(null, "sorry name with  year is not in our database");
				}
			}

		});
		
		nay.add(search);
		return nay;
	}
	
	
	
	/**
	 * searches by month and year
	 * @return JPanel
	 */
	
	private JPanel searchByMonthAndYear(){
		JPanel may = new JPanel();
		may.setLayout(new GridLayout(0,3));
		
		JComboBox<String>months = new JComboBox<String>();
		ArrayList<String> temps = getMonths();
		for(int i = 0; i < temps.size(); i++){
			months.addItem(temps.get(i));
		}
		may.add(months);
		
		JComboBox<Integer> year = new JComboBox<Integer>();
		ArrayList<Integer>temps2 = getYear();
		
		for(int j = 0; j < temps2.size(); j++){
			year.addItem(temps2.get(j));
		}
		year.setSelectedItem(2015);
		may.add(year);
		
		JButton search = new JButton("search");
		search.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent e) {
				String selectMonth = months.getSelectedItem().toString();
				int selectYear = (int)year.getSelectedItem();
				GetAttendence get = new GetAttendence();
				ArrayList<Attendence> attends = get.getAttendenceByMonthAndYear(selectMonth, selectYear);
				
				if(!attends.isEmpty()){
					getAttendanceTable(attends);
				}else{
					JOptionPane.showMessageDialog(null, "Sorry This month and year database is empty");
				}
			}
			
		});
		may.add(search);
		return may;
	}
	
	/**
	 * seraches by year
	 * @return JPanel
	 */
	
	private JPanel searchByYear(){
		JPanel sby = new JPanel();
		sby.setLayout(new GridLayout(0,2));
		
		ArrayList<Integer> temp = getYear();
		JComboBox<Integer> year = new JComboBox<Integer>();
		for(int i = 0; i < temp.size(); i++){
			year.addItem(temp.get(i));
		}
		year.setSelectedItem(2015);
		sby.add(year);
		
		JButton search = new JButton("search");
		search.addActionListener(new ActionListener(){

		
			public void actionPerformed(ActionEvent e) {
				int selectYear = (int) year.getSelectedItem();
				GetAttendence get = new GetAttendence();
				ArrayList<Attendence> attends = get.getAttendenceByYear(selectYear);
				if(!attends.isEmpty()){
					getAttendanceTable(attends);
				}else{
					JOptionPane.showMessageDialog(null, "Selected Year Attendence is not in our database");
				}
			}
			
		});
		
		sby.add(search);
		
		return sby;
	}
	
	
	
	/**
	 * private instances
	 */
	private JPanel panel;
	private ArrayList<Profile> profiles;
}


