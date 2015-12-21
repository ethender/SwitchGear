package background;

import java.sql.*;

/**
 * This class uses for get attendence 1 person for 1 day and inserts into MYSQL
 * @author ethender
 *
 */
public class AttendenceInsertMysql {

	/**
	 * Intialisation with attendence and inserts into mysql
	 * @param day
	 */
	public AttendenceInsertMysql(Attendence day){
		attend = day;
		insertMysql();
	}
	
	/**
	 * intialsation
	 */
	public AttendenceInsertMysql(){
		
	}
	
	/**
	 * inserts the attendence into mysql
	 * @param day
	 */
	public void insertDayAttendence(Attendence day){
		attend = day;
		insertMysql();
	}
	
	
	/**
	 * insert into mysql
	 */
	private void insertMysql(){
		try{
			String enterEnquiry = "INSERT INTO attendance(userid, name, date, month, year, hourworking, othours, normalhoursamount, othoursamount, totalamount)VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			PreparedStatement prepare = con.prepareStatement(enterEnquiry);
			prepare.setInt(1, attend.getEmployeeId());
			prepare.setString(2, attend.getEmployeeName());
			prepare.setInt(3, attend.getDate());
			prepare.setString(4, attend.getMonth());
			prepare.setInt(5, attend.getYear());
			prepare.setInt(6, attend.getWorkingHours());
			prepare.setInt(7, attend.getOtHours());
			prepare.setDouble(8, attend.getWorkingHoursAmount());
			prepare.setDouble(9, attend.getOtHoursAmount());
			prepare.setDouble(10, attend.getTotalAmountOfTheDay());

			
			boolean result = prepare.execute();
			
			System.out.println(result);
			
			
			con.close();
		}catch(Exception ex){
			System.out.println("Error at AttendenceMysql \n & error is: "+ex.getMessage());
		}
	}
	
	/**
	 * private instance
	 *
	 */
	private Attendence attend;
}
