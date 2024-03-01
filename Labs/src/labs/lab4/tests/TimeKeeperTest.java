package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.Time;


public class TimeKeeperTest {

	private final double EPSILON = 1e-3;

	// Tests that the total time and percentage for all categories are calculated correctly when
	// all of the activities are in the same category
	@Test
    public void testAllActivitiesInOneCategory() {
		TimeKeeper t1 = new TimeKeeper();
		t1.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		t1.doActivity(new Activity("Eat lunch", 0.1, Activity.Category.OTHER));
		t1.doActivity(new Activity("Eat dinner", 0.1, Activity.Category.OTHER));
		t1.doActivity(new Activity("Eat late night snacks", 0.01, Activity.Category.OTHER));
		assertEquals(0.26, t1.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
    }

	// Tests that the total time and percentage
	// for all categories are calculated correctly when there are no activities
	@Test
	public void testNoActivities() {
		TimeKeeper t2 = new TimeKeeper();
		assertEquals(0.0, t2.getTotalTime(), EPSILON);
		assertEquals(0.0, t2.getPercentageOfTimeSpent(), EPSILON);
	}

	// Tests that the total time and percentage  for all categories are calculated correctly
	// when there are duplicate activities (duplicate activities are allowed, so they should each be counted)
	@Test
	public void testDuplicateActivities() {
		TimeKeeper t3 = new TimeKeeper();
		t3.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		t3.doActivity(new Activity("Eat breakfast", 0.05, Activity.Category.OTHER));
		assertEquals(0.1, t3.getTotalTimeForCategory(Activity.Category.OTHER), EPSILON);
	}
}