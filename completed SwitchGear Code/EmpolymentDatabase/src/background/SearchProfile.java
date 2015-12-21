package background;

import java.sql.*;
import java.util.*;

/**
 * 
 * @author ethender
 * this class is mainly for the searching the employee profiles
 */

public class SearchProfile {

	public SearchProfile(){
		
	}
	/**
	 * checks the employee name if found it returns true
	 * @param name
	 * @return boolean
	 */
	public boolean checkName(String name){
		boolean result = false;
		try{
			String getQuery = "SELECT userid FROM profile WHERE name=?";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(getQuery);
			stmt.setString(1, name);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				int i = set.getInt(1);
				if(i != 0){
					result = true;
				}
			}
			con.close();
		}catch(Exception ex){
			System.out.println("error at GetProfiles & error is \n: "+ex.getMessage());
		}
		
		return result;
	}
	
	/**
	 * sorts ArrayList by the employeename
	 * @param employeeName
	 * @return ArrayList<Profile>
	 */
	public ArrayList<Profile> searchByName(String employeeName){
		
	 ArrayList<Profile>	profiles = new ArrayList<Profile>();
		try{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			//Statement stmt = con.createStatement();
			
			String  searchQuery = "SELECT * FROM profile WHERE name =?";
			PreparedStatement prepare = con.prepareStatement(searchQuery);
			prepare.setString(1, employeeName);
			
			ResultSet set = prepare.executeQuery();
			
			while(set.next()){
				Profile temp = new Profile();
				temp.createProfile(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7));
				profiles.add(temp);
			}
			
			con.close();
			
		}catch(Exception ex){
			System.out.println("Error at searchProfile: \n error is: "+ex.getMessage());
		}
		
		return profiles;
	}
	
	/**
	 * sorts out by industryName
	 * @param IndustryName
	 * @return ArrayList<Profile>
	 */
	public ArrayList<Profile> searchByIndustry(String IndustryName){
		
		ArrayList<Profile>	profiles = new ArrayList<Profile>();
			try{
			
			
				Class.forName("com.mysql.jdbc.Driver");
			
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			
				String  searchQuery = "SELECT * FROM profile WHERE industry =?";
				PreparedStatement prepare = con.prepareStatement(searchQuery);
				prepare.setString(1, IndustryName);
			
				ResultSet set = prepare.executeQuery();
			
				while(set.next()){
					Profile temp = new Profile();
					temp.createProfile(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7));
					profiles.add(temp);
				}
			
				con.close();
			
			}catch(Exception ex){
				System.out.println("Error at searchProfile: \n error is: "+ex.getMessage());
			}
		
		return profiles;
	}
	
	/**
	 * sorts out by job name
	 * @param employeeJobDesignation
	 * @return ArrayList<Profile>
	 */
	public ArrayList<Profile> searchByJob(String employeeJobDesignation){
	
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		try{
		
		
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
		
		
			String  searchQuery = "SELECT * FROM profile where jobdesgnition =?";
			PreparedStatement prepare = con.prepareStatement(searchQuery);
			prepare.setString(1, employeeJobDesignation);
		
			ResultSet set = prepare.executeQuery();
		
			while(set.next()){
				Profile temp = new Profile();
				temp.createProfile(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7));
				profiles.add(temp);
			}
		
			con.close();
		
		}catch(Exception ex){
			System.out.println("Error at searchProfile: \n error is: "+ex.getMessage());
		}
	
		return profiles;
	}
	
	
	/**
	 * sorts out by salary
	 * @param employeeSalary
	 * @return ArrayList<Profile>
	 */
	public ArrayList<Profile> searchBySalary(int employeeSalary){
		
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		try{
		
		
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
		
		
			String  searchQuery = "SELECT * FROM profile where salary =?";
			PreparedStatement prepare = con.prepareStatement(searchQuery);
			//prepare.setString(1, employeeSalary);
			prepare.setInt(1, employeeSalary);
			
			ResultSet set = prepare.executeQuery();
		
			while(set.next()){
				Profile temp = new Profile();
				temp.createProfile(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7));
				profiles.add(temp);
			}
		
			con.close();
		
		}catch(Exception ex){
			System.out.println("Error at searchProfile: \n error is: "+ex.getMessage());
		}
	
		return profiles;
	}

}
