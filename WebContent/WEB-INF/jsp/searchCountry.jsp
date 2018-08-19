<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>searchCountry</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<f:form action="searchCountryInDb.htm" method="post" modelAttribute="data">
Enter Country Name's first character:
<br>
<f:input path="countryName"/>
<f:button type="Submit">Search</f:button>
</f:form>
<h1>${msg}</h1>
<table>
<tr>
	<td>countryId</td>
	<td>countryName</td>
</tr>

<c:forEach items="${searchCountryList}" var="countryList">
<tr>
	<td>${countryList.countryId}</td>
	<td>${countryList.countryName}</td>
</tr>
</c:forEach>
</table>
</body>
</html>