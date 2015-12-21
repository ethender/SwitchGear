package testing;

import background.*;

public class testAttendenceMysql {

	public static void main(String[] args) {
		Attendence attend = new Attendence();
		
		attend.enterAttendence(2, "aryan", 30, "SEPTEMBER", 2014, 10, 5, 10000.00, 5000.00, 15000.10);
		
		
		AttendenceInsertMysql sql = new AttendenceInsertMysql();
		sql.insertDayAttendence(attend);

	}

}
