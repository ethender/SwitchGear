import javax.swing.*;

import java.awt.event.*;
import java.awt.*;



public class SwitchGear implements ActionListener{
	/**
	 * Main Method
	 * @param args
	 */
	public static void main(String[] args){
		SwitchGear start = new SwitchGear();
	}
	
	
	public SwitchGear(){
		designSwitchGear();
		
		create = new JButton("Create Profile");
		create.addActionListener(this);
		mainFrame.add(create);
	}
	
	/**
	 * initialise the Main Program
	 */
	private void designSwitchGear(){
		mainFrame = new JFrame("Switch Gear");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setSize(700, 700);
		
		
		
	}
	
	
	/**
	 * When You click on button This Will method implemented
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == create){
			Attendence profile = new Attendence();
			
		}
		
	}
	
	
	
	/**
	 * private Instances
	 */
	private JFrame mainFrame;
	private JButton create;
}