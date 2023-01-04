<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored="false" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>this is help page</h1>
<%
/* String name=(String)request.getAttribute("name");
Integer id=(Integer)request.getAttribute("id");
LocalDateTime time=(LocalDateTime)request.getAttribute("time"); */
%>
<h1>Name is 
<%-- <%=name %> --%>
 ${name}
</h1>

<h1>id is 
<%-- <%=id %> --%>
${id}
</h1>

<h1>date And time is 
<%-- <%=time %> --%>
${time}
</h1>
<hr>

<c:forEach var="items" items="${marks }">

<h1>${items }</h1>
</c:forEach>


</body>
</html>