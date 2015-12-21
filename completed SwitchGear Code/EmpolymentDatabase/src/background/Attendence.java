package background;


/**
 * This class is mainly for getting attendence of the day
 * @author ethender
 *
 */

public class Attendence extends Object{

	/**
	 * Attendence program
	 * @param employeeId
	 * @param employeeName
	 * @param workingDate
	 * @param workingMonth
	 * @param workingYear
	 * @param workedHours
	 * @param workedOtHours
	 * @param workingHoursAmount
	 * @param workingOthoursAmount
	 * @param workingAmount
	 */
	public Attendence(int employeeId, String employeeName, int workingDate, String workingMonth, int workingYear,int workedHours, int workedOtHours,double workingHoursAmount,double workingOthoursAmount, double workingAmount){
		userId = employeeId;
		name = employeeName;
		date = workingDate;
		month = workingMonth;
		year = workingYear;
		generalWorkingHours = workedHours;
		otHours =  workedOtHours;
		generalWorkingAmount = workingHoursAmount;
		otWorkingAmount = workingOthoursAmount;
		totalAmount = workingAmount;
	}
	
	/**
	 * intialisation
	 */
	public Attendence(){
		userId = 0;
		name = "";
		date = 0;
		month ="";
		year = 0;
		generalWorkingHours = 0;
		otHours = 0;
		generalWorkingAmount = 0;
		otWorkingAmount = 0;
		totalAmount = 0;
	}
	
	
	/**
	 * enters the attendence 
	 * @param employeeId
	 * @param employeeName
	 * @param workingDate
	 * @param workingMonth
	 * @param workingYear
	 * @param workedHours
	 * @param workedOtHours
	 * @param workingHoursAmount
	 * @param workingOthoursAmount
	 * @param workingAmount
	 */
	public void enterAttendence(int employeeId, String employeeName, int workingDate, String workingMonth, int workingYear,int workedHours, int workedOtHours,double workingHoursAmount,double workingOthoursAmount, double workingAmount){
		userId = employeeId;
		name = employeeName;
		date = workingDate;
		month = workingMonth;
		year = workingYear;
		generalWorkingHours = workedHours;
		otHours =  workedOtHours;
		generalWorkingAmount = workingHoursAmount;
		otWorkingAmount = workingOthoursAmount;
		totalAmount = workingAmount;
	}
	
	/**
	 * get the employee id
	 * @return int
	 */
	public int getEmployeeId(){
		return userId;
	}
	
	/**
	 * get employeeName
	 * @return String
	 */
	public String getEmployeeName(){
		return name;
	}
	
	/**
	 * gets the date
	 * @return int
	 */
	public int getDate(){
		return date;
	}
	
	/**
	 * get the month
	 * @return String
	 */
	public String getMonth(){
		return month;
	}
	
	/**
	 * gets the year
	 * @return int
	 */
	public int getYear(){
		return year;
	}
	
	/**
	 * gets the employee general working hours 
	 * @return int
	 */
	public int getWorkingHours(){
		return generalWorkingHours;
	}
	
	/**
	 * get the employee worked ot hours
	 * @return int
	 */
	public int getOtHours(){
		return otHours;
	}
	
	/**
	 * get employee worked general hours amount
	 * @return int
	 */
	public double getWorkingHoursAmount(){
		return generalWorkingAmount;
	}
	
	/**
	 * get employee worked ot hours amount 
	 * @return int
	 */
	public double getOtHoursAmount(){
		return otWorkingAmount;
	}
	
	
	/**
	 * gets the total amount
	 * @return int
	 */
	public double getTotalAmountOfTheDay(){
		return totalAmount;
	}
	
	/**
	 * private instances
	 */
	
	private int userId;
	private String name;
	private int date;
	private String month;
	private int year;
	private int generalWorkingHours;
	private int otHours;
	private double generalWorkingAmount;
	private double otWorkingAmount;
	private double totalAmount;
}