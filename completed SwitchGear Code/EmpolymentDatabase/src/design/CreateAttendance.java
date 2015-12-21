package design;

import background.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.awt.event.*;
import javax.swing.table.*;

/**
 * creates the attendence of the employee 
 * @author ethender
 *
 */

public class CreateAttendance extends JPanel implements ActionListener{
	
	/**
	 * @author ethender
	 */
	private static final long serialVersionUID = 2;

	/**
	 * create attendance for the employee
	 */
	public CreateAttendance(){
		getDates();
		createStructure();
		add(panel);
	}
	
	
	
	
	
	/**
	 * gets the date , month , year
	 */
	private void getDates(){
		
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		day = localDate.getDayOfMonth();
		month = getMonth(localDate.getMonthValue());
		year = localDate.getYear();	
		
	}
	
	/**
	 * return month name
	 * @param month
	 * @return String 
	 */
	private String getMonth(int month){
		switch(month){
		case 1:
			return "JANUARY";
		case 2:
			return "FEBRUARY";
		case 3:
			return "MARCH";
		case 4:
			return "APRIL";
		case 5:
			return "MAY";
		case 6:
			return "JUNE";
		case 7:
			return "JULY";
		case 8:
			return "AUGUST";
		case 9:
			return "SEPTEMBER";
		case 10:
			return "OCTOBER";
		case 11:
			return "NOVEMBER";
		case 12:
			return "DECEMBER";
		default:
			return "";
		}
		
	}
	
	/**
	 * creates the structure and adds to panel
	 */

