<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring DB</title>
</head>
<body>


<form action="vishnu" method="GET">
    <input type="text" name="id" value="">
    <button type="submit">Search</button>
</form>

<a   href= "${pageContext.request.contextPath}/login">Login</a>
<a   href= "${pageContext.request.contextPath}/vishnu">Vishnu</a>



</body>
</html>