<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This Page 1</title>
</head>
<body>
<%
	session.setAttribute("session", "My session");
%>
<form action="page2.jsp">
	<input type="text" name="message"/>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>