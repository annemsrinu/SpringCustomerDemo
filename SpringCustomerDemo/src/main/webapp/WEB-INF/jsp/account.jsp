<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Account Details</h2>
		<form:form method="POST" action="/SaveAccount">
	   		<table>
			    <tr>
			        <td><form:label path="id">Account ID:</form:label></td>
			        <td><form:input path="id" value="${account.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Account Balance:</form:label></td>
			        <td><form:input path="name" value="${account.balance}"/></td>
			    </tr>
			    
			   	<tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      	</tr>
			</table> 
		</form:form>
		
  <c:if test="${!empty accountList}">
		<h2>Account Details</h2>
	<table align="left" border="1">
		<tr>
			<th>Account ID</th>
			<th>Account Balance</th>
			<th>Actions on Row</th>
		</tr>

		<c:forEach items="${accountList}" var="category">
			<tr>
				<td><c:out value="${account.id}"/></td>
				<td><c:out value="${account.balance}"/></td>
				<td align="center"><a href="edit.html?id=${account.balance}">Edit</a> | <a href="delete.html?id=${account.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>