/**
 * 
 */
package com.nagarro.assignments.assignment9.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.assignments.assignment9.exception.NewCustomException;
import com.nagarro.assignments.assignment9.pojo.Employee;
import com.nagarro.assignments.assignment9.services.EmployeeManagaer;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hiteshgarg
 * 
 */
@InterceptorRef(value="customInterceptorStack")
public class EditEmployee extends ActionSupport {

	/**
	 * Serial Version Uid.
	 */
	private static final long serialVersionUID = -6018668865323725868L;

	/**
	 * 
	 */
	private String empCode;

	/**
	 * 
	 */
	private Employee employee;

	/**
	 * 
	 */
	private String message;

	@Override
	@Action(value="do-edit-employee"/*, results={@Result(name="edit-employee", location="edit-employee", type="tiles")}*/)
	public String input() throws Exception {
		// TODO Auto-generated method stub
		EmployeeManagaer empManager = new EmployeeManagaer();
		setEmployee(empManager.getEmployeeByID(getEmpCode()));
		if (null == getEmployee()) {
			setMessage("No Employee found with this Employee code.");
		}
		return "edit-employee";
	}

	@Override
	public String execute() throws Exception {
		EmployeeManagaer empManager = new EmployeeManagaer();
		try {
			empManager.updateEmployee(employee);
			setMessage("Employee Successfully updated..");
		} catch (NewCustomException exception) {
			setMessage(exception.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * @return the empCode
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @param empCode
	 *            the empCode to set
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
