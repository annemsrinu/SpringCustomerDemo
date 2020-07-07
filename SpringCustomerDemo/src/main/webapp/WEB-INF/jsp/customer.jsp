<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<head>
<script type="text/javascript">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function ClearForm(){
    document.MyForm.reset();
}
</script>
<title>Customer Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add a Customer</h1>
<body onload="ClearForm()">

	<form:form method="POST" action="/SpringCustomerDemo/customer/add"
		modelAttribute="customer" id="cform">
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:input path="country" /></td>
			</tr>
			 <tr>
               <td><form:label path = "balance">Account Balance</form:label></td>
               <td><form:input path = "balance" /></td>
            </tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>

			</tr>

		</table>

	</form:form>
	<br>
	<h3>Customer Details</h3>
	<c:if test="${!empty listCustomers}">
		<table class="tg">
			<tr>
				<th width="80">Customer ID</th>
				<th width="120">Customer Name</th>
				<th width="120">Customer Country</th>
				<th width="120">Account Balance</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listCustomers}" var="customer">
				<tr>
					<td><c:out value="${customer.id}" /></td>
					<td><c:out value="${customer.name}" /></td>
					<td><c:out value="${customer.country}" /></td>
					<td><c:out value="${customer.balance}" /></td>
					<td><a href="<c:url value='/edit/${customer.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${customer.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<table>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
	<tr><td></td></tr>
		<tr>
			<td colspan="2"><a href="/SpringCustomerDemo/login">Login</a></td>

		</tr>
	</table>

</body>
</html>