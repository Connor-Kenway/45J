package labs.lab7;

/**
 * Class for creating a priority print queue.
 */
public class PrintJob implements Comparable {
	// ADD YOUR INSTANCE VARIABLES HERE

	String employeeType;
	String description;
	/**
	 * Constructor.
	 * 
	 * @param employeeType   The type of employee requesting the print job
	 * @param description    The description of the print job.
	 */
	public PrintJob(String employeeType, String description) {
		this.employeeType = employeeType;
		this.description = description;
	}

	public int getPriority() {
		switch (employeeType) {
			case "CEO":
				return 1;
			case "Vice-President":
				return 2;
			case "Executive-Manager":
				return 3;
			case "Manager":
				return 4;
			case "Senior-Associate":
				return 5;
			case "Associate":
				return 6;
			case "Junior-Associate":
				return 7;
			case "Clerical":
				return 8;
			case "Intern":
				return 9;
			case "Volunteer":
				return 10;
			default:
				return 11;
		}
	}

	public String getEmployeeType() {
		return employeeType;
	}
	
	public String getDescription() {
		return description;
	}

	@Override
	public int compareTo(Object otherObject) {
		PrintJob temp = (PrintJob) otherObject;
		return Integer.compare(this.getPriority(), temp.getPriority());
	}
}