<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
 <h1>Login Here(No of visits By u :) &nbsp${visits})</h1>
 <hr>
 <label style="color:red">${error_msg}</label>
 <hr>
 <form:form action="${pageContext.request.contextPath}/login " method="post" commandName="user"><!-- fires /login with post request  -->
 
 
 <table>
 	<tr>
 		<td>Enter Username:</td>
 		<td><form:input path="username" type="text" name="username"></form:input>
 		<form:errors path="username" style="color:red;"></form:errors>
 		
 		</td>
 	</tr>
 
 	<tr>
 		<td>Enter Password:</td>
 		<td><form:input path="password" type="password" name="password"></form:input>
 		<form:errors path="password" style="color:red;"></form:errors>
 		</td>
 	</tr>
 	
 </table>
  <br><br>
 
 <input type="submit" value="Login"/>
 </form:form>
 
 
 
</body>
</html>