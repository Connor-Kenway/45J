package labs.lab4;

public class Activity {
	
	private String description; // description of activity
	private double time; // time taken for this activity, in hours
	private Category category;
	/*
	 * Note: This may be the first time you see an enum, but it is the perfect
	 * construct for a situation like this, where you want a set of predefined
	 * constants. The textbook explains enums in Special Topic 5.4 on pages 155-156.
	 * You can also google "Java enum" and read about them online.
	 */
	public static enum Category {
		WORK, PLAY, EXERCISE, SLEEP, OTHER
	};
	
	
	/**
	 * Constructs a new Activity with the given time and category
	 * 
	 * @param description	description of activity
	 * @param time			time taken for this activity, in hours (assume always > 0)
	 * @param category		category of this activity
	 */
	public Activity(String description, double time, Category category) {
		this.description = description;
		this.time = time;
		this.category = category;
	}
	
	
	public String getDescription() {
		return this.description;
	}
	
	
	public double getTime() {
		return this.time;
	}
	
	
	public Category getCategory() {
		return this.category;
	}

	public static void main(String[] args) {
		Activity t = new Activity("Eat", 0.05, Activity.Category.OTHER);
		System.out.println(t.getTime());
		System.out.println(t.getDescription());
		System.out.println(t.getCategory());
	}
}

