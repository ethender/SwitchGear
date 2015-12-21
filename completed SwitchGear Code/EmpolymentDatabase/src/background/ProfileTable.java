package background;

import java.sql.*;

/**
 * This class is used get the employee profile data and insert into mysql
 * @author ethender
 * 
 */

public class ProfileTable {

	/**
	 * intialisation
	 * @param userName
	 * @param jobName
	 * @param companyName
	 * @param fullSalary
	 * @param oneDaySalary
	 * @param oneHourSalary
	 */
	public ProfileTable(String userName, String jobName, String companyName, double fullSalary, double oneDaySalary, double oneHourSalary){
		name = userName;
		jobDesignation = jobName;
		industry = companyName;
		Salary_Full = fullSalary;
		Salary_1 = oneDaySalary;
		Salary_Hour_1 = oneHourSalary;
		
		
		sendToMysql();
	}
	
	/**
	 * sending to the mysql
	 */
	private void sendToMysql(){
		try{
			//driver location
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			
			String query = "INSERT INTO profile(name,jobdesignition,industry,salary,onedaysalary,onehoursalary)VALUES(?,?,?,?,?,?)";
			
			PreparedStatement prepare = con.prepareStatement(query);
			prepare.setString(1, name);
			prepare.setString(2, jobDesignation);
			prepare.setString(3, industry);
			prepare.setDouble(4, Salary_Full);
			prepare.setDouble(5, Salary_1);
			prepare.setDouble(6, Salary_Hour_1);
			prepare.execute();
			
			con.close();
			
		}catch(Exception ex){
			System.out.println("Error at :profiletable & error is: \n "+ex.getMessage());
		}
	}
	
	
	/**
	 * private instances
	 */
	private String name;
	private String jobDesignation;
	private String industry;
	private double Salary_Full;
	private double Salary_1;
	private double Salary_Hour_1;
}
