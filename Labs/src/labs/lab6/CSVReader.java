package labs.lab6;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to read and process the contents of a standard CSV file
 */
public class CSVReader {
	List<List<String>> rows = new ArrayList<>();

	/**
	 * Constructor opens the input file and stores each line in a list of Strings.
	 * 
	 * @param fileName the name of the csv file to be processed
	 */
	public CSVReader(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				List<String> fields = parseLine(line);
				rows.add(fields);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + " not found");
		}
	}

	private List<String> parseLine(String line) {
		List<String> fields = new ArrayList<>();
		StringBuilder field = new StringBuilder();
		boolean inQuotes = false;
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (inQuotes) {
				if (c == '\"') {
					if (i + 1 < line.length() && line.charAt(i + 1) == '\"') {
						// Escaped quote
						field.append(c);
						i++; // Skip next quote
					} else {
						inQuotes = false;
					}
				} else {
					field.append(c);
				}
			} else {
				if (c == '\"') {
					inQuotes = true;
				} else if (c == ',') {
					fields.add(field.toString());
					field = new StringBuilder();
				} else {
					field.append(c);
				}
			}
		}
		fields.add(field.toString());
		return fields;
	}

	/**
	 * Returns the number of lines in the CSV file
	 * 
	 * @return the number of rows (lines) in the file
	 */
	public int getNumberOfRows() {
		return rows.size();
	}

	/**
	 * Returns the number of fields in a particular row
	 * 
	 * @param row the line number (0 <= row < number of lines)
	 * @return the number of fields in the given row
	 */
	public int getNumberOfFields(int row) throws IllegalArgumentException {
		if (row >= 0 && row < rows.size()) {
			return rows.get(row).size();
		} else {
			throw new IllegalArgumentException("Row " + row + " does not exist in the file");
		}
	}

	/**
	 * Extract fields from a String corresponding to the row number given as
	 * argument. Handles fields surrounded by quotes.
	 * 
	 * @param row the line number (0 <= row < number of lines)
	 * @return a list of fields in the given row
	 */
	public List<String> getFields(int row) {
		if (row >= 0 && row < rows.size()) {
			return new ArrayList<>(rows.get(row));
		} else {
			throw new IllegalArgumentException("Row " + row + " does not exist in the file");
		}
	}

	/**
	 * Returns the field in a particular row and column
	 * 
	 * @param row    the line number (0 <= row < number of lines)
	 * @param column the column number (0 <= row < number of columns in row)
	 * @return the field in the given row and column
	 */
	public String getField(int row, int column) throws IllegalArgumentException {
		if (row >= 0 && row < rows.size()) {
			List<String> rowFields = rows.get(row);
			if (column >= 0 && column < rowFields.size()) {
				return rowFields.get(column);
			} else {
				throw new IllegalArgumentException("Column " + column + " does not exist in row " + row);
			}
		} else {
			throw new IllegalArgumentException("Row " + row + " does not exist in the file");
		}
	}
}