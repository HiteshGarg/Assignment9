/**
 * 
 */
package com.nagarro.assignments.assignment9.actions;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.nagarro.assignments.assignment9.dto.LoginDto;
import com.nagarro.assignments.assignment9.services.LoginValidator;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

/**
 * @author hiteshgarg
 * 
 */
@Results({ @Result(name = "success", location = "admin-home", type = "redirect") })
public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * Serial version uid.
	 */
	private static final long serialVersionUID = 842783035425779813L;

	private String username;
	private String password;
	private String errorMessage;

	private Map<String, Object> session;

	@Override
	@Actions(value={
			@Action(value="/", results={@Result(name="login", location="login.tiles", type="tiles")}),
			@Action(value = "do-login", results={@Result(name="login", location="login.tiles",type="tiles")})
	})
	public String input() throws Exception {
		return "login";
	}

	@Override
	public String execute() throws Exception {
		System.out.println("in it");
		LoginValidator validator = new LoginValidator();
		LoginDto dto = new LoginDto();
		dto.setUsername(username);
		dto.setPassword(password);
		Boolean isValidated = validator.validateUser(dto);

		if (isValidated) {
			session.put("username", username);
			return SUCCESS;
		}
		errorMessage = "Incorrect Username or Password";
		return ERROR;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	@StringLengthFieldValidator(shortCircuit = true, type = ValidatorType.FIELD, fieldName = "username", minLength = "1", message = "Please enter some value in username")
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	@StringLengthFieldValidator(shortCircuit = true, type = ValidatorType.FIELD, fieldName = "password", minLength = "1", message = "Please enter some value in password")
	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
