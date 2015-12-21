package testing;


import background.*;
import java.util.*;

public class testGetAttendence {
	
	public static void main(String[] args){
		GetAttendence attends = new GetAttendence();
		
		ArrayList<Attendence> total = attends.getAttendenceByNameAndMonthAndYear("aryan", "SEPTEMBER", 2014);
		
		for(int i = 0; i < total.size(); i++){
			Attendence temp = total.get(i);
			
			System.out.println(temp.getEmployeeId()+" "+temp.getEmployeeName()+" "+temp.getDate()+" "+temp.getMonth()+" "+temp.getYear()+" "+temp.getWorkingHours()+" "+temp.getOtHours()+" "+temp.getWorkingHoursAmount()+" "+temp.getOtHoursAmount()+" "+temp.getTotalAmountOfTheDay());
		}
	}
}