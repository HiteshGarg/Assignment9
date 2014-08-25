package com.nagarro.assignments.assignment9.constants;

/**
 * This class is used to declare various constants that are used at various
 * locations in the project.
 * 
 * @author hiteshgarg
 */
public final class Constants {

	/**
	 * JDBC driver class.
	 */
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * Database url field in property File.
	 */
	public static final String DB_URL = "DB_URL";

	/**
	 * Database name field in property File.
	 */
	public static final String DB_NAME = "DB_NAME";

	/**
	 * Database username field in property File.
	 */
	public static final String DB_USERNAME = "DB_USERNAME";

	/**
	 * Database Password field in property File.
	 */
	public static final String DB_PASSWORD = "DB_PASSWORD";

	/**
	 * Format of Date while converting them into string or from String to date.
	 */
	public static final String DATE_FORMAT = "dd/MM/yyyy";

	/**
	 * character encoding for input.
	 */
	public static final String CHARACTER_ENCODING = "UTF-8";

	/**
	 * Mathematical no 0.
	 */
	public static final int ZERO = 0;

	/**
	 * Mathematical no 1.
	 */
	public static final int ONE = 1;

	/**
	 * Mathematical no 2.
	 */
	public static final int TWO = 2;

	/**
	 * Mathematical no 3.
	 */
	public static final int THREE = 3;

	/**
	 * Mathematical no 4.
	 */
	public static final int FOUR = 4;

	/**
	 * Mathematical no 5.
	 */
	public static final int FIVE = 5;

	/**
	 * Mathematical no 6.
	 */
	public static final int SIX = 6;

	public static final int SEVEN = 7;

	public static final int EIGHT = 8;
	public static final int NINE = 9;

	/**
	 * Search User query when user Logs In.
	 */
	public static final String SEARCH_USER = "Select * from login where username=? and password=?";

	/**
	 * DB query to add Employee in database.
	 */
	public static final String ADD_EMPLOYEE = "Insert into employee_details values(?,?,?,?,?)";

	/**
	 * 
	 */
	public static final String SEARCH_EMPLOYEE_BY_ID = "Select * from employee_details where emp_code = ?";

	/**
	 * 
	 */
	public static final String SEARCH_EMPLOYEE = "Select * from employee_details";

	/**
	 * 
	 */
	public static final String UPDATE_EMPLOYEE = "Update employee_details set emp_name=?, location=?, email=?, dob=? where emp_code=?";

	/**
	 * 
	 */
	public static final String PROPERTY_FILE_NAME = "config.properties";

	/**
	 * Regex to split csv files.
	 */
	public static final String CSV_SPLITTER_REGEX = "\\|";

	/**
	 * Incorrect Date Format Error.
	 */
	public static final String INCORRECT_DATE_ERROR = "Date in the Csv Files is not in the correct Format";

	/**
	 * Error message when the input is null or its length is zero.
	 */
	public static final String INCORRECT_INPUT_FORMAT = "Incorrect input. Either 'null' or empty value for one or more attributes. Please Try again";

	/**
	 * Value to append in csv files while creating them for download.
	 */
	public static final Object APPEND_CSV_SPLITTER = "|";

	/**
	 * To add new Line character.
	 */
	public static final Object NEW_LINE = "\n";

	/**
	 * Default constructor.
	 */
	private Constants() {
		// Do nothing.
	}
}
