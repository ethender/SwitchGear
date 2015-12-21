import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Advance implements ActionListener {
	

	public Advance(){
		checkOrCreateData();
		initialiseDesign();
		
	}
	
	private void checkOrCreateData(){
		File ad = new File("Advance.adv");
		if(!ad.exists()){
			try{
				boolean b = ad.createNewFile();
			}catch(IOException ex){
				ErrorPrompt error = new ErrorPrompt();
				error.setText(ex.getMessage());
				error.setText(error.NEW_LINE);
				error.setText("Advance file not created");
			}
		}
	}
	
	private void initialiseDesign(){
		initialiseFrame();
		initialiseCombo();
		initialiseAdvance();
		initialiseCut();
		initialiseBalance();
		initialiseFinalButton();
	}
	
	private void initialiseFrame(){
		frame = new JFrame("Advance");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		layout = new GridLayout(5,0);
		
		frame.setLayout(layout);
	}
	
	private void initialiseCombo(){
		name = new JComboBox<String>();
		name.addItem("Employee Name");
		try{
			BufferedReader rd = new BufferedReader(new FileReader("employeeId.cre"));
			
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				
				int employeeNameStart = line.indexOf("[")+1;
				int employeeNameEnd = line.indexOf("]");
				
				String albumName = line.substring(employeeNameStart, employeeNameEnd);
				name.addItem(albumName);
			}
			rd.close();
		}catch(IOException ex){
			new ErrorPrompt().setText(ex.getMessage()+"\n"+" Error in Employee profile reading");
		}
		
		
		name.setEditable(false);
		name.setSelectedItem("Employee Name");
		frame.add(name);
		name.addActionListener(this);
	}
	
	
	private void initialiseAdvance(){
		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(1,2);
		
		panel.setLayout(layout);
		panel.add(new JLabel("Advance Amount : "));
		
		adv = new JTextField(20);
		panel.add(adv);
		
		frame.add(panel);
	}
	
	
	private void initialiseCut(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		panel.add(new JLabel("Amount Per Month: "));
		month = new JTextField(20);
		panel.add(month);
		
		frame.add(panel);
	}
	
	private void initialiseBalance(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		panel.add(new JLabel("Remaning Amount: "));
		
		balance = new JTextField(20);
		panel.add(balance);
		
		frame.add(panel);
	}
	
	private void initialiseFinalButton(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		
		ok = new JButton("OK");
		panel.add(ok);
		ok.addActionListener(this);
		
		cancel = new JButton("Cancel");
		panel.add(cancel);
		cancel.addActionListener(this);
		
		frame.add(panel);
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == name){
			if(checkExists(name.getSelectedItem().toString())){
				balance.setText("works");
			}
		}
	}

	private boolean checkExists(String name){
		boolean result = false;
		try{
			BufferedReader rd = new BufferedReader(new FileReader("Advance.adv"));
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				
				int start = line.indexOf("[")+1;
				int end = line.indexOf("]");
				
				String empName = line.substring(start, end);
				if(empName.equals(name)){
					result = true;
				}
			}
			rd.close();
		}catch(IOException ex){
			ErrorPrompt error = new ErrorPrompt();
			error.setText(ex.getMessage());
			error.setText(error.NEW_LINE);
			error.setText("Error in checking name of Employee check \"Advance.adv\" ");
		}
		
		
		return result;
	}
	
	/**
	 * private instances
	 */
	private JFrame frame;
	private GridLayout layout;
	private JComboBox<String> name;
	private  JTextField adv, month, balance;
	private JButton ok, cancel;
}