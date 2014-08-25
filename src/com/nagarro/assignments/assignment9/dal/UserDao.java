/**
 * 
 */
package com.nagarro.assignments.assignment9.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.nagarro.assignments.assignment9.constants.Constants;
import com.nagarro.assignments.assignment9.dto.LoginDto;

/**
 * @author hiteshgarg
 * 
 */
public class UserDao {

	/**
	 * Static logger object to write all the exceptions in the Log file.
	 */
	private static final Logger LOGGER = Logger.getLogger(UserDao.class
			.getName());
	

	public Boolean validateUser(final LoginDto dto) {
		Boolean exists = false;
		try (Connection con = DbConnector.getConnection();
				PreparedStatement statement = con
						.prepareStatement(Constants.SEARCH_USER)
				) {
			statement.setString(Constants.ONE, dto.getUsername());
			statement.setString(Constants.TWO, dto.getPassword());
			
			ResultSet result = statement.executeQuery();
			if(result.first()){
				exists = true;
			}
			result.close();
		} catch (SQLException exception) {
			LOGGER.info(exception.getMessage(), exception);
		}
		return exists;
	}
}
