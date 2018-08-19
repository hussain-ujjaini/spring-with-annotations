<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<h1>${msg}</h1>
<table>
<f:form action="editCountryInDb.htm" method="POST" modelAttribute="data">
<tr>
	<td><f:input path="countryName"/></td>
	<f:hidden path="countryId"/>
	<td><f:button type="Submit">Update</f:button></td>
</tr>
</f:form>

<tr>
	<td>countryId</td>
	<td>countryName</td>
	<td>Delete</td>
	<td>Edit</td>
</tr>
<c:forEach items="${countryList}" var="countryList">
<tr>
	<td>${countryList.countryId}</td>
	<td>${countryList.countryName}</td>
	<td><a href="deleteCountry.htm?countryId=${countryList.countryId}">Delete</a></td>
	<td><a href="editCountry.htm?countryId=${countryList.countryId}">Edit</a></td>
</tr>
</c:forEach>
</table>


</body>
</html>