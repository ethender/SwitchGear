package background;



import java.sql.*;
import java.util.*;

/**
 * This class get Attendence total or lists by Name, date, month, year
 * @author ethender
 *
 */
public class GetAttendence {
	
	/**
	 * gets the total days of all employees
	 * @return ArrayList<Attendence>
	 */
	public ArrayList<Attendence> getTotalAttendence(){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			
			con.close();
			
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	/**
	 * this method get total employees attendance by date
	 * @param int date
	 * @return ArrayList<Attendance>
	 */
	public ArrayList<Attendence> getAttendenceByDate(int date){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE date = ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, date);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	
	/**
	 * this method get total employees attendance by month
	 * @param month
	 * @return ArrayList<Attendance>
	 */
	public ArrayList<Attendence> getAttendenceByMonth(String month){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE month = ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, month);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	/**
	 * this method get total employees attendance by year
	 * @param year
	 * @return ArrayList<Attendance>
	 */
	public ArrayList<Attendence> getAttendenceByYear(int year){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE year = ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, year);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	/**
	 * this method gets total employee working days and details
	 * @param name
	 * @return ArrayList<Attendence>
	 */
	public ArrayList<Attendence> getAttendenceByName(String name){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE name = ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	/**
	 * this method gets total employee working days and details
	 * @param name, month
	 * @return ArrayList<Attendence>
	 */
	public ArrayList<Attendence> getAttendenceByNameAndMonth(String name,String month){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE name = ? AND month = ?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, month);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	
	/**
	 * this method gets total employee working days and details
	 * @param name , MONTH , YEAR
	 * @return ArrayList<Attendence>
	 */
	public ArrayList<Attendence> getAttendenceByNameAndMonthAndYear(String name,String month, int year){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE name = ? AND month = ? AND year =?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setString(2, month);
			stmt.setInt(3, year);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence \n error is :"+ex.getMessage());
		}
		
		return results;
	}
	
	/**
	 * return the attendance of the day
	 * @param day
	 * @param month
	 * @param year
	 * @return ArrayList<Attendance>
	 */
	public ArrayList<Attendence> getAttendenceByDateAndMonthAndYear(int day, String month, int year){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE  date = ? AND MONTH = ? AND year =?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, day);
			stmt.setString(2, month);
			stmt.setInt(3, year);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence & \n Error is: "+ex.getMessage());
		}
		
		return results;
	}
	
	
	/**
	 * return the attendance of the day
	 * @param month
	 * @param year
	 * @return ArrayList<Attendance>
	 */
	public ArrayList<Attendence> getAttendenceByMonthAndYear(String month, int year){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE MONTH = ? AND year =?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, month);
			stmt.setInt(2, year);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence & \n Error is: "+ex.getMessage());
		}
		
		return results;
	}
	
	
	/**
	 * return the attendance of the day
	 * @param name
	 * @param year
	 * @return ArrayList<Attendance>
	 */
	public ArrayList<Attendence> getAttendenceByNameAndYear(String name, int year){
		ArrayList<Attendence> results = new ArrayList<Attendence>();
		try{
			String query = "SELECT * FROM attendance WHERE  name = ? AND year =?";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, year);
			
			ResultSet set = stmt.executeQuery();
			
			while(set.next()){
				Attendence temp = new Attendence();
				temp.enterAttendence(set.getInt(1), set.getString(2), set.getInt(3), set.getString(4), set.getInt(5), set.getInt(6), set.getInt(7), set.getDouble(8), set.getDouble(9), set.getDouble(10));
				results.add(temp);
			}
			con.close();
		}catch(Exception ex){
			System.out.println("Error at GetAttendence & \n Error is: "+ex.getMessage());
		}
		
		return results;
	}
}
