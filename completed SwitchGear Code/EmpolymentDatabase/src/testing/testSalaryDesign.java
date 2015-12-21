package testing;


import design.*;
import javax.swing.*;

public class testSalaryDesign {
	
	public static void main(String[] args){
		JFrame frame = new JFrame("salary design");
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CreateSalary salary = new CreateSalary();
		frame.add(salary);
		
		
		
	}
}