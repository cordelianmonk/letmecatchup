<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="resources/index.css" />" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Lobster|Oswald'
	rel='stylesheet' type='text/css'>
<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div id="app-name">
			<img class="center-block img-responsive"
				src="<c:url value="resources/500x343.png"/>"></img>
		</div>
	</div>

	<div class="container">
		<div class="login-area center-block">
			<h4>New User Registration</h4>
			<form class="registration_form" action="<c:url value="/newUser"/> "
				method="post">

				<label for="fname">First Name</label> <br> <input type="text"
					name="firstname" id="firstname" class="form-control"><br>
				<label for="lname">Last Name</label> <br> <input type="text"
					name="lastname" id="lastname" class="form-control"><br> <label for="email">E-mail
					address</label> <br> <input type="text" name="email" id="email"
					class="form-control"><br> <label for="password">Password</label>
				<br> <input type="password" name="password" id="password"
					class="form-control"><br>

				<button type="submit" class="btn btn-sm btn-primary" id="register">Submit</button><br/>
				<a href="index.html">Signed-up already?</a>
			</form>
		</div>
	</div>

</body>
</html>