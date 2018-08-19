<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>addCountry</title>
</head>
<body>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<f:form action="addCountryInDb.htm" method="post" modelAttribute="data">
Enter Country Name:
<br>
<f:input path="countryName"/>
<f:button type="Submit">Insert</f:button>
</f:form>
</body>
</html>