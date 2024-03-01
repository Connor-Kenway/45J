package labs.lab4;
import java.util.ArrayList;

public class TimeKeeper {
	// ADD YOUR INSTANCE VARIABLES HERE
	ArrayList<Activity> activities;
	
	/**
	 * Constructs a new TimeKeeper, with no activities
	 */
	public TimeKeeper() {
		activities = new ArrayList<Activity>();
	}
	
	
	/**
	 * Causes TimeKeeper to record the given activity
	 * 
	 * @param a	the activity to record
	 */
	public void doActivity(Activity a) {
		activities.add(a);
	}
	
	
	/**
	 * Returns the total time (in hours) spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total time (in hours) spent in the category	
	 */
	public double getTotalTimeForCategory(Activity.Category category) {
		double totalTime = 0.0;
		for (Activity activity : activities) {
			if (activity.getCategory() == category) {
				totalTime += activity.getTime();
			}
		}
		return totalTime;
	}
	
	
	/**
	 * Returns the total percentage of time spent in the given category
	 * 
	 * @param 	category	category to calculate the time spent in
	 * @return	total percentage of time spent in the category	
	 */
	public double getPercentageOfTimeSpentInCategory(Activity.Category category) {
		double totalTime = 0.0;
		for (Activity activity : activities) {
			totalTime += activity.getTime();
		}
		return getTotalTimeForCategory(category) * 100 / totalTime;
	}

	public double getTotalTime() {
		double totalTime = 0.0;
		for (Activity activity : activities) {
			totalTime += activity.getTime();
		}
		return totalTime;
	}

	public double getPercentageOfTimeSpent() {
		double totalTime = 0.0;
		for (Activity activity : activities) {
			totalTime += activity.getTime();
		}
		double ans = getTotalTime() * 100 / totalTime;
		if (ans != ans) {
			return 0.0;
		}
		return totalTime;
	}

	public static void main(String[] args) {
		TimeKeeper tk = new TimeKeeper();
		tk.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Go for a run with Mommy", 1.0, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Bring in the newspaper", 0.03, Activity.Category.WORK));
		tk.doActivity(new Activity("Take my siblings to school", 0.75, Activity.Category.WORK));
		tk.doActivity(new Activity("Play ball with Mommy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Take a nap", 3.5, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Sunbathe", 0.5, Activity.Category.OTHER));
		tk.doActivity(new Activity("Play tug of war with Daddy", 0.05, Activity.Category.PLAY));
		tk.doActivity(new Activity("Attend Mom's 45J lecture", 1.3, Activity.Category.WORK));
		tk.doActivity(new Activity("Afternoon nap", 2.0, Activity.Category.SLEEP));
		tk.doActivity(new Activity("Pick my siblings up from school", 1.0, Activity.Category.WORK));
		tk.doActivity(new Activity("Eat dinner", 0.05, Activity.Category.OTHER));
		tk.doActivity(new Activity("Evening walk around the neighborhood", 0.5, Activity.Category.EXERCISE));
		tk.doActivity(new Activity("Go outside and bark at nothing", 0.15, Activity.Category.WORK));

		for (Activity.Category category : Activity.Category.values()) {
			System.out.println(category + ": " + tk.getTotalTimeForCategory(category) + " hours; " +
					tk.getPercentageOfTimeSpentInCategory(category) + "% of total time");
		}
	}
}