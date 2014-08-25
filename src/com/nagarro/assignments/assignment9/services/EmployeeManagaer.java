/**
 * 
 */
package com.nagarro.assignments.assignment9.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.nagarro.assignments.assignment9.constants.Constants;
import com.nagarro.assignments.assignment9.dal.EmployeeDao;
import com.nagarro.assignments.assignment9.dto.EmployeeDto;
import com.nagarro.assignments.assignment9.exception.NewCustomException;
import com.nagarro.assignments.assignment9.pojo.Employee;
import com.nagarro.assignments.assignment9.validators.Validators;

/**
 * @author hiteshgarg
 * 
 */
public class EmployeeManagaer {

	public final Boolean addEmployee(File employeeFile)
			throws NewCustomException {
		Boolean updated = false;
		EmployeeDto empDto = new EmployeeDto();
		new CsvHandler().readEmployeeCsv(employeeFile, empDto);

		if (empDto.getEmployeeList().size() > Constants.ZERO) {
			EmployeeDao dao = new EmployeeDao();
			dao.addEmployeeInDb(empDto);
			updated = true;
		} else {
			throw new NewCustomException(
					"Input file is empty. Please try inserting some data in it.",
					null);
		}

		return updated;
	}

	public void getEmployeeList(EmployeeDto empDto) throws NewCustomException {
		EmployeeDao dao = new EmployeeDao();
		dao.getEmployeeList(empDto);
	}

	public final Employee getEmployeeByID(String empCode)
			throws NewCustomException {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.getEmployeeById(empCode);
		return employee;
	}

	public void updateEmployee(Employee employee) throws NewCustomException {

		EmployeeDao dao = new EmployeeDao();
		Validators.isStringNull(employee.getEmpCode());
		Validators.isStringNull(employee.getEmpName());
		Validators.isStringNull(employee.getEmail());
		Validators.isStringNull(employee.getLocation());
		Validators.dateValidator(employee.getDateOfBirth());
		dao.updateEmployee(employee);
	}

	public String downloadEmployeeList() throws NewCustomException {

		EmployeeDto dto = new EmployeeDto();
		String createdFilePath = null;

		getEmployeeList(dto);
		try {

			Path filepath = Files.createTempFile("employee", ".csv");
			System.out.println(filepath.toAbsolutePath());

			for (Employee employee : dto.getEmployeeList()) {

				StringBuilder builder = new StringBuilder();
				builder.append(employee.getEmpCode());
				builder.append(Constants.APPEND_CSV_SPLITTER);
				builder.append(employee.getEmpName());
				builder.append(Constants.APPEND_CSV_SPLITTER);
				builder.append(employee.getLocation());
				builder.append(Constants.APPEND_CSV_SPLITTER);
				builder.append(employee.getEmail());
				builder.append(Constants.APPEND_CSV_SPLITTER);
				builder.append(employee.getDateOfBirth());
				builder.append(Constants.APPEND_CSV_SPLITTER);
				builder.append(employee.getEmpCode());
				builder.append(Constants.NEW_LINE);

				Files.write(filepath, builder.toString().getBytes(),
						StandardOpenOption.APPEND);
			}
			createdFilePath = filepath.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createdFilePath;
	}

}
