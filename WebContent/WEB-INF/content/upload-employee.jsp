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
	<div>
		<s:form action="upload-employee" enctype="multipart/form-data" validate="true" method="post">
			<fieldset>
				<legend>File Upload</legend>
				<h1><s:text name="test"/></h1>
				<s:property value="errorMessage"/>
				<p>
					<s:file name="employeeFile"/>
				</p>

				<p>
					<s:submit value="Upload" />
				</p>

				<a href="<s:url action="admin-home"/>">Cancel</a>
			</fieldset>
		</s:form>
	</div>
</body>
</html>