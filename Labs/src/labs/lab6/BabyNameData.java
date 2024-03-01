package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * A set of baby name data ranking the most popular baby names in the U.S. in a
 * particular year
 */
public class BabyNameData {

	// ADD YOUR INSTANCE VARIABLES HERE
	private List<BabyName> boyNames = new ArrayList<>();
	private List<BabyName> girlNames = new ArrayList<>();

	/**
	 * Constructor that creates this object with data from a file
	 * 
	 * @param babyNamesFileName name of input file
	 */
	public BabyNameData(String babyNamesFileName) {
		try {
			Scanner scanner = new Scanner(new File(babyNamesFileName));
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().trim().split("\\s+");
				int rank = Integer.parseInt(data[0]);
				// Boy data
				boyNames.add(new BabyName(data[1], rank, Integer.parseInt(data[2]), Double.parseDouble(data[3])));
				// Girl data
				girlNames.add(new BabyName(data[4], rank, Integer.parseInt(data[5]), Double.parseDouble(data[6])));
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.print("File: " + babyNamesFileName + " not found");
		}
	}


	/**
	 * 
	 * @return all girl names (in a non-specific order)
	 */
	public List<String> getAllGirlNames() {
		List<String> names = new ArrayList<>();
		for (BabyName name : girlNames) {
			names.add(name.getName());
		}
		return names;
	}


	/**
	 * 
	 * @return all boy names (in a non-specific order)
	 */
	public List<String> getAllBoyNames() {
		List<String> names = new ArrayList<>();
		for (BabyName name : boyNames) {
			names.add(name.getName());
		}
		return names;
	}


	/**
	 * 
	 * @return all names that appear in the data for both boys and girls (in a
	 *         non-specific order)
	 */
	public List<String> getAllNonGenderSpecificNames() {
		List<String> nonGenderSpecificNames = new ArrayList<>();
		for (BabyName boyName : boyNames) {
			for (BabyName girlName : girlNames) {
				if (boyName.getName().equals(girlName.getName())) {
					nonGenderSpecificNames.add(boyName.getName());
					break;
				}
			}
		}
		return nonGenderSpecificNames;
	}


	/**
	 * 
	 * @param rank
	 * @return the girl name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getGirlNameAtRank(int rank) throws IllegalArgumentException {
		if (rank < 1 || rank > girlNames.size()) {
			throw new IllegalArgumentException("Rank " + rank + " out of range of data");
		}
		return girlNames.get(rank - 1).getName(); // Subtract 1 because list indices start at 0
	}



	/**
	 * 
	 * @param rank
	 * @return the boy name at the rank specified
	 * 
	 *         If rank is out of the range of data, throw an
	 *         IllegalArgumentException with the message "Rank [rank] out of range
	 *         of data"
	 */
	public String getBoyNameAtRank(int rank) {
		if (rank < 1 || rank > boyNames.size()) {
			throw new IllegalArgumentException("Rank " + rank + " out of range of data");
		}
		return boyNames.get(rank - 1).getName();
	}
}
