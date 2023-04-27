<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
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
		<h1>Hello admin!</h1><br>
		<h5>In case you want to change your password, fill this form:</h5><br>
		<div class="container">
		<%
		String message = (String) request.getAttribute("message");
		if(message !=  null){%>
		<div class="mesagge"><%= message %></div><br>
		<%} %>
		<form action="index" method="post">

			<div class="row">
				<div class="col-lg-6 col-lg-offset-3">
					<div class="form-group">
						<label for="old">Old Password*: </label> <input type="password"
							class="form-control" id="old" name="old">
					</div>
					<div class="form-group">
						<label for="new1">New Password*: </label> <input type="password"
							class="form-control" id="new1" name="new1">
					</div>
					<div class="form-group">
						<label for="new2">New Password Again*: </label> <input type="password"
							class="form-control" id="new2" name="new2">
					</div>
					<div>
						<br><input type="submit" class="btn btn-primary" value="Change password" />
					</div>
				</div>
			</div>
		</form>
		</div>
		<%
		}
		%>
</body>
</html>