<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<title>MyProject - Dashboard</title>
</head>
<body>
	<div class="jumbotron bg-danger">
		<h3 class="text-center text-light">Welcome to the Dashboard !</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 border">
				<p class="text-danger text-center">Dummy Text</p>
				<hr>
			</div>
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 border">
				<p class="text-primary text-center">Dummy Text</p>
				<hr>
			</div>
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 border">
				<p class="text-success text-center">Dummy Text</p>
				<hr>
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 border">
				<p class="text-danger text-center">Dummy Text</p>
				<hr>
			</div>
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 border">
				<p class="text-primary text-center">Dummy Text</p>
				<hr>
			</div>
			<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-xs-12 border">
				<p class="text-success text-center">Dummy Text</p>
				<hr>
			</div>
		</div>
		<div class="row text-center">
			<a class="btn btn-sm btn-primary"
				href="${pageContext.request.contextPath}/">Back</a>
		</div>
	</div>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
</body>
</html>