<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>Employee Listing</legend>
	<div>
		<span>
			<a href="<s:url action="do-upload-employee"></s:url>">Upload Employee Details</a>
			<a href="<s:url action="download-employee"></s:url>" target="_blank">Download Employee Details</a>
		</span>
	</div>
	<div>
		<table>
			<tr>
				<th>Employee Code</th>
				<th>Employee Name</th>
				<th>Location</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Edit</th>
			</tr>
			
			<s:iterator value="empDto.employeeList"> 
				<tr>
					<td><s:property value="empCode"/></td>
					<td><s:property value="empName"/></td>
					<td><s:property value="location"/></td>
					<td><s:property value="email"/></td>
					<td><s:property value="dateOfBirth"/></td>
					<td>
						<s:a action="do-edit-employee">
						<s:param name="empCode" value="empCode"></s:param>
						Edit
						</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</div>
</fieldset>
</body>
</html>