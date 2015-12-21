package code;

import java.util.*;
import java.io.*;

import javax.swing.*;

public class EmployeeProfile {
	
	/**
	 * constructor 
	 * @param empName
	 * @param empSalary
	 * @param empOtHour
	 * @param empIndustry
	 */
	public EmployeeProfile(String empName, int empSalary,int  empOtHour, String empIndustry){
		name = empName;
		salary = empSalary;
		ot = empOtHour;
		industry = empIndustry;
		
		
		
	}
	
	/**
	 * Generates key for this employee
	 * @return
	 */
	public String generate(){
		String result = null;
		KeyGenerator key = new KeyGenerator(name);
		
		ArrayList<String> isThere = key.getEmployeesName();
		boolean found = isThere.contains(name);
		
		if(!found){
			key.init();
			HashMap<String, String> getKey = key.getEmployee_Key();
			String value = getKey.get(name);
			result = "Id created: "+value;
			
			String [] columnNames = {
					"ID", "Name","Salary","Ot/Hour","Industry"
			};
			
			Object[][] profile = {
					{value,name,salary,ot,industry}	
			};
			
			
			JTable table = new JTable(profile, columnNames);
			writeData(table,value);
			
		}else{
			result = "Name is already there";
		}
		
		
		return result;
	}
	
	/**
	 * This function either returns object == String (or) JTable
	 * @param key
	 * @return String or JTable
	 */
	public Object getDetails(String key){
		KeyGenerator generator = new KeyGenerator();
		HashMap<String, String> getKey = generator.getEmployee_Key();
		boolean found  = false;
		
		ArrayList<String> names = generator.getEmployeesName();
		for(int i = 0; i < names.size(); i++){
			String objKey = getKey.get(names.get(i));
			if(objKey.equals(key)){
				found = true;
			}
		}
		
		if(found){
			JTable details = getTable(key);
			return details;
		}else{
			String ntfound = "NotFound";
			return ntfound;
		}
	}
	
	/**
	 * If key found it gets the details 
	 * @param key
	 * @return JTable
	 */
	private JTable getTable(String key){
		JTable table = null;
		
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(key+"_Details.sce"));
			table = (JTable) in.readObject();
			in.close();
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}catch(ClassNotFoundException ey){
			System.out.println(ey.getMessage());
		}
		
		return table;
	}
	
	/**
	 * Writes the object to the file
	 * @param table
	 * @param value
	 */
	private void writeData(JTable table, String value){
		try{
			ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(value+"_Details.sce"));
			obj.writeObject(table);
			obj.close();
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
	
	/**
	 * private instances
	 */
	private String name, industry;
	private int salary, ot;
}