<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->
	<link type="text/css"
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	
	<form:form action="searchCustomer" method="POST">
		Search Customer
			<input type="text" name="search"/>
			<input type="submit" value="Search" 
		 		class="save"/>
		 		<input type="button" value="Back"
		 		onclick="window.location.href='${pageContext.request.contextPath}/customer/list'"/>
		</form:form>

	
	
	<div id="container">
	
		<div id="content">
		
		
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Customer"
					onClick="window.location.href='showFormForAdd';return false;"
					class="add-button"
			/>
			
			
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${customers}">
				
				<!--  Construct link for update-->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
				<c:url var="deleteLink" value="/customer/deleteCustomer">
				<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				
					<tr>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td><a href="${updateLink}">Update</a>
						|
						<a href="${deleteLink}"
						onClick="if (!(confirm('Are you sure to delete this customer'))) return false">Delete</a></td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









