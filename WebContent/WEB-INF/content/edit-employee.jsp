<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:property value="message" />
	<s:form action="edit-employee">
		<s:textfield disabled="true" name="empCode" label="Employee Code"/>
		<s:hidden name="empCode" />
		<s:hidden name="employee.empCode" />
		<s:if test="%{employee != null}">
			<s:textfield requiredLabel="true" name="employee.empName" maxlength="100" label="Employee Name" required="true"/>
			<s:textarea requiredLabel="true" name="employee.location" rows="5" cols="25" label="Employee Location" required="true"/>
			<s:textfield type="email" name="employee.email" requiredLabel="true" maxlength="100" label="Email" required="true"/>
			<s:textfield type="text" name="employee.dateOfBirth" requiredLabel="true" label="Employee DOB" required="true"/>
		<s:submit value="Submit"></s:submit>
		</s:if>
	</s:form>

</body>
</html>