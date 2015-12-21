package code;

import javax.swing.*;

public class BufferCreateEmployee {
	
	
	public BufferCreateEmployee(String name, int salary,int salaryPerHour, int otPerHour, String industry){
		empName = name;
		empSalary = salary;
		empSalaryPerHour = salaryPerHour;
		empOt = otPerHour;
		empIndustry = industry;
		
		String[] columnNames = {
			"Name","Salary","Salary/Hour","OT/Hour","industry"	
		};
		
		
		Object[][] rawData = {
				{ empName, empSalary, empSalaryPerHour,empOt,empIndustry}	
		};
		
		
		JTable table = new JTable(rawData,columnNames);
	}
	
	/**
	 * private instances
	 */

	private String empName;
	private int empSalary;
	private int empSalaryPerHour;
	private int empOt;
	private String empIndustry;
}