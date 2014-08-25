/**
 * 
 */
package com.nagarro.assignments.assignment9.dto;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.assignments.assignment9.pojo.Employee;

/**
 * @author hiteshgarg
 *
 */
public class EmployeeDto {

	private List<Employee> employeeList;

	public EmployeeDto() {
		employeeList = new ArrayList<>();
	}
	/**
	 * @return the employeeList
	 */
	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	/**
	 * @param employeeList the employeeList to set
	 */
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
