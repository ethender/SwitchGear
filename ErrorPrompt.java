/**
 * File ErrorPrompt.java
 * --------------------------------------------------
 * This program is writing for Debugging for programs  
 */


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ErrorPrompt implements ActionListener{
	
	/**
	 * Constants
	 */
	private static final String CAPTION = "ERROR_PROMPT";
	private static final String VERSION = "1.1";
	public  final String NEW_LINE = "\n";
	
	
	public  ErrorPrompt(){
		prepare();
		starting();
	}
	
	/**
	 * preparing The console
	 */
	public  void prepare(){
		initialiseFrame();
		
		initialiseMenu();
	}
	
	/**
	 * Fixing the Frame
	 */
	private void initialiseFrame(){
		// intialise frames
		frame = new JFrame("Error Prompt");
		
		
		
		// intialse textarea
		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		
		scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 700);
		
		frame.add(scroll);
	}
	
	
	
	/**
	 * intialising Menu
	 */
	private void initialiseMenu(){
		menuBar = new JMenuBar();
		menu = new JMenu("File");
		
		item1 = new JMenuItem("Enter Log");
		menu.add(item1);
		
	    item = new JMenuItem("Exit");
		menu.add(item);
		
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup(); 
		radioBut = new JRadioButtonMenuItem("Gray");
		
		group.add(radioBut);
		menu.add(radioBut);
		radioBut.addActionListener((ActionListener)this);
		
		
		radioBut = new JRadioButtonMenuItem("Black");
		group.add(radioBut);
		menu.add(radioBut);
		radioBut.addActionListener((ActionListener) this);
		
		radioBut = new JRadioButtonMenuItem("White");
		radioBut.setSelected(true);
		group.add(radioBut);
		menu.add(radioBut);
		radioBut.addActionListener((ActionListener) this);
		
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		
		
		
		
		item.addActionListener((ActionListener)this);
		item1.addActionListener((ActionListener) this);
	}
	
	
	/**
	 * when action  is called.
	 * This would be called 
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Exit")){
			System.exit(0);
		}else if(e.getActionCommand().equals("Enter Log")){
			CreateLog(true);
		}else if(e.getActionCommand().equals("Gray")){
			textArea.setBackground(Color.GRAY);
		}else if(e.getActionCommand().equals("Black")){
			textArea.setBackground(Color.BLACK);
		}else if(e.getActionCommand().equals("White")){
			textArea.setBackground(Color.WHITE);
		}
		
	}
	
	/**
	 * This method for starting console
	 */
	private void starting(){
		textArea.append(CAPTION+NEW_LINE);
		storage.add(CAPTION);
		textArea.append(VERSION+NEW_LINE);
		storage.add(VERSION);
		textArea.append("-----------------------------------"+NEW_LINE);
		storage.add("-------------------------------------");
	}
	/**
	 * Getting text from files errors
	 */
	public void setText(String error){
		storage.add(error);
		textArea.append(error+NEW_LINE);
		
	}
	
	
	/**
	 * 
	 * @param permission
	 * user needs create logs
	 */
	private void CreateLog(boolean permission){
		if(permission){
			String fileName = "Log_Print.txt";
			try{
				BufferedWriter wr = new BufferedWriter(new FileWriter(fileName));
				for(int i = 0; i < storage.size(); i++){
					wr.write(storage.get(i));
					wr.newLine();
				}
					wr.close();
					setText("Log Created");
			}catch(IOException ex){
				setText("error ocurred");
			}
		}
	}
	
	
	
	
	/**
	 * Instances
	 */
	private  JFrame frame;
	private  JTextArea textArea;
	private  JMenuBar menuBar ;
	private  JMenu menu;
	private  JMenuItem item, item1 ;
	private  ArrayList<String> storage = new ArrayList<String>();
	private  JRadioButtonMenuItem radioBut;
	private JScrollPane scroll;
	
}