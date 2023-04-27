<%@page import="com.SportyShoes.entity.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
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
	<div align="center" class="container">
		<h5>Edit an existing product</h5>
	</div>
	<div class="container">
		<%
		String message = (String) request.getAttribute("message");
		if(message !=  null){%>
			<div class="mesagge"><%= message %></div>
		<%} %>
		<form action="editProduct" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="name">Product ID*: </label> <input type="text" readonly="readonly"
							class="form-control" value="${product.pid}" id="pid" name="pid">
					</div>
					<div class="form-group">
						<label for="name">Product Name*: </label> <input type="text" readonly="readonly"
							class="form-control" value="${product.name}" id="name" name="name">
					</div>
					<div class="form-group">
						<label for="price">Price*: </label> <input type="number"
							class="form-control" value="${product.price}" id="price" name="price">
					</div>
					<div class="form-group">
						<label for="sport">Sport Category: </label> 
						<select class="form-control" id="sport" name="sport">
							<option value=""> </option>
							<option value="dancing">dancing</option>
							<option value="hiking">hiking</option>
							<option value="running">running</option>
						</select>
					</div>
					<div class="form-group">
						<label for="sex">Sex Category: </label> 
						<select class="form-control" id="sex" name="sex">
							<option value=""> </option>
							<option value="female">female</option>
							<option value="male">male</option>
							<option value="unisex">unisex</option>
						</select>
					</div>
					<div>
						<br><input type="submit" class="btn btn-primary" value="Edit" />
					</div>
				</div>
			</div>
		</form>
	</div>
	
</body>
</html>