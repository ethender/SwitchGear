/**
 * The purpose of this class to create emplyee profile
 */
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class CreateEmployeeProfile implements ActionListener{
	
	/**
	 * Creating employee profile
	 */
	public  CreateEmployeeProfile(){
		initialise();
	}
	
	/**
	 * initialising the frame and employee profile file
	 */
	private void initialise(){
		if(employeeProfile.exists()){
			getFileInfo(employeeProfile);
		}else {
			try{
				boolean s = employeeProfile.createNewFile();
			}catch(IOException ex){
				new ErrorPrompt().setText("Creating File Error");
			}
		}
		
		
		frame = new JFrame("Create Emp Profile");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400, 400);
		
		
		layout = new GridLayout(4,2);
		frame.setLayout(layout);
		
		
		frame.add(new JLabel("Name: "));
		name = new JTextField(20);
		frame.add(name);
		
		
		
		frame.add(new JLabel("Salary: "));
		salary = new JTextField(10);
		frame.add(salary);
		
		frame.add(new JLabel("Choose Industry"));
		industry = new JComboBox<String>();
		industry.addItem("SwitchGearIndustry");
		industry.addItem("AshwiniIndustry");
		
		industry.setEditable(false);
		industry.setSelectedItem("SwitchGearIndustry");
		frame.add(industry);
		
		
		ok = new JButton("OK");
		ok.addActionListener(this);
		frame.add(ok);
		
		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		frame.add(cancel);
	}
	
	
	/**
	 * when ok or cancel clicked this method get active
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == ok){
			try{
				String empName = name.getText().toString();
				String empSalary = salary.getText().toString();
				String workingIndustry = industry.getSelectedItem().toString();
				String oneDaySalary = convertSalary(salary.getText().toString());
				
				
				String combine = "["+empName+"]  ["+empSalary+"]  ["+workingIndustry+"]  ["+oneDaySalary+"]";
				storage.add(combine);
				
				
				BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
				
				for(int i = 0; i < storage.size(); i++){
					wr.write(storage.get(i));
					wr.newLine();
				}
				
				wr.close();
				
			}catch(IOException ex){
				ErrorPrompt prompt = new ErrorPrompt();
				prompt.setText(ex.getMessage());
				prompt.setText(prompt.NEW_LINE);
				prompt.setText("Error Creating employee profile");
			}
			
			frame.dispose();
		}else if(e.getSource() == cancel){
			frame.dispose();
		}
	}

	
	/**
	 * 
	 * @param file From this we get information from file and we add to storage 
	 */
	private void getFileInfo(File file){
		try{
			BufferedReader rd = new BufferedReader(new FileReader(file));
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				storage.add(line);
			}
			rd.close();
		}catch(IOException ex){
			ErrorPrompt prompt = new ErrorPrompt();
			prompt.setText(ex.getMessage());
			prompt.setText(prompt.NEW_LINE);
			prompt.setText("Retriving Error");
		}
		
	}
	
	private String convertSalary(String oneMonthSalary){
		int month = Integer.parseInt(oneMonthSalary);
		double oneDay = (double) month/30;
		
		return (Double.toString(oneDay));
	}
	
	
	/**
	 * private Instances
	 */
	String fileName = "employeeId.cre";
	private File employeeProfile = new File(fileName);
	private JFrame frame;
	private GridLayout layout;
	private JTextField name, salary;
	private JComboBox<String> industry;
	private JButton ok, cancel;
	private ArrayList<String> storage = new ArrayList<String>();
	
}

