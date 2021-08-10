<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Ninja Gold Game</title>
	</head>
	<body>
		<div class="container">
			<div>
				<h3>Your Gold:<span class="goldCounter"><c:out value="${goldCount}"/></span></h3>
				<div class="boxes">
					<div class="box">
						<h3>Farm</h3>
						<p>(earns 10-20 gold)</p>
						<form method="POST" action="/farm">
							<button class="btn btn-primary">Find Gold!</button>
						</form>
					</div>
					<div class="box">
						<h3>Cave</h3>
						<p>(earns 5-10 gold)</p>
						<form method="POST" action="/cave">
							<button class="btn btn-primary">Find Gold!</button>
						</form>
					</div>
				</div>
				<h3>Activities:</h3>
				<div class="log">
					<c:forEach var="oneResult" items="${loglist}">
						<p><c:out value="${oneResult}"></c:out></p>
					</c:forEach>
				</div>
			</div>
		</div>
		
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
</html>