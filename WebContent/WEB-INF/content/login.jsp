<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<fieldset>
	<legend>Login</legend>
		<s:property value="errorMessage"/>
	<div>
	<s:form action="login" validate="true">
				<s:textfield name="username" label="User Id"></s:textfield>
				<s:password name="password" label="Password"></s:password>
			<s:submit value="Login"></s:submit>
	</s:form>
	</div>
	</fieldset>
</body>
</html>