/**
 * 
 */
package com.nagarro.assignments.assignment9.services;

import com.nagarro.assignments.assignment9.dal.UserDao;
import com.nagarro.assignments.assignment9.dto.LoginDto;

/**
 * @author hiteshgarg
 * 
 */
public class LoginValidator {


	public Boolean validateUser(LoginDto dto) {
		Boolean validate = false;
		validate = new UserDao().validateUser(dto);
		return validate;
	}

}
