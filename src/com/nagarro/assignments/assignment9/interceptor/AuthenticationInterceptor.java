/**
 * 
 */
package com.nagarro.assignments.assignment9.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author hiteshgarg
 * 
 */
public class AuthenticationInterceptor extends AbstractInterceptor {

	/**
	 * Generated serial version uid.
	 */
	private static final long serialVersionUID = 4301735468246013194L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("intercept in");
		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();
		Object user = session.get("username");
		String result = null;

		if (user == null) {
			result = "do-login";
		} else {
			result = invocation.invoke();
		}
		System.out.println("intercept out " + result + " " + session.size());
		return result;
	}

}
