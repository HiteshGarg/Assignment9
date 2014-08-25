/**
 * 
 */
package com.nagarro.assignments.assignment9.actions;

import java.awt.event.InvocationEvent;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author hiteshgarg
 *
 */
@InterceptorRef(value="customInterceptorStack")
public class Logout extends ActionSupport {

	/**
	 * Generated Serial Version Uid.
	 */
	private static final long serialVersionUID = 8339319087860275538L;
	
	@Override
	@Action(results={@Result(name="success", location="do-login", type="redirect")})
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.clear();
		return SUCCESS;
	}

}
