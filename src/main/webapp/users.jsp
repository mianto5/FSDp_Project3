<%@page import="com.SportyShoes.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>
<body>
	<!--  Java inside HTML 
 -->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">SS</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index">Home</a></li>
					<%
					String id = (String) session.getAttribute("id");
					if (id == null) {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a>
					</li>
					<%
					}
					else if (id.equals("admin")) {
					%>
					<li class="nav-item"><a class="nav-link" href="products">View Products</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="users">View Users</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="report">Purchase Report</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
					</li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
	<%
	if (id == null) {
	%>
	<h1>Welcome on Sporty Shoes administrative portal</h1>
	<h5>Please log in to make any changes</h5>
	<%
	} else if (id.equals("admin")) {
	%>
	<div align="center" class="container">
		<h5>Users</h5><br>
		<form action="users" method="get">
			<div class="form-group">
				<input type="text" class="form-control" id="email" name="email" placeholder="Enter User's Email">
			</div>
			<input type="submit" class="btn btn-primary" value="Search by Email" />
		</form><br>
		<form action="users" method="get">
			<div class="form-group">
				<input type="text" class="form-control" id="lname" name="lname" placeholder="Enter User's Last Name">
			</div>
			<input type="submit" class="btn btn-primary" value="Search by Last Name" />
		</form>
	</div>
	<br>
	<div align="center">
        <table class="table" border="1" cellpadding="5">
            <tr>
                <th>User's E-mail</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>City</th>
                <th>Purchases IDs</th>
            </tr>
            <c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.email}</td>
					<td>${user.fname}</td>
					<td>${user.lname}</td>
					<td>${user.city}</td>
					<td>
						<c:forEach items="${user.purchases}" var="purchase">
							${purchase.pcid}<br>
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
        </table>
    </div>
	<%
	}
	%>
</body>
</html>