/**
 * 
 */
package com.nagarro.assignments.assignment9.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.nagarro.assignments.assignment9.dto.EmployeeDto;
import com.nagarro.assignments.assignment9.exception.NewCustomException;
import com.nagarro.assignments.assignment9.services.EmployeeManagaer;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hiteshgarg
 */
@InterceptorRef(value="customInterceptorStack")
public class AdminHome extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7837970692365687444L;
	private String errorMesage;
	private EmployeeDto empDto;

	@Override
	@Action(results={@Result(name="success", location="admin-home.tiles", type="tiles")})
	public String execute() throws Exception {
		EmployeeManagaer empManager = new EmployeeManagaer();
		empDto = new EmployeeDto();
		try {
			empManager.getEmployeeList(empDto);
		} catch (NewCustomException exception) {
			setErrorMesage(exception.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * @return the errorMesage
	 */
	public String getErrorMesage() {
		return errorMesage;
	}

	/**
	 * @param errorMesage
	 *            the errorMesage to set
	 */
	public void setErrorMesage(String errorMesage) {
		this.errorMesage = errorMesage;
	}

	/**
	 * @return the empDto
	 */
	public EmployeeDto getEmpDto() {
		return empDto;
	}

	/**
	 * @param empDto
	 *            the empDto to set
	 */
	public void setEmpDto(EmployeeDto empDto) {
		this.empDto = empDto;
	}
}
