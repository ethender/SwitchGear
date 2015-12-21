import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;


public class Attendence implements ActionListener{
	
	/**
	 * class 
	 */
	public Attendence(){
		initDesign();
	}
	
	/**
	 * Designing
	 */
	private void initDesign(){
		initFrame();
		initLayout();
		initInternalDesign();
	}
	
	/**
	 * InitialFrame
	 */
	private void initFrame(){
		frame = new JFrame("Attendence");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(400, 400);
	}
	
	/**
	 * initialise layout
	 */
	private void initLayout(){
		layout = new GridLayout(4,1);
		frame.setLayout(layout);
	}
	
	/**
	 * Initialise initernal design
	 */
	private void initInternalDesign(){
		initCombo();
		initDate();
		initWork();
		initButtons();
	}
	
	/**
	 * deisgning employee name
	 */
	private void initCombo(){
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
	}
	
	/**
	 * designing date format
	 */
	private void initDate(){
		JPanel datePanel = new JPanel();
		datePanel.setLayout(new GridLayout(0,2));
		datePanel.add(new JLabel("Date"));
		date = new JTextField(20);
		datePanel.add(date);
		
		frame.add(datePanel);
	}
	
	
	/**
	 * desigining present and ot hours
	 */
	private void initWork(){
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(0,2));
		
		JPanel subPanel1 = new JPanel();
		subPanel1.setLayout(new GridLayout(0,1));
		JPanel subPanel2 = new JPanel();
		subPanel2.setLayout(new GridLayout(0,2));
		
		attend = new JComboBox<String>();
		attend.addItem("Present");
		attend.addItem("Absent");
		attend.setSelectedItem("Absent");
		subPanel1.add(attend);
		
		subPanel2.add(new JLabel("OT Hour: "));
		ot = new JTextField(20);
		subPanel2.add(ot);
		
		mainPanel.add(subPanel1);
		mainPanel.add(subPanel2);
		
		
		frame.add(mainPanel);
	}
	
	
	/**
	 * designing ok and cancel buttons
	 */
	private void initButtons(){
		JPanel task = new JPanel();
		task.setLayout(new GridLayout(0,2));
		
		ok = new JButton("Ok");
		ok.addActionListener(this);
		task.add(ok);

		cancel = new JButton("Cancel");
		cancel.addActionListener(this);
		task.add(cancel);
		
		frame.add(task);
	}
	// ---------------------------------------------------------------------------------------
	
	/**
	 * internal coding starts here
	 * DO NOT Change without knowing
	 */
	
	/**
	 * works when ok and cancel button pressed
	 */
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == ok){
			File f = checkFile();
			reStoreFile(f);
			addInfo(f);
			writeFile(f);
			frame.dispose();
		}else if(e.getSource() == cancel){
			frame.dispose();
		}
	}
	
	
	/**
	 * checking file if it`s not there then it will create and returns file 
	 * if file found it simple returns
	 * @return file
	 */
	private File checkFile(){
		File attendence = new File(getFile());
		if(!attendence.exists()){
			try{
				boolean a = attendence.createNewFile();
			}catch(IOException ex){
				ErrorPrompt error = new ErrorPrompt();
				error.setText(ex.getMessage());
				error.setText(error.NEW_LINE);
				error.setText("Attendence creating Error");
			}
		}
		
		return attendence;
	}
	
	/**
	 * setting filename
	 * @return monthyear base name
	 */
	private String getFile(){
		Calendar cal = Calendar.getInstance();
		int i = cal.get(Calendar.MONTH);
		String month = getMonth(i);
		int j = cal.get(Calendar.YEAR);
		String year = String.valueOf(j);
		
		String result = month+year;
		
		return result;
	}
	
	/**
	 * 
	 * @param month gets in integer format
	 * @return month returns in  string format
	 */
	private String getMonth(int month){
		String result = "";
		switch(month){
		case 0:
			result = "January";
			break;
		case 1:
			result = "February";
			break;
		case 2:
			result = "March";
			break;
		case 3:
			result = "April";
			break;
		case 4: 
			result = "May";
			break;
		case 5:
			result = "June";
			break;
		case 6:
			result = "July";
			break;
		case 7:
			result = "August";
			break;
		case 8:
			result = "September";
			break;
		case 9:
			result = "October";
			break;
		case 10:
			result = "November";
			break;
		case 11:
			result = "December";
			break;
		default :
			result = "Invalid";
			break;
		}
		
		return result;
	}
	
	
	/**
	 * 
	 * @param file Getting file information and adding to our storage
	 */
	private void reStoreFile(File file){
		try{
			BufferedReader rd = new BufferedReader(new FileReader(file));
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				storage.add(line);
			}
			
			rd.close();
		}catch(IOException ex){
			ErrorPrompt error = new ErrorPrompt();
			error.setText(ex.getMessage());
			error.setText(error.NEW_LINE);
			error.setText("File restoring error");
		}
	}
	
	
	/**
	 * getting form current attenddence
	 * @param file
	 */
	private void addInfo(File file){
		String empName = name.getSelectedItem().toString();
		String presentDate = date.getText().toString();
		String empPresent = attend.getSelectedItem().toString();
		String otHour = ot.getText().toString();
		
		String result = empName+" "+presentDate+" "+empPresent+" "+otHour;
		
		storage.add(result);
	}
	
	/**
	 * 
	 * @param f It takes file 
	 * Finally we write into attendence file
	 * 
	 */
	private void writeFile(File f){
		try{
			BufferedWriter wr = new BufferedWriter(new FileWriter(f));
			
			for(int i = 0; i < storage.size(); i++){
				wr.write(storage.get(i));
			}
			wr.close();
		}catch(IOException ex){
			ErrorPrompt error = new ErrorPrompt();
			error.setText(ex.getMessage());
			error.setText(error.NEW_LINE);
			error.setText("Attendence: Error in writing file");
		}
	}
	
	
	
	/**
	 * private instances
	 */
	private JFrame frame;
	private GridLayout layout;
	private JComboBox<String> name, attend;
	private JTextField date, ot;
	private JButton ok, cancel;
	private ArrayList<String> storage = new ArrayList<String>();
}
