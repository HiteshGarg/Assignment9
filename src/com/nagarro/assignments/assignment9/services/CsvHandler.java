package com.nagarro.assignments.assignment9.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.nagarro.assignments.assignment9.constants.Constants;
import com.nagarro.assignments.assignment9.dto.EmployeeDto;
import com.nagarro.assignments.assignment9.exception.NewCustomException;
import com.nagarro.assignments.assignment9.pojo.Employee;
import com.nagarro.assignments.assignment9.validators.Validators;

/**
 * @author hiteshgarg
 * 
 */
public class CsvHandler {

	public void readEmployeeCsv(File employeeFile, EmployeeDto empDto)
			throws NewCustomException {

		try (InputStream inStream = new FileInputStream(employeeFile);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(inStream,
								Constants.CHARACTER_ENCODING));) {
			String input = reader.readLine();
			String[] empDetails;
			while (null != input && !input.isEmpty()) {

				empDetails = input.split(Constants.CSV_SPLITTER_REGEX);
				Employee employee = new Employee();

				employee.setEmpCode(empDetails[Constants.ZERO]);
				employee.setEmpName(empDetails[Constants.ONE]);
				employee.setLocation(empDetails[Constants.TWO]);
				employee.setEmail(empDetails[Constants.THREE]);
				employee.setDateOfBirth(empDetails[Constants.FOUR]);

				validateEmployee(employee);

				empDto.getEmployeeList().add(employee);
				input = reader.readLine();
			}
		} catch (FileNotFoundException exception) {
			// TODO add logger
			exception.printStackTrace();
			throw new NewCustomException("File not found.. Please try again.",
					exception);
		} catch (IOException exception) {
			// TODO add logger
			exception.printStackTrace();
			throw new NewCustomException(
					"Unable to perform input output operations", exception);
		}
	}

	private void validateEmployee(Employee employee) throws NewCustomException {

		Validators.isStringNull(employee.getEmpCode());
		Validators.isStringNull(employee.getEmpName());
		Validators.isStringNull(employee.getEmail());
		Validators.isStringNull(employee.getLocation());
		Validators.dateValidator(employee.getDateOfBirth());
	}
}
