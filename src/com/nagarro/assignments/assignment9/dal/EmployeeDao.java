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
import com.nagarro.assignments.assignment9.dto.EmployeeDto;
import com.nagarro.assignments.assignment9.exception.NewCustomException;
import com.nagarro.assignments.assignment9.pojo.Employee;

/**
 * @author hiteshgarg
 * 
 */
public class EmployeeDao {

	private final static Logger LOGGER = Logger.getLogger(EmployeeDao.class
			.getName());

	public void addEmployeeInDb(final EmployeeDto empDto)
			throws NewCustomException {
		try (Connection con = DbConnector.getConnection();
				PreparedStatement statement = con
						.prepareStatement(Constants.ADD_EMPLOYEE)) {
			for (Employee emp : empDto.getEmployeeList()) {

				if (null != getEmployeeById(emp.getEmpCode())) {
					updateEmployee(emp);
					continue;
				}
				statement.setString(Constants.ONE, emp.getEmpCode());
				statement.setString(Constants.TWO, emp.getEmpName());
				statement.setString(Constants.THREE, emp.getLocation());
				statement.setString(Constants.FOUR, emp.getEmail());
				statement.setString(Constants.FIVE, emp.getDateOfBirth());

				statement.addBatch();
			}
			statement.executeBatch();
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block throw custom exception
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee emp) throws NewCustomException {
		try (Connection con = DbConnector.getConnection();
				PreparedStatement statement = con
						.prepareStatement(Constants.UPDATE_EMPLOYEE)) {

			statement.setString(Constants.ONE, emp.getEmpName());
			statement.setString(Constants.TWO, emp.getLocation());
			statement.setString(Constants.THREE, emp.getEmail());
			statement.setString(Constants.FOUR, emp.getDateOfBirth());
			statement.setString(Constants.FIVE, emp.getEmpCode());

			statement.executeUpdate();
			statement.close();
		} catch (SQLException exception) {
			// TODO Auto-generated catch block throw custom exception
			exception.printStackTrace();
			throw new NewCustomException("Error in contacting Server.. Please try again..", exception);
		}
	}

	public final Employee getEmployeeById(final String empCode)
			throws NewCustomException {
		// TODO Auto-generated method stub
		Employee employee=null;
		try (Connection con = DbConnector.getConnection();
				PreparedStatement statement = con
						.prepareStatement(Constants.SEARCH_EMPLOYEE_BY_ID)) {
			statement.setString(Constants.ONE, empCode);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				employee = new Employee();
				employee.setEmpCode(result.getString(Constants.ONE));
				employee.setEmpName(result.getString(Constants.TWO));
				employee.setLocation(result.getString(Constants.THREE));
				employee.setEmail(result.getString(Constants.FOUR));
				employee.setDateOfBirth(result.getString(Constants.FIVE));
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	public void getEmployeeList(EmployeeDto empDto) throws NewCustomException {
		try (Connection con = DbConnector.getConnection();
				PreparedStatement statement = con
						.prepareStatement(Constants.SEARCH_EMPLOYEE);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Employee emp = new Employee();
				emp.setEmpCode(resultSet.getString(Constants.ONE));
				emp.setEmpName(resultSet.getString(Constants.TWO));
				emp.setLocation(resultSet.getString(Constants.THREE));
				emp.setEmail(resultSet.getString(Constants.FOUR));
				emp.setDateOfBirth(resultSet.getString(Constants.FIVE));
				empDto.getEmployeeList().add(emp);
			}
		} catch (SQLException exception) {
			// TODO: handle exception Add the logger to it
			exception.printStackTrace();
			throw new NewCustomException("Error Contacting server. Please try again later.", exception);
		}
	}

}
