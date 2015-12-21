package background;

/**
 * 
 * @author ethender
 * This class is writing for creation of the profiles of the employees
 */
public class Profile{
		
	/**
	 * intialisation of profile
	 */
	public Profile(){
		id = 0;
		name = null;
		job = null;
		industry = null;
		salary = 0;
		salary_day = 0;
		salary_hour = 0;
	}
	
	/**
	 * Second intialistaion
	 * @param employeeId
	 * @param employeeName
	 * @param jobDesignation
	 * @param industryName
	 * @param monthSalary
	 * @param salary_per_day
	 * @param salary_per_hour
	 */
	public Profile(int employeeId,String employeeName,String jobDesignation,String industryName , int monthSalary, int salary_per_day, int salary_per_hour){
		id = employeeId;
		name = employeeName;
		job = jobDesignation;
		industry = industryName;
		salary = monthSalary;
		salary_day = salary_per_day;
		salary_hour = salary_per_hour;
	}
	
	/**
	 * Creates the profile
	 * @param employeeId
	 * @param employeeName
	 * @param jobDesignation
	 * @param industryName
	 * @param monthSalary
	 * @param salary_per_day
	 * @param salary_per_hour
	 */
	public void createProfile(int employeeId,String employeeName,String jobDesignation,String industryName , int monthSalary, int salary_per_day, int salary_per_hour){
		id = employeeId;
		name = employeeName;
		job = jobDesignation;
		industry = industryName;
		salary = monthSalary;
		salary_day = salary_per_day;
		salary_hour = salary_per_hour;
	}
	
	/**
	 * returns 
	 * @return employee id
	 */
	public int getEmployeeId(){
		return id;
	}
	
	/**
	 * 
	 * @return employee name
	 */
	public String getEmployeeName(){
		return name;
	}
	
	/**
	 * 
	 * @return job name
	 */
	public String getJobDesignation(){
		return job;
	}
	
	/**
	 * 
	 * @return industry name
	 */
	public String getIndustryName(){
		return industry;
	}
	
	/**
	 * 
	 * @return employee salary
	 */
	public int getEmployeeSalary(){
		return salary;
	}
	
	/**
	 * 
	 * @return employee day salary
	 */
	public int getEmployeeDaySalary(){
		return salary_day;
	}
	
	/**
	 * 
	 * @return employee hour salary
	 */
	public int getEmployeeHourSalary(){
		return salary_hour;
	}
	
	
	
	/**
	 * private instance
	 * 
	 */
	private int id;
	private String name;
	private String job;
	private String industry;
	private int salary;
	private int salary_day;
	private int salary_hour;
}