	private void createStructure(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,0));
		
		getEmployeeDetails();
		panel.add(employees);
		
		panel.add(showCalendar());
		panel.add(getNormalHours());
		panel.add(getOTHours());
		panel.add(getSubmitControls());
		
		showAttendance = new JButton("Show Attendance");
		showAttendance.addActionListener(this);
		panel.add(showAttendance);
	}
	

	/**
	 * gets the employee details
	 */
	private void getEmployeeDetails(){
		employees = new JComboBox<String>();
		employees.addItem("-");
		employees.setSelectedItem("-");
		
		GetProfiles profiles = new GetProfiles();
		employeeProfiles = profiles.getResults();
		
		for(int i = 0; i < employeeProfiles.size(); i++){
			employees.addItem(employeeProfiles.get(i).getEmployeeName());
		}
	}
	
	/**
	 *  shows the calendar
	 * @return JPanel
	 */
	private JPanel showCalendar(){
		JPanel calendarPanel = new JPanel();
		
		calendarPanel.add(new JLabel("Date: "+day+" Month: "+month+" Year: "+year));
		
		return calendarPanel;
		
	}
	
	/**
	 *  getting normal hours working of the employee
	 * @return JPanel
	 */
	private JPanel getNormalHours(){
		
		JPanel normalHoursPanel = new JPanel();
		normalHoursPanel.setLayout(new GridLayout(0,2));
		
		normalHours = new JTextField(10);
		normalHoursPanel.add(new JLabel("Normal Hours: "));
		normalHoursPanel.add(normalHours);
		
		
		return normalHoursPanel;
	}
	
	/**
	 * getting ot hours working of the employee
	 * @return JPanel
	 */
	private JPanel getOTHours(){
		JPanel otPanel = new JPanel();
		otPanel.setLayout(new GridLayout(0,2));
		
		otPanel.add(new JLabel("OT Hours: "));
		otHours = new JTextField(10);
		otPanel.add(otHours);
		
		return otPanel;
	}
	
	/**
	 * control  buttons
	 * @return JPanel
	 */
	private JPanel getSubmitControls(){
		JPanel submitControl = new JPanel();
		submitControl.setLayout(new GridLayout(0,2));
		
		ok = new JButton("Enter");
		ok.addActionListener(this);
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		submitControl.add(ok);
		submitControl.add(cancel);
		
		return submitControl;
	}
	
	/**
	 * perform operations when one of the  button is clicked
	 */
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == ok){
			
		String name = employees.getSelectedItem().toString();
		int workingHours = Integer.parseInt(normalHours.getText());
		int otWorkingHours = Integer.parseInt(otHours.getText());
		
		Profile employee = checkTheProfile(name);
		
		double workingHoursAmount = employee.getEmployeeHourSalary() * workingHours;
		double otWorkingHourAmount = employee.getEmployeeHourSalary() * otWorkingHours;
		double totalAmount = workingHoursAmount + otWorkingHourAmount;
		
		Attendence attend = new Attendence(employee.getEmployeeId(),name,day,month,year,workingHours,otWorkingHours,workingHoursAmount,otWorkingHourAmount,totalAmount);
		AttendenceInsertMysql sql = new AttendenceInsertMysql(attend);
		
		
		System.out.println("name: "+name+"\n working hours: "+workingHours+"\n ot hours: "+otWorkingHours);
		System.out.println(day+" "+month+" "+year);
		System.out.println("Working Hours Amount: "+workingHoursAmount);
		System.out.println("Ot Working hours Amount: "+ otWorkingHourAmount);
		System.out.println("Total Amount: "+totalAmount);
		
		// checkAttend(attend); // working
		}else if(e.getSource() == cancel){
			
			//resetting everything 
			employees.setSelectedItem("-");
			normalHours.setText("");
			otHours.setText("");
		}else if(e.getSource() == showAttendance){
			controller();
		}
		
	}
	
	/**
	 * When employee name is selected it gives  employee profile
	 * @param name
	 * @return Profile
	 */
	private Profile checkTheProfile(String name){
		Profile profile = null;
		for(int i = 0; i < employeeProfiles.size(); i++){
			Profile temp = employeeProfiles.get(i);
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
	 * show attendance is clicked
	 */
	private void controller(){
		JFrame attendance = new JFrame("Show attendnace");
		attendance.setSize(1000, 1000);
		attendance.setVisible(true);
		attendance.setBackground(Color.gray);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		attendance.getContentPane().add(panel);
		
		
		GetAttendence attend = new GetAttendence();
		
		ArrayList<Attendence> dayAttendance = attend.getAttendenceByDateAndMonthAndYear(day, month, year);
		
		Iterator<Attendence> it = dayAttendance.iterator();
		
		DefaultTableModel model = new DefaultTableModel();
		JTable table = new JTable(model);
			
		//information
		model.addColumn("employee id");
		model.addColumn("Employee Name");
		model.addColumn("Date");
		model.addColumn("Month");
		model.addColumn("Year");
		model.addColumn("Normal Hours");
		model.addColumn("Ot Hours");
		model.addColumn("Normal Working Amount");
		model.addColumn("Ot Working Amount");
		model.addColumn("Total Amount Day");
		
		
		while(it.hasNext()){
			Attendence temp = it.next();
			model.addRow(new Object[]{new Integer(temp.getEmployeeId()),
					temp.getEmployeeName(),
					new Integer(temp.getDate()),
					temp.getMonth(),
					new Integer(temp.getYear()),
					new Integer(temp.getWorkingHours()),
					new Integer(temp.getOtHours()),
					new Double(temp.getWorkingHoursAmount()),
					new Double(temp.getOtHoursAmount()),
					new Double(temp.getTotalAmountOfTheDay())});
		}
		
		JScrollPane scroll  = new JScrollPane(table);
		panel.add(scroll,BorderLayout.CENTER);
	}
	
	
	
	

	
	/**
	 * private instances
	 */
	
	private JPanel panel;
	private JComboBox<String> employees;
	private ArrayList<Profile> employeeProfiles = new ArrayList<Profile>();
	private int day;
	private int year;
	private String month;
	private JTextField normalHours;
	private JTextField otHours;
	private JButton ok,cancel;
	private JButton showAttendance;
}