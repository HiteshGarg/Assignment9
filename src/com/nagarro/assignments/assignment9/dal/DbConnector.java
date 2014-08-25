/**
 * 
 */
package com.nagarro.assignments.assignment9.dal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.nagarro.assignments.assignment9.constants.Constants;

/**
 * @author hiteshgarg
 *
 */
public class DbConnector {
	/**
	 * Static logger object to write all the exceptions in the Log file.
	 */
	private static final Logger LOGGER = Logger.getLogger(DbConnector.class
			.getName());
	/**
	 * This loads the driver once in the lifetime
	 */
	static {
		try {
//			System.out.println("static block");
			Class.forName(Constants.JDBC_DRIVER);
		} catch (ClassNotFoundException exception) {
			LOGGER.info(exception.getMessage(), exception);
		}
	}

	private static String dbUrl;
	private static String username;
	private static String password;

	private static final void getDbProperties() {
		try (InputStream input = DbConnector.class.getClassLoader().getResourceAsStream(
				Constants.PROPERTY_FILE_NAME)) {

			Properties prop = new Properties();
			prop.load(input);

			dbUrl = prop.getProperty(Constants.DB_URL)
					+ prop.getProperty(Constants.DB_NAME);
			username = prop.getProperty(Constants.DB_USERNAME);
			password = prop.getProperty(Constants.DB_PASSWORD);
//			System.out.println(username+" "+password+" "+dbUrl);
		} catch (FileNotFoundException exception) {
			LOGGER.info(exception.getMessage(), exception);
		} catch (IOException exception) {
			LOGGER.info(exception.getMessage(), exception);
		}
	}

	/**
	 * This method creates and return the connection object after connecting it
	 * to database. It reads all the properties like database url, database
	 * name, username, password from the property file.
	 * 
	 * @return Connection object
	 */
	public static final Connection getConnection() {
		Connection conn = null;
		try {
			LOGGER.info("hello");
//			System.out.println("getting connection");
			if (null == dbUrl || null == username || null == password) {
				getDbProperties();
			}
			conn = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException exception) {
			LOGGER.info(exception.getMessage(), exception);
		}
		return conn;
	}

}
