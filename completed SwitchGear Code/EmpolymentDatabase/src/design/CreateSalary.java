package design;


import background.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.table.*;


/**
 * create the salary payment for employees
 * @author ethender
 *
 */
public class CreateSalary extends JPanel implements ActionListener{
	
	
	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 3;

	/**
	 * create salary
	 */
	public CreateSalary(){
		createStructure();
		add(panel);
	}
	
	/**
	 * create structure and adds to panel
	 */
	
	private void createStructure(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,0));
		
		getProfiles();
		panel.add(employees);
		panel.add(addCalendar());
		panel.add(addControls());
	}
	
	
	/**
	 * get Employees profiles
	 */
	private void getProfiles(){
		GetProfiles pro = new GetProfiles();
		profiles = pro.getResults();
		
		employees = new JComboBox<String>();
		employees.addItem("-");
		Iterator<Profile> it = profiles.iterator();
		while(it.hasNext()){
			Profile temp = (Profile) it.next();
			employees.addItem(temp.getEmployeeName());
		}
		employees.setSelectedItem("-");
		
	}
	
	/**
	 * get Months
	 */
	private void getMonths(){
		months = new JComboBox<String>();
		months.addItem("Select Month");
		months.setSelectedItem("Select Month");
		
		months.addItem("JANUARY");
		months.addItem("FEBRUARY");
		months.addItem("MARCH");
		months.addItem("APRIL");
		months.addItem("MAY");
		months.addItem("JUNE");
		months.addItem("JULY");
		months.addItem("AUGUST");
		months.addItem("SEPTEMBER");
		months.addItem("OCTOBER");
		months.addItem("NOVEMBER");
		months.addItem("DECEMBER");
	}
	
	/**
	 * gets year
	 */
	private void getYear(){
		year = new JComboBox<Integer>();
		
		for(int i = 1990; i <= 2045; i++){
			year.addItem(new Integer(i));
		}
		year.setSelectedItem(new Integer(1990));
	}
	
	/**
	 * get months and year combobox
	 * @return JPanel
	 */
	private JPanel addCalendar(){
		JPanel calendarPanel = new JPanel();
		panel.setLayout(new GridLayout(0,2));
		
		getMonths();
		getYear();
		panel.add(months);
		panel.add(year);
		
		return calendarPanel;
	}
	
	/**
	 * add control buttons
	 * @return JPanel
	 */
	private JPanel addControls(){
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(0,2));
		
		ok = new JButton("Show");
		ok.addActionListener(this);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		
		controlPanel.add(ok);
		controlPanel.add(cancel);
		
		
		return controlPanel;
	}
	
	/**
	 * performs opertion when one the buttons is clicked
	 */
	public void actionPerformed(ActionEvent e){
	
		if(e.getSource() == ok){
			String name = employees.getSelectedItem().toString();
			
			
				String month = months.getSelectedItem().toString();
				int selectYear = (int) year.getSelectedItem();
			
				System.out.println(name+" "+month+" "+selectYear);
			
				Profile profile = getSelectedProfile(name);
				GetAttendence attend = new GetAttendence();
				ArrayList<Attendence> attends = attend.getAttendenceByNameAndMonthAndYear(profile.getEmployeeName(), month, selectYear);
			
				System.out.println(profile.getEmployeeId()+" "+profile.getEmployeeName()+" "+profile.getEmployeeSalary());
			
				if(!attends.isEmpty()){
				
					totalWorkingHoursRegular = getWorkedHoursOfTheMonth(attends);
					totalOtHours = getotHoursOfTheMonth(attends);
					totalWorkedHours = totalWorkingHoursRegular + totalOtHours;
					totalWorkingHoursRegularAmount = getWorkedHoursOfTheMonthAmount(attends);
					totalOtHoursAmount = getotHoursOfTheMonthAmount(attends);
					totalAmountOfTheMonth = getTotalAmountOfTheMonth(attends);
				
					checkAndPrint(profile,attends);
					String totals = " "+profile.getEmployeeName()+"\n Regular Working Amount : "+totalWorkingHoursRegular+"\n ot hours: "+totalOtHours+"\n total Hours: "+totalWorkedHours+"\n regular Hours amount: "+totalWorkingHoursRegularAmount+"\n ot hours amount: "+totalOtHoursAmount+"\n total amount: "+ totalAmountOfTheMonth;
					System.out.println(totals);
			
				}else {
					JOptionPane.showMessageDialog(null, "Database can`t find the records");
				}
			
			
		}else if(e.getSource() == cancel){
			JOptionPane.showMessageDialog(null, "cancel pressed");
		}
		
	}
	
	/**
	 * checks the name & gives the employee profile
	 * @param name
	 * @return Profile
	 */
	private Profile getSelectedProfile(String name){
		Profile profile = null;
		for(int i = 0; i < profiles.size(); i++){
			Profile temp = profiles.get(i);
			if(temp.getEmployeeName().equals(name)){
				System.out.println("Profile found");
				profile = temp;
			}else{
				System.out.println("Profile not found");
			}
		}
		
		if(profile != null){
			System.out.println(profile.getEmployeeId());
		}else{
			System.out.println("no employee id");
		}
		
		return profile;
	}
	
	
	/**
	 * get Total Worked regular hours of the month
	 * @param attendance
	 * @return int 
	 */
	private int getWorkedHoursOfTheMonth(ArrayList<Attendence> attendance){
		Iterator<Attendence> it = attendance.iterator();
		int result = 0;
		
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			result = result + temp.getWorkingHours();
		}
		return result;
	}
	
	/**
	 * gets the total ot hours of the month
	 * @param attendance
	 * @return int 
	 */
	private int getotHoursOfTheMonth(ArrayList<Attendence> attendance){
		Iterator<Attendence> it = attendance.iterator();
		int result = 0;
		
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			result = result + temp.getOtHours();
		}
		return result;
	}
	
	/**
	 * gets the total regular working hours amount
	 * @param attendance
	 * @return double
	 */
	private double getWorkedHoursOfTheMonthAmount(ArrayList<Attendence> attendance){
		Iterator<Attendence> it = attendance.iterator();
		double result = 0;
		
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			result = result + temp.getWorkingHoursAmount();
		}
		return result;
	}
	
	/**
	 * get total ot hours amount of the month
	 * @param attendance
	 * @return double
	 */
	private double getotHoursOfTheMonthAmount(ArrayList<Attendence> attendance){
		Iterator<Attendence> it = attendance.iterator();
		double result = 0;
		
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			result = result + temp.getOtHoursAmount();
		}
		return result;
	}
	
	/**
	 * get the total amount of the month
	 * @param attendance
	 * @return double
	 */
	private double getTotalAmountOfTheMonth(ArrayList<Attendence> attendance){
		Iterator<Attendence> it = attendance.iterator();
		double result = 0;
		
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			result = result + temp.getTotalAmountOfTheDay();
		}
		return result;
	}
	
	private void checkAndPrint(Profile profile, ArrayList<Attendence> attends){
		if(profile != null){
			
			if(!attends.isEmpty()){
				getSalaryController(attends,profile);
			}else{
				JOptionPane.showMessageDialog(null, "Sorry no attendance found in our database");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Sorry employee not found");
		}
	}
	
	/**
	 * salary table and results
	 * @param attends
	 * @param profile
	 */
	private void getSalaryController(ArrayList<Attendence> attends, Profile profile){
		JFrame salary = new JFrame("Salary");
		salary.setSize(1000, 1000);
		salary.setVisible(true);
		salary.setBackground(Color.gray);
		salary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel salaryPanel = new JPanel();
		salaryPanel.setLayout(new BorderLayout());
		salary.getContentPane().add(salaryPanel);
		
		Iterator<Attendence> it = attends.iterator();
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
		
		model.addColumn("employee id");
		model.addColumn("employee name");
		model.addColumn("date");
		model.addColumn("Month");
		model.addColumn("year");
		model.addColumn("Regular Working Hours");
		model.addColumn("ot working Hours");
		model.addColumn("regular workingHours Amount");
		model.addColumn("otHours Amount");
		model.addColumn("Total Amount");
		
		int dayCount = 0;
		while(it.hasNext()){
			Attendence temp = (Attendence)it.next();
			dayCount++;
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
		
		model.addRow(new Object[]{
				new Integer(profile.getEmployeeId()),
				profile.getEmployeeName(),
				new Integer(dayCount),
				months.getSelectedItem().toString(),
				new Integer((int) year.getSelectedItem()),
				new Integer(totalWorkingHoursRegular),
				new Integer(totalOtHours),
				new Double(totalWorkingHoursRegularAmount),
				new Double(totalOtHoursAmount),
				new Double(totalAmountOfTheMonth)
		});
		JScrollPane scroll = new JScrollPane(table);
		salaryPanel.add(scroll,BorderLayout.CENTER);
		
	}
	
	
	
	
	private JPanel panel;
	private ArrayList<Profile> profiles;
	private JComboBox<String> employees;
	private JComboBox<String> months;
	private JComboBox<Integer> year;
	
	private JButton ok,cancel;
	private int totalWorkingHoursRegular,totalOtHours,totalWorkedHours;
	private double totalWorkingHoursRegularAmount, totalOtHoursAmount, totalAmountOfTheMonth;
}