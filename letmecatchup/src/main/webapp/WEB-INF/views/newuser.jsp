<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" />

<link href="<c:url value="resources/index.css" />" rel="stylesheet" />
<link href="<c:url value="resources/animate.css" />" rel="stylesheet" />

<link href='http://fonts.googleapis.com/css?family=Lobster|Oswald'
	rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/jquery-2.1.4.min.js" />"></script>
<script src="<c:url value="resources/bootstrap/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="master">

		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">

					<div class="user-login animated flipInY">

						<img class="center-block img-responsive animated flipInX"
							src="<c:url value="resources/500x343.png"/>"></img>
							
							<c:if test="${!empty registrationErrorMessage}">
							<div class="alert alert-dismissible alert-danger">
								<button type="button" class="close" data-dismiss="alert">×</button>
								<strong>${registrationErrorMessage}</strong> Maybe there was a typo? Please do try again.
							</div>
						</c:if>
						
						<form class="registration_form"
							action="<c:url value="/newUser"/> " method="post">

							<label for="firstname">First Name</label> <br/> <input
								type="text" name="firstname" id="firstname" class="form-control"></input><br/>
							<label for="lname">Last Name</label> <br/> <input type="text"
								name="lastname" id="lastname" class="form-control"></input><br/>
							<label for="email">E-mail address</label> <br/> <input
								type="text" name="email" id="email" class="form-control"></input><br/>
							<label for="password">Password</label> <br/> <input
								type="password" name="password" id="password"
								class="form-control"></input><br/>

							<button type="submit" class="btn btn-sm btn-primary"
								id="register">Submit</button>
							<br />

						</form>
						<a href="index.html">Signed-up already?</a>
					</div>
				</div>


			</div>


			<div class="container footer">
				<div class="row">
					<div class="col-md-6 col-md-offset-3">
						<div class="footer text-right"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>