<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is Page2</h1>
<P>Session value: <%=session.getAttribute("session") %></P>
<p>Request value: <%=request.getParameter("message") %></p>
<a href="page3.jsp">This is page3</a>
</body>
</html>