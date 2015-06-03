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
<title>Welcome to Catch Me Up! Please log in.</title>
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
							src="<c:url value="resources/500x343.png"/>"></img><br />

						<c:if test="${!empty loginErrorMessage}">
							<div class="alert alert-dismissible alert-danger">
								<button type="button" class="close" data-dismiss="alert">×</button>
								<strong>${loginErrorMessage}</strong> Maybe there was a typo? Please do try again.
							</div>
						</c:if>
						
						<c:if test="${!empty registrationSuccessMessage}">
						<div class="alert alert-dismissible alert-success">
							<button type="button" class="close" data-dismiss="alert">×</button>
							<strong>${registrationSuccessMessage}</strong> You may now log in. 
						</div>
						</c:if>

						<form action="<c:url value="/checkUser"/> " method="post">
							<label for="email">Email Address</label><br /> <input type="text"
								name="email" id="email" class="form-control"></input><br /> <label
								for="password">Password</label> <br /> <input type="password"
								name="password" id="password" class="form-control"></input> <br />
							<button type="submit" class="btn btn-sm btn-primary" id="login">Submit</button>
						</form>

						<a href="new.html">Not yet registered? Click here.</a>

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
