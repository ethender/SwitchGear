package background;

import java.sql.*;
import java.util.*;

/**
 * This class is  for getting all employees profiles 
 * @author ethender
 *
 */

public class GetProfiles {
	
	
	/**
	 * class intialisation
	 */
	
	
	public GetProfiles(){
		try{
			String getQuery = "SELECT * FROM profile";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(getQuery);
			
			while(set.next()){
				Profile temp = new Profile();
				temp.createProfile(set.getInt(1), set.getString(2), set.getString(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7));
				profiles.add(temp);
			}
			
			con.close();
			
		}catch(Exception ex){
			System.out.println("Error at GetProfiles.java \n Error is: "+ex.getMessage());
		}
	}
	
	/**
	 * returns all employees profiles
	 * @return ArrayList<Profile>
	 */
	public ArrayList<Profile> getResults(){
		return profiles;
	}
	
	
	/**
	 * private instances
	 */
	
	private ArrayList<Profile> profiles = new ArrayList<Profile>(); 
	
}
