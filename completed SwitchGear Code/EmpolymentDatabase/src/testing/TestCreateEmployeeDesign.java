package testing;

import design.CreateProfile;
import javax.swing.*;

public class TestCreateEmployeeDesign {

	public static void main(String[] args){
		JFrame frame = new JFrame("Create employee");
		frame.setVisible(true);
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CreateProfile profile = new CreateProfile();
		
		frame.add(profile);
	}
}
