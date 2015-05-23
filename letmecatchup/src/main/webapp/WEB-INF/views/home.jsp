<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<link
	href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link 
	href="<c:url value="resources/index.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>CatchMeUp d**b</h1>
		</div>
	</div>

	<div class="container">
		<div class="login-area">
			<h2>Login</h2>
			<form class="login_form" action="<c:url value="/checkUser"/> "
				method="post">
				<label for="email">Email Address</label> <br> <input
					type="text" name="email" id="email"><br> <label
					for="password">Password</label> <br> <input type="password"
					name="password" id="password"><br>
				<button type="submit" class="btn btn-sm btn-primary" id="login">Submit</button>
			</form>
			<a href="new.html">New user?</a>
		</div>
	</div>
</body>
</html>
