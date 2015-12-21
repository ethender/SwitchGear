package testing;

import javax.swing.*;
import design.*;


public class testingAttendanceDesign {
	public static void main(String[] args){
		JFrame frame = new JFrame("Attendance");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		
		CreateAttendance attend = new CreateAttendance();
		
		frame.add(attend);
	}
}