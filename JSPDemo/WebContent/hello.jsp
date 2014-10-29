<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Hello Page</title>
	<style>
		h2{
			color:red;
			text-shadow: 5px 5px 5px orange
		}
		
		.round{
			border-radius: 10px
		}
	</style>
</head>
<body>
<%@include file="page1.jsp" %>
<h2>This is a JSP demo</h2>
<form action="HelloServlet" method="post">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="name" placeholder="Your Name"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" placeholder="Your Age"/></td>
		</tr>
		<tr>
			<td></td>	
			<td>
				<input type="reset" value="Clear" class="round">
				<input type="submit" value="Submit" class="round">
			</td>
		</tr>
	</table>
</form>
</body>
</html>