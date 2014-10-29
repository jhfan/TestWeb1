<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Result Page</title>
	<style>
		h2{
			color: blue;
			text-shadow: 5px 5px 5px green
			}
	</style>
</head>
<body>
	<%--<h2><%=request.getAttribute("msg") %></h2> --%>
	<%@page import="com.mercury.beans.User" %>
	<jsp:useBean id="userInfo" scope="request" class="com.mercury.beans.UserInfo"/>
	<h2><jsp:getProperty name="userInfo" property="msg"/></h2>
	<table border="1" style="width:200px">
		<tr>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="user" items="${userInfo.users}">
			<tr>
			<td>${user.name}</td>
			<td>${user.age}</td>
			</tr>
		</c:forEach>
		<%--
	    <%
	    	for(User user:userInfo.getUsers()){
	    		out.print("<tr>");
	    		out.print("<td>" + user.getName() + "</td>");
	    		out.print("<td>" + user.getAge() + "</td>");
				out.print("</tr>");
	    	}
	    %> --%>
	</table>
</body>
</html>