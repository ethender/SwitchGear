package testing;

import java.sql.*;

import background.ProfileTable;

public class TestProfileTable {

	public static void main(String[] args) {
		ProfileTable table = new ProfileTable("ethender", "programmer", "skynet", 30000, 1000, 125);
		
		try{
			String query = "select * from profile";
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skyemploymentdatabase","root","19931993");
			
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(query);
			
			while(set.next()){
				System.out.println(set.getString(1));
			}
			
			con.close();
			
		}catch(Exception ex){
			System.out.println("error at: "+ex.getMessage());
		}

	}

}
