package code;

/**
 * Tested Debugged and totally clean
 */


import java.util.*;
import java.io.*;

public class KeyGenerator {
	
	/**
	 * File name 
	 */
	private static final String FileName = "KeyRegister.sce";
	
	/**
	 * constructor without parametres
	 */
	public KeyGenerator(){
		checkFile();
	}
	
	/**
	 * constructor with parametres
	 * @param name
	 */
	public KeyGenerator(String name){
				checkFile();
				empName = name;
				
	}
	

	
	
	/**
	 * Sets the emp Name
	 * @param name
	 */
	public void setName(String name){
		empName = name;
	}
	
	
	/**
	 * It automatically generates the key and assigns to the employee and it`s become employee id
	 */
	public void init(){
		getData();
		HashMap<String, String> keys = getEmployee_Key();
		String finalKey= null;
		
		//checking key is there or not
		while(true){
			String key = generateKey();
			boolean found = checkKey(key, keys);
			if(found == false){
				finalKey = key;
				break;
			}
		}
		
		String finalValue = empName+"="+finalKey;
		writeData(finalValue);
		
	}

	/**
	 * Gets Names of employeee
	 * @return ArrayList<String> names
	 */
	public ArrayList<String> getEmployeesName(){
		ArrayList<String> finalNames = new ArrayList<String>();
		try{
			BufferedReader rd = new BufferedReader(new FileReader(FileName));
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				int nameLastIndex = line.lastIndexOf("=");
				finalNames.add(line.substring(0, nameLastIndex));
			}
			rd.close();
		}catch(IOException ex){
			System.out.println("Error while getting emp names in "+FileName);
		}
		
		return finalNames;
	}
	
	/**
	 * checking file or not
	 */
	private void checkFile(){
		File file = new File(FileName);
		
		try{
			if(!file.exists()){
				file.createNewFile();
			}
		}catch(IOException ex){
			System.out.println("Error while creating "+FileName);
		}
	}
	
	/**
	 * Gets The data from file
	 */
	private void getData(){
		data = new ArrayList<String>();
		try{
			BufferedReader rd = new BufferedReader(new FileReader(FileName));
			while(true){
				String line = rd.readLine();
				if(line == null) break;
				
				data.add(line);
			}
			rd.close();
		}catch(IOException ex){
			System.out.println("Error getting data from KeyRegister.sce");
		}
	}
	/**
	 * Generates 8 digit secret key
	 * @return key 8 digit secret key 
	 */
	private String generateKey(){
		
		StringBuffer key = new StringBuffer("");
		Random ran = new Random();
		
		for(int i = 0; i < 8; i++){
			int temp =  ran.nextInt(9);
			if(i == 0 && temp == 0)
				temp = 1;
			
			key.append(new Integer(temp).toString());
		}
		
		return key.toString();
	}
	
	/**
	 * 
	 * @param key
	 * @return isThere or not
	 * 
	 * checks the key if found return true else false
	 */
	private boolean checkKey(String key, HashMap<String,String> keys){
		boolean find = false;
		for(int i = 0; i < keys.size(); i++){
			if(keys.containsKey(key))
				find = true;
		}
		
		return find;
	}
	
	/**
	 * 
	 * @return hashMap contains  keys and employee names;
	 */
	public HashMap<String,String> getEmployee_Key(){
		HashMap<String, String> dataBase = new HashMap<String,String>();
		
		try{
			BufferedReader rd = new BufferedReader(new FileReader(FileName));
			
			while(true){
				String line = rd.readLine();
				if(line == null)break;
				// breaking line 
				
				int lastNameIndex = line.lastIndexOf("=");
				String name = line.substring(0, lastNameIndex);
				
				int keyFirstIndex = line.indexOf('=')+1;
				String key = line.substring(keyFirstIndex, line.length());
				
				dataBase.put(name, key);
			}
			rd.close();
		}catch(IOException ex){
			System.out.println("Error While retriving keyregister file");
		}
		
		return dataBase;
	}
	
	/**
	 * writes the data into file
	 * @param value
	 */
	private void writeData(String value){
		try{
			BufferedWriter wr = new BufferedWriter(new FileWriter(FileName));
			for(int i = 0; i < data.size(); i++){
				wr.write(data.get(i));
				wr.newLine();
			}
			wr.write(value);
			wr.newLine();
			wr.close();
		}catch(IOException ex){
			System.out.println("Error while writing KeyRegister.sce");
		}
	}
	
	/**
	 * Private Instances
	 */
	
	private String empName;
	private ArrayList<String> data;
}