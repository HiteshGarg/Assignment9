/**
 * 
 */
package com.nagarro.assignments.assignment9.actions;

import java.io.File;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.assignments.assignment9.exception.NewCustomException;
import com.nagarro.assignments.assignment9.services.EmployeeManagaer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * @author hiteshgarg
 * 
 */
@InterceptorRef(value="customInterceptorStack")
public class UploadEmployee extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3177925395947688484L;

	private File employeeFile;
	private String errorMessage;

	@Override
	@Action("do-upload-employee")
	public String input() throws Exception {
		// TODO Auto-generated method stub
		return "upload-employee";
	}

	@Override
	@Action(results = { @Result(name = "success", location = "admin-home", type = "redirect") })
	public String execute() throws Exception {
		System.out.println(employeeFile.getAbsolutePath());
		EmployeeManagaer addEmp = new EmployeeManagaer();
		Boolean success = false;
		try {
			success = addEmp.addEmployee(employeeFile);
		} catch (NewCustomException exception) {
			setErrorMessage(exception.getMessage());
			//TODO log messages here
		}
		if (success)
			return SUCCESS;
		else
			return ERROR;
	}

	/**
	 * @return the employeeFile
	 */
	public File getEmployeeFile() {
		return employeeFile;
	}

	/**
	 * @param employeeFile
	 *            the employeeFile to set
	 */
	@RegexFieldValidator(type = ValidatorType.FIELD, regex = "(?=.*[\\w\\d]).+.csv", message = "invalid Type of File.")
	public void setEmployeeFile(File employeeFile) {
		this.employeeFile = employeeFile;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
