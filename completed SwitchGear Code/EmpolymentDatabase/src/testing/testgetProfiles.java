package testing;


import background.*;
import java.util.*;

public class testgetProfiles{
	
	public static void main(String[] args){
		SearchProfile profile = new SearchProfile();
		
		ArrayList<Profile> profileInfo = profile.searchBySalary(30000);
		
		for(int i = 0; i < profileInfo.size(); i++){
			Profile temp = profileInfo.get(i);
			System.out.println(temp.getEmployeeId()+" "+temp.getEmployeeName()+" "+temp.getJobDesignation()+" "+temp.getIndustryName()+" "+temp.getEmployeeSalary()+" "+temp.getEmployeeDaySalary()+" "+temp.getEmployeeHourSalary());
		}
	}
}