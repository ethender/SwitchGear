

import design.*;
import javax.swing.*;
import java.awt.*;


public class SwitchGearDatabase extends JFrame {
	
	
	/**
	 * Main program of Employment database
	 */
	public SwitchGearDatabase(){
		setTitle("SwitchGear Database");
		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		
		
		CreateProfile profile = new CreateProfile();
		CreateAttendance attendance = new CreateAttendance();
		CreateSalary salary = new CreateSalary();
		SearchQuery search = new SearchQuery();
		
		jtp.addTab("Create Employee", profile);
		jtp.addTab("Attendance", attendance);
		jtp.addTab("salary", salary);
		jtp.addTab("search database", search);
	}
	
	/**
	 * WARNING: DO NOT MODIFY
	 * run 
	 * @param args
	 */
	public static void main(String[] args){
		SwitchGearDatabase database = new SwitchGearDatabase();
		database.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		database.setSize(1000, 500);
		database.setVisible(true);
		
	}
}
