package labs.lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Holds airport data from a file and provides a query for getting all
 * the airports in a city
 */
public class AirportData {

	// ADD YOUR INSTANCE VARIABLES HERE
	private Map<String, List<String>> airportsByCity;
	
	/**
	 * Constructor that creates an AirportData object using the specified data file
	 * 
	 * @param dataFileName	data file name
	 */
	public AirportData(String dataFileName){
		this.airportsByCity = new HashMap<>();
		try {
			File inputFile = new File(dataFileName);
			Scanner in = new Scanner(inputFile);
			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] parts = line.split(",", 4);
				if (parts.length > 3) {
					String cityName = parts[2].replace("\"", "");
					String airportName = parts[1].replace("\"", "");
					airportsByCity.putIfAbsent(cityName, new ArrayList<>());
					airportsByCity.get(cityName).add(airportName);
				}
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File: " + dataFileName + " not found");
		}
	}

	
	/**
	 * 
	 * @param cityName city name
	 * 
	 * @return a list of all airport names in the given city
	 */
	public List<String> getAllAirportsInCity(String cityName) {
		return airportsByCity.getOrDefault(cityName, new ArrayList<>());
	}

	public static void main(String[] args) throws FileNotFoundException {
		AirportData ad = new AirportData("res/airports.dat");
		List<String> airports = ad.getAllAirportsInCity("Seoul");
		System.out.println(airports); // prints [Gimpo International Airport, Incheon International Airport]
		airports = ad.getAllAirportsInCity("Irvine");
		System.out.println(airports); // prints []
	}
}
